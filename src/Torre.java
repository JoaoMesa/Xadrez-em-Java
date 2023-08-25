public class Torre extends Peca{

    public Torre(String cor) {
        this.cor = cor;
        if (cor.equals("white")) {
            this.simbolo = "♜";
        } else {
            this.simbolo = "♖";
        }
    }

    @Override
    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

        int linhaOrigem = Integer.parseInt(linhaO); //transforma a string em int
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);//transforma a string em int
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);

        if (colunaDestino!=colunaOrigem && linhaDestino==linhaOrigem){
            return true;
        }
        else if (colunaDestino==colunaOrigem && linhaDestino!=linhaOrigem){
            return true;
        }
        else{
            return false;
        }




    }

    @Override
    public String caminho(String colunaO,String linhaO,String colunaD,String linhaD) {//retorna o caminho que a peça vai fazer//TODO: TESTAR

        int colunaOrigem = (int)colunaO.charAt(0)-96;
        int linhaOrigem = Integer.parseInt(linhaO);
        int colunaDestino = (int)colunaD.charAt(0)-96;
        int linhaDestino = Integer.parseInt(linhaD);
        String caminho = "";
        if(movimentoValido(linhaO,colunaO,linhaD,colunaD)){
            while(colunaOrigem!=colunaDestino || linhaOrigem!=linhaDestino){
                if(colunaOrigem<colunaDestino){
                    colunaOrigem++;
                    caminho += (char)(colunaOrigem+96)+""+linhaOrigem;
                }else if(colunaOrigem>colunaDestino){
                    colunaOrigem--;
                    caminho += (char)(colunaOrigem+96)+""+linhaOrigem;
                }
                if(linhaOrigem<linhaDestino){
                    linhaOrigem++;
                    caminho += (char)(colunaOrigem+96)+""+linhaOrigem;
                }else if(linhaOrigem>linhaDestino){
                    linhaOrigem--;
                    caminho += (char)(colunaOrigem+96)+""+linhaOrigem;
                }
            }
            caminho += (char)(colunaDestino+96)+""+linhaDestino;
        }
        return caminho;
    }
}
