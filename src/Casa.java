import java.lang.String;
public class Casa {
    private String cor;
    private String linha, coluna;
    private Peao peca;
    static final String letrasColuna = "abcdefgh";

    public Casa(String cor, String linha, String coluna) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.peca = null;
    }

    public static String transformNumeroColuna(int coluna){
        return String.valueOf(letrasColuna.charAt(coluna -1));
    }
    public String getCor() {
        return cor;
    }

    public String getLinha() {
        return linha;
    }

    public String getColuna() {
        return coluna;
    }

    public Peao getPeca() {
        return peca;
    }

    public void colocaPeca(Peao peca) {
        this.peca = peca;
    }

    public void tiraPeca() {
        this.peca = null;
    }

    public  boolean temPeca(){
        if(this.peca != null){
            return true;
        }
        return false;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }
}
