import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1, jogador2;
    private String registro;
    private Jogada jogadas[];



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
        iniciarJogo();
    }

    public void iniciarJogo(){
        int turno=0; //turno é um contador, se for par é a vez do jogador 1, se for impar é a vez do jogador 2
        String linhaO, colunaO, linhaD, colunaD;
        Scanner sc = new Scanner(System.in);
        while (true){ // só acaba quando alguem ganha, ou encerra o jogo
            if(turno%2==0){ //vez do jog1
                System.out.println("Turno do jogador 1: "+jogador1.getNome());
                imprimirTabuleiro();
                do {
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

                System.out.println("peças capturadas: "+jogador1.pecasCapturadas());
            }
            else { //vez do jog2
                System.out.println("Turno do jogador 2: " + jogador2.getNome());
                imprimirTabuleiro();
                do {
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

                System.out.println("peças capturadas: " + jogador2.pecasCapturadas());
            }

            //incrementa o turno
            turno++;
        }
    }


    public boolean jogadaValida(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){
        // ve se a jogada é valida, se for, retorna true, se não, retorna false
        if(colunaO.charAt(0)>='a' && colunaO.charAt(0)<='h' && colunaD.charAt(0)>='a' && colunaD.charAt(0)<='h' && linhaO.charAt(0)>='1' && linhaO.charAt(0)<='8' && linhaD.charAt(0)>='1' && linhaD.charAt(0)<='8'){
            Peao peca = tabuleiro.getPeca(linhaO,colunaO);
            if(peca == null){ // se não tiver peça na casa de origem
                System.out.printf("Nao existe peca na casa inicial");
                return false;
            }
            if(!peca.getCor().equals(jogador.cor)){// se a peça não for da cor do jogador
                System.out.printf("Movimento invalido, o jogador %s nao pode mexer as pecas de outra cor\n", jogador.cor);
                return false;
            }
            boolean destinoOcupado = (tabuleiro.getPeca(linhaD, colunaD) != null);// se tiver peça na casa de destino
            if(!peca.movimentoValido(linhaO,colunaO,linhaD,colunaD, destinoOcupado)){ // se o movimento não for valido
                System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.getSimbolo());
                return false;
            }
            String caminho = peca.caminho(linhaO,colunaO,linhaD,colunaD);
            Jogada novaJogada = new Jogada(linhaO,colunaO,linhaD,colunaD);
            if(!novaJogada.ehValida(caminho,tabuleiro)) { // se a jogada não for valida
                System.out.println("Movimento invalido, o peao nao mexe assim");
                return false;
            }
            return true;
        }
        else{
            System.out.println("jogada invalida");
            return false;
        }
    }

    public void realizarJogada(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){


            Peao pecaRemovida= tabuleiro.tirarPeca(linhaO,colunaO);//pega a peça da casa de origem
            Peao pecaCapturada= tabuleiro.colocarPeca(linhaD,colunaD,pecaRemovida); //coloca a peça na casa de destino

            if(pecaCapturada!=null){ //se tiver peça na casa de destino, captura a peça
                jogador.capturaPeca(pecaCapturada.getSimbolo());
            }



    }

    public void imprimirTabuleiro(){
        System.out.println("Tabuleiro: \n");
        tabuleiro.imprimirTabuleiro();
    }


}
