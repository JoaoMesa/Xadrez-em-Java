public class Rei extends Peca{

        public Rei(String cor) {
            this.cor = cor;
            if (cor.equals("white")) {
                this.simbolo = "♚";
            } else {
                this.simbolo = "♔";
            }
        }

        @Override
        public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

            int linhaOrigem = Integer.parseInt(linhaO); //transforma a string em int
            int colunaOrigem = Casa.tranformaColunaNumero(colunaO);//transforma a string em int
            int linhaDestino = Integer.parseInt(linhaD);
            int colunaDestino = Casa.tranformaColunaNumero(colunaD);

            if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem - 1){
                if(colunaDestino == colunaOrigem + 1 || colunaDestino == colunaOrigem - 1){
                    return true;
                }
            }
             if(linhaDestino == linhaOrigem){
                if(colunaDestino == colunaOrigem + 1 || colunaDestino == colunaOrigem - 1){
                    return true;
                }
            }
             if(colunaDestino == colunaOrigem){
                if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem - 1){
                    return true;
                }
            }

            return false;

        }
    @Override
    public String caminho(String colunaO,String linhaO,String colunaD,String linhaD) {//retorna o caminho que a peça vai fazer

        String caminho = "";
        if(movimentoValido(linhaO,colunaO,linhaD,colunaD)){
           caminho= colunaO+linhaO+colunaD+linhaD;
        }
        return caminho;
    }
}
