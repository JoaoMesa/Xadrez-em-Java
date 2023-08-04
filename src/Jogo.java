import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1, jogador2;
    private String registro;
    private Jogada jogadas[];

    private Peao pecasBrancas[];
    private Peao pecasPretas[];



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


        this.pecasBrancas = new Peao[16];
        for(int i = 0; i < 8; i++){
            this.pecasBrancas[i] = new Peao("white");
        }
        this.pecasPretas = new Peao[16];
        for(int i = 0; i < 8; i++){
            this.pecasPretas[i] = new Peao("black");
        }

        for(int i = 1; i < 9; i++){ //coloca as peças
            String coluna = Casa.letrasColuna.charAt(i-1)+"";
            tabuleiro.colocarPeca(2+"", coluna, pecasBrancas[i-1]);
            tabuleiro.colocarPeca(7+"", coluna, pecasPretas[i-1]);
        }

    }

    public void iniciarJogo(){
        int turno=0; //turno é um contador, se for par é a vez do jogador 1, se for impar é a vez do jogador 2
        String linhaO, colunaO, linhaD, colunaD;
        Scanner sc = new Scanner(System.in);
        while (true){ // só acaba quando alguem ganha, ou encerra o jogo
            if(turno%2==0){ //vez do jog1
                System.out.println("Turno do jogador 1: "+jogador1.getNome());

                do {
                    imprimirTabuleiro();
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
                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD, jogador1)); //enquanto a jogada não for válida, pede uma nova jogada
                realizarJogada(linhaO,colunaO,linhaD,colunaD,jogador1);

            }
            else { //vez do jog2
                System.out.println("Turno do jogador 2: " + jogador2.getNome());

                do {
                    imprimirTabuleiro();
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

                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD, jogador2));
                realizarJogada(linhaO,colunaO,linhaD,colunaD,jogador2);

            }

            //incrementa o turno
            turno++;
        }
    }


    public boolean jogadaValida(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){
        // ve se a jogada é valida, se for, retorna true, se não, retorna false
        if(tabuleiro.noLimite(linhaO,colunaO) && tabuleiro.noLimite(linhaD,colunaD)){ //se as casas estiverem dentro do tabuleiro

            Jogada jogada = new Jogada(linhaO,colunaO,linhaD,colunaD, tabuleiro, jogador);
            if(!jogada.ehValida()){ // se a jogada não for valida
                return false;
            }

            return true;
        }
        else{ // Se a casa estiver fora do tabuleiro
            System.out.println("jogada invalida, movimento fora do tabuleiro");
            return false;
        }
    }

    public void realizarJogada(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){


            Peao pecaRemovida= tabuleiro.tirarPeca(linhaO,colunaO);//pega a peça da casa de origem
            Peao pecaCapturada= tabuleiro.colocarPeca(linhaD,colunaD,pecaRemovida); //coloca a peça na casa de destino

            if(pecaCapturada!=null){ //se tiver peça na casa de destino, captura a peça
                jogador.capturaPeca(pecaCapturada.desenho());
            }



    }

    public void imprimirTabuleiro(){
        System.out.println("Jogador 1: " + jogador1.getNome());
        System.out.print(jogador1.pecasCapturadas());
        System.out.println("Tabuleiro: ");
        tabuleiro.imprimirTabuleiro();
        System.out.println("Jogador 2: " + jogador2.getNome());
        System.out.println(jogador2.pecasCapturadas());
    }


}
