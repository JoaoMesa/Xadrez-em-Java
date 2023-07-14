import java.util.Scanner;

public class Jogador {
    private String nome;
    public peça peças[16]; //cada jogador tem 16 pecas

    public String peçasCapturadas;

    public String cor;


    public Jogador(String nome) { //cosntrutor
        this.nome = nome;
    }

    public String informaJogada(){
        System.out.println("Digite a posição da peça que deseja mover: \n");
        Scanner sc = new Scanner(System.in);
        String posicao = sc.nextLine();
        return posicao;
    }

    public String pecasCapturadas(){
        System.out.println("Peças capturadas: \n");
        return peçasCapturadas;
    }


    public String getNome() {
        return nome;
    }

    public peça[] getPeças() {
        return peças;
    }

    public String getPeçasCapturadas() {
        return peçasCapturadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeças(peça[] peças) {
        this.peças = peças;
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
