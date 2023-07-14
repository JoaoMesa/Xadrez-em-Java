import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1, jogador2;
    private String registro;
    private Jogada jogada;

    public Jogo() {
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
        String posicaoO, posicaoD;
        Scanner sc = new Scanner(System.in);
        while (true){ // só acaba quando alguem ganha, ou encerra o jogo
            if(turno%2==0){ //vez do jog1
                System.out.println("Turno do jogador 1: "+jogador1.getNome());
                imprimirTabuleiro();
                posicaoO = sc.nextLine();
                posicaoD = sc.nextLine();
                inserirPosicao(jogador1, posicaoO, posicaoD);

                System.out.println("peças capturadas: "+jogador1.pecasCapturadas());
            }
            else { //vez do jog2
                System.out.println("Turno do jogador 2: " + jogador2.getNome());
                posicaoO = inserirPosicao(jogador2);
                posicaoD = inserirPosicao(jogador2);
                System.out.println("peças capturadas: " + jogador2.pecasCapturadas());
            }
            if (posicaoO=="parar"||posicaoD=="parar"){ //se alguem quiser parar o jogo
                System.out.println("Jogo encerrado");
                break;
            }
            //incrementa o turno
            turno++;
        }
    }

    public void inserirPosicao(Jogador jogador, String posicaoO, String posicaoD){
        String posicao;
        while (true) { //se inserir posicao errada, pede para inserir novamente
            posicao = jogador.informaJogada();
            if (jogadaValida()) {
                realizarJogada();
                break;
            }
        }
    }

    public boolean jogadaValida(linhaO, colunaO, linhaD, colunaD){ //IMPLEMENTAR, como chama o metodo ehvalida da classe jogada?
        return true;
    }

    public void realizarJogada(linhaO, colunaO, linhaD, colunaD){ //como vai ser implementada no tabuleiro?
        //IMPLEMENTAR
    }

    public void imprimirTabuleiro(){
        System.out.println("Tabuleiro: \n");
        System.out.println(tabuleiro.toString());
    }


}
