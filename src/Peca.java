public abstract class Peca {

    protected String cor;
    protected String simbolo;

    public abstract String caminho(String colunaO,String linhaO,String colunaD,String linhaD);

    public String desenho() {
        return simbolo;
    }
    public String getCor() {
        return cor;
    }

    public abstract boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD);
}
