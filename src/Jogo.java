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

        this.jogador1.cor = "branco";
        this.jogador2.cor = "preto";
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
                        linhaO = Stringjogada.substring(0, 1);
                        colunaO = Stringjogada.substring(1, 2);
                        linhaD = Stringjogada.substring(2, 3);
                        colunaD = Stringjogada.substring(3, 4);
                    }
                    else{
                        System.out.println("Jogada inválida, tente novamente");
                        linhaO = "z";
                        colunaO = "0";
                        linhaD = "z";
                        colunaD = "0";
                    }
                } while (!jogadaValida(linhaO, colunaO, linhaD, colunaD));

                System.out.println("peças capturadas: "+jogador1.pecasCapturadas());
            }
            else { //vez do jog2
                System.out.println("Turno do jogador 2: " + jogador2.getNome());

                System.out.println("peças capturadas: " + jogador2.pecasCapturadas());
            }

            //incrementa o turno
            turno++;
        }
    }


    public boolean jogadaValida(String linhaO, String colunaO, String linhaD, String colunaD){ //IMPLEMENTAR, como chama o metodo ehvalida da classe jogada?
        if(linhaO.charAt(0)>='a' && linhaO.charAt(0)<='h' && linhaD.charAt(0)>='a' && linhaD.charAt(0)<='h' && colunaO.charAt(0)>='1' && colunaO.charAt(0)<='8' && colunaD.charAt(0)>='1' && colunaD.charAt(0)<='8'){
            Jogada jogada = new Jogada(linhaO, colunaO, linhaD, colunaD);
            return true;
        }
        else{
            return false;
        }

    }

    //public void realizarJogada(linhaO, colunaO, linhaD, colunaD){ //como vai ser implementada no tabuleiro?
        //IMPLEMENTAR
    //}

    public void imprimirTabuleiro(){
        System.out.println("Tabuleiro: \n");
        tabuleiro.imprimirTabuleiro();
    }


}
