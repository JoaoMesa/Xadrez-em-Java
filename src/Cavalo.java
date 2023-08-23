public class Cavalo extends Peca{


    public Cavalo(String cor) {
        this.cor = cor;
        if (cor.equals("white")) {
            this.simbolo = "♞";
        } else {
            this.simbolo = "♘";
        }
    }

    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

        int linhaOrigem = Integer.parseInt(linhaO); //transforma a string em int
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);//transforma a string em int
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);


        if(linhaDestino == linhaOrigem + 2 || linhaDestino == linhaOrigem - 2){
            if(colunaDestino == colunaOrigem + 1 || colunaDestino == colunaOrigem - 1){
                return true;
            }
        }
        else if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem - 1){
            if(colunaDestino == colunaOrigem + 2 || colunaDestino == colunaOrigem - 2){
                return true;
            }
        }
        //mesma coisa para o preto, mas o tabuleiro é invertido

        return false;

    }

    public String caminho(String colunaO,String linhaO,String colunaD,String linhaD) {//retorna o caminho que a peça vai fazer

        return colunaO+linhaO+colunaD+linhaD;
    }
}
