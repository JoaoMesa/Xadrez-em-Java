public class Bispo extends Peca{

    public Bispo(String cor) {
        this.cor = cor;
        if (cor.equals("white")) {
            this.simbolo = "♝";
        } else {
            this.simbolo = "♗";
        }
    }

    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

        int linhaOrigem = Integer.parseInt(linhaO); //transforma a string em int
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);//transforma a string em int
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);


        if(linhaDestino - linhaOrigem == colunaDestino - colunaOrigem || linhaDestino - linhaOrigem == colunaOrigem - colunaDestino){
            return true;
        }

        return false;

    }

    public String caminho(String colunaO,String linhaO,String colunaD,String linhaD) {//retorna o caminho que a peça vai fazer

        return colunaO+linhaO+colunaD+linhaD;
    }


}
