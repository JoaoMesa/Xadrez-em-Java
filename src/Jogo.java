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
        int turno=0;
        String linhaO, colunaO, linhaD, colunaD;
        Scanner sc = new Scanner(System.in);
        while (true){ // só acaba quando alguem ganha, ou encerra o jogo
            if(turno%2==0){ //vez do jog1
                System.out.println("Turno do jogador 1: "+jogador1.getNome());
                imprimirTabuleiro();
                do {
                    String Stringjogada = jogador1.informaJogada();
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
                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD, jogador1));
                System.out.println("antes");
                realizarJogada(linhaO,colunaO,linhaD,colunaD,jogador1);
                System.out.println("depois");

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


    public boolean jogadaValida(String linhaO, String colunaO, String linhaD, String colunaD, Jogador jogador){ //IMPLEMENTAR, como chama o metodo ehvalida da classe jogada?
        if(colunaO.charAt(0)>='a' && colunaO.charAt(0)<='h' && colunaD.charAt(0)>='a' && colunaD.charAt(0)<='h' && linhaO.charAt(0)>='1' && linhaO.charAt(0)<='8' && linhaD.charAt(0)>='1' && linhaD.charAt(0)<='8'){
            Peao peca = tabuleiro.getPeca(linhaO,colunaO);
            if(peca == null){
                System.out.printf("Nao existe peca na casa inicial");
                return false;
            }
            if(!peca.getCor().equals(jogador.cor)){
                System.out.printf("Movimento invalido, o jogador %s nao pode mexer as pecas de outra cor\n", jogador.cor);
                return false;
            }
            boolean destinoOcupado = (tabuleiro.getPeca(linhaD, colunaD) != null);
            if(!peca.movimentoValido(linhaO,colunaO,linhaD,colunaD, destinoOcupado)){
                System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.getSimbolo());
                return false;
            }
            String caminho = peca.caminho(linhaO,colunaO,linhaD,colunaD);
            Jogada novaJogada = new Jogada(linhaO,colunaO,linhaD,colunaD);
            if(!novaJogada.ehValida(caminho,tabuleiro)) {
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


            Peao pecaRemovida= tabuleiro.tirarPeca(linhaO,colunaO);
            Peao pecaCapturada= tabuleiro.colocarPeca(linhaD,colunaD,pecaRemovida);

            if(pecaCapturada!=null){
                jogador.capturaPeca(pecaCapturada.getSimbolo());
            }



    }

    public void imprimirTabuleiro(){
        System.out.println("Tabuleiro: \n");
        tabuleiro.imprimirTabuleiro();
    }


}
