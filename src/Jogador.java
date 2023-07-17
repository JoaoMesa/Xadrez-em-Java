import java.util.Scanner;

public class Jogador {
    private String nome;
    public Peao peças[]; //cada jogador tem 16 pecas

    public String peçasCapturadas;

    public String cor;


    public Jogador(String nome) { //cosntrutor

        this.nome = nome;
        this.peças = new Peao[16];
        peçasCapturadas = "";
    }

    public String informaJogada(){
        System.out.println( "\n" + this.nome + ", digite a posição da peça que deseja mover: \n");
        Scanner sc = new Scanner(System.in);
        String posicaoO = sc.nextLine();
        System.out.println("\n" + this.nome + ", digite para onde a peça deve mover: \n");
        String posicaoD = sc.nextLine();
        return posicaoO + posicaoD;
    }

    public String pecasCapturadas(){
        System.out.println("Peças capturadas: \n");
        return peçasCapturadas;
    }

    public void capturaPeca(String peca){
        this.peçasCapturadas+=peca;
    }


    public String getNome() {
        return nome;
    }

    public String getPeçasCapturadas() {
        return peçasCapturadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setPeçasCapturadas(String peçasCapturadas) {
        this.peçasCapturadas = peçasCapturadas;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
}
