import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1, jogador2;
    private String registro;
    private Jogada jogadas[];
    private int contadordejogadas = 0;

    private Peca pecasBrancas[];
    private Peca pecasPretas[];
    private int turno=0; //turno é um contador, se for par é a vez do jogador 1, se for impar é a vez do jogador 2

    public String criaRegistro(){
        registro = "";
        for(int i = 0; i < turno; i++){
            registro += jogadas[i].getColunaO() + jogadas[i].getLinhaO() + jogadas[i].getColunaD() + jogadas[i].getLinhaD() + " "; 
        }
        return registro;
    }   
    
    public String getNome1(){
        return jogador1.getNome();
    }
    
    public String getNome2(){
        return jogador2.getNome();
    }

    public Jogo() {
        jogadas = new Jogada[500];
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
        Scanner sc = new Scanner(System.in);
        this.tabuleiro = new Tabuleiro();
        System.out.println("Digite o nome do jogador 1: ");
        this.jogador1.setNome(sc.nextLine());
        System.out.println("Digite o nome do jogador 2: ");
        this.jogador2.setNome(sc.nextLine());

        this.jogador1.cor = "white";
        this.jogador2.cor = "black";


        this.pecasBrancas = new Peca[16];
        this.pecasBrancas[0] = new Torre("white");
        this.pecasBrancas[1] = new Cavalo("white");
        this.pecasBrancas[2] = new Bispo("white");
        this.pecasBrancas[3] = new Dama("white");
        this.pecasBrancas[4] = new Rei("white");
        this.pecasBrancas[5] = new Bispo("white");
        this.pecasBrancas[6] = new Cavalo("white");
        this.pecasBrancas[7] = new Torre("white");

        for(int i=8; i<16; i++){
            this.pecasBrancas[i] = new Peao("white");
        }

        this.pecasPretas = new Peca[16];
        this.pecasPretas[0] = new Torre("black");
        this.pecasPretas[1] = new Cavalo("black");
        this.pecasPretas[2] = new Bispo("black");
        this.pecasPretas[3] = new Dama("black");
        this.pecasPretas[4] = new Rei("black");
        this.pecasPretas[5] = new Bispo("black");
        this.pecasPretas[6] = new Cavalo("black");
        this.pecasPretas[7] = new Torre("black");

        for(int i=8; i<16; i++){
            this.pecasPretas[i] = new Peao("black");
        }

        for(int i=0; i<8; i++){
            this.tabuleiro.colocarPeca("1", Casa.transformNumeroColuna(i+1), this.pecasBrancas[i]);
            this.tabuleiro.colocarPeca("2", Casa.transformNumeroColuna(i+1), this.pecasBrancas[i+8]);
            this.tabuleiro.colocarPeca("8", Casa.transformNumeroColuna(i+1), this.pecasPretas[i]);
            this.tabuleiro.colocarPeca("7", Casa.transformNumeroColuna(i+1), this.pecasPretas[i+8]);
        }

    }

    public void iniciarJogo(){
        String linhaO, colunaO, linhaD, colunaD;
        boolean flagXeque = false;
        boolean flagMate = false;
        boolean flagCravada = false;
        Scanner sc = new Scanner(System.in);
        while (!flagMate){ // só acaba quando alguem ganha, ou encerra o jogo
            if(turno%2==0){ //vez do jog1
                System.out.println("Turno do jogador 1: "+jogador1.getNome());

                do {
                    imprimirTabuleiro();
                    if(turno>1) {
                        if(jogadas[turno-1].ehXeque()){
                            System.out.println("##### Xeque! ####");
                            flagXeque = true;
                        }
                    }
                    flagCravada = false;
                    String Stringjogada = jogador1.informaJogada();
                    if (Stringjogada.length() >= 4) { //verifica o tamanho da string e analisa cada caractere
                        colunaO = Stringjogada.substring(0, 1); //coluna da casa de origem
                        linhaO = Stringjogada.substring(1, 2); //linha da casa de origem
                        colunaD = Stringjogada.substring(2, 3);//coluna da casa de destino
                        linhaD = Stringjogada.substring(3, 4);//linha da casa de destino
                    }
                    else{
                        System.out.println("Jogada inválida, tente novamente"); //caso a string seja menor que 4
                        linhaO = "z"; //coloca valores inválidos para o programa não aceitar a jogada
                        colunaO = "0";
                        linhaD = "z";
                        colunaD = "0";
                    }

                    if(!flagXeque){
                        Jogada cravadaAux = new Jogada(tabuleiro, jogador1);
                        flagCravada = cravadaAux.estaCravado(linhaO, colunaO);
                    }
                    if(flagCravada){
                        System.out.println("Sua peça está cravada! Faça outra jogada");
                        linhaO = "0"; //coloca valores inválidos para o programa não aceitar a jogada
                        colunaO = "a";
                    }



                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD, jogador1)); //enquanto a jogada não for válida, pede uma nova jogada
                realizarJogada(linhaO,colunaO,linhaD,colunaD,jogador1);

                if(flagXeque){
                    Jogada aux = new Jogada(linhaO,colunaO,linhaD,colunaD,tabuleiro,jogador2);
                    flagMate = aux.ehXeque();
                    if(flagMate){
                        System.out.println("Xeque-Mate, o vencedor foi: "+ jogador2.getNome() + " jogando de " + jogador2.getCor()+". Parabens!");
                    }
                    else{
                        System.out.println("Saiu do xeque! Parabens");
                        flagXeque = false;
                    }
                }

            }
            else { //vez do jog2
                System.out.println("Turno do jogador 2: " + jogador2.getNome());
                do {
                    imprimirTabuleiro();
                    if(turno>1) {
                        if(jogadas[turno-1].ehXeque()){ //se branca deu xeque
                            System.out.println("##### Xeque! ####");
                            flagXeque = true;
                        }
                    }
                    flagCravada = false;
                    String Stringjogada = jogador2.informaJogada();
                    if (Stringjogada.length() >= 4) {
                        colunaO = Stringjogada.substring(0, 1);
                        linhaO = Stringjogada.substring(1, 2);
                        colunaD = Stringjogada.substring(2, 3);
                        linhaD = Stringjogada.substring(3, 4);
                    }
                    else{
                        System.out.println("Jogada inválida, tente novamente");
                        linhaO = "z";
                        colunaO = "0";
                        linhaD = "z";
                        colunaD = "0";
                    }
                    if(!flagXeque){
                        Jogada cravadaAux = new Jogada(tabuleiro, jogador1);
                        flagCravada = cravadaAux.estaCravado(linhaO, colunaO);
                    }
                    if(flagCravada){
                        System.out.println("Sua peça está cravada! Faça outra jogada");
                        linhaO = "0"; //coloca valores inválidos para o programa não aceitar a jogada
                        colunaO = "a";
                    }




                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD, jogador2));

                realizarJogada(linhaO,colunaO,linhaD,colunaD,jogador2);
                if(flagXeque){
                    Jogada aux = new Jogada(linhaO,colunaO,linhaD,colunaD,tabuleiro,jogador1);
                    flagMate = aux.ehXeque();
                    if(flagMate){
                        System.out.println("Xeque-Mate, o vencedor foi: "+jogador1.getNome() + " jogando de " + jogador1.getCor()+". Parabens!");
                    }
                    else{
                        System.out.println("Saiu do xeque! Parabens");
                        flagXeque = false;
                    }
                }
            }

            //incrementa o turno
            turno++;
        }
    }


    public boolean jogadaValida(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){
        // ve se a jogada é valida, se for, retorna true, se não, retorna false
        try {

            if (tabuleiro.noLimite(linhaO, colunaO) && tabuleiro.noLimite(linhaD, colunaD)) { //se as casas estiverem dentro do tabuleiro

                Jogada jogada = new Jogada(linhaO, colunaO, linhaD, colunaD, tabuleiro, jogador);
                if (!jogada.ehValida()) { // se a jogada não for valida
                    return false;
                }

                return true;
            }
            else if (linhaO=="0" && colunaO=="a"){
                return false;
            }
            else { // Se a casa estiver fora do tabuleiro
                System.out.println("jogada invalida, movimento fora do tabuleiro");
                return false;
            }
        }
        catch (Exception e){
            System.out.println("jogada invalida, movimento fora do tabuleiro");
            return false;
        }
    }

    public void realizarJogada(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){


            Peca pecaRemovida= tabuleiro.tirarPeca(linhaO,colunaO);//pega a peça da casa de origem
            Peca pecaCapturada= tabuleiro.colocarPeca(linhaD,colunaD,pecaRemovida); //coloca a peça na casa de destino

            if(pecaCapturada!=null){ //se tiver peça na casa de destino, captura a peça
                jogador.capturaPeca(pecaCapturada.desenho());
            }
            jogadas[contadordejogadas]= new Jogada(linhaO,colunaO,linhaD,colunaD,tabuleiro,jogador); //adiciona a jogada no vetor de jogadas
            contadordejogadas ++;
    }

    public void imprimirTabuleiro(){
        System.out.println("Jogador 1: " + jogador1.getNome());
        System.out.print(jogador1.pecasCapturadas());
        System.out.println("\n\nTabuleiro: ");
        tabuleiro.imprimirTabuleiro();
        System.out.print("\nJogador 2: " + jogador2.getNome() + "\n");
        System.out.println(jogador2.pecasCapturadas());
    }

    public Jogador escolheJogador(int jogador){
        if(jogador == 1){
            return jogador1;
        }
        else{
            return jogador2;
        }
    }

}
