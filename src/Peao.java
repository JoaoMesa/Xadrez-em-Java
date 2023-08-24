public class Peao extends Peca{


    public Peao(String cor) {
        this.cor = cor;
        if (cor.equals("white")) {
            this.simbolo = "♟";
        } else {
            this.simbolo = "♙";
        }
    }

    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

        int linhaOrigem = Integer.parseInt(linhaO); //transforma a string em int
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);//transforma a string em int
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);

        if(this.cor.equals("white")){
            if(linhaOrigem == 2){//primeiro movimento
                if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem + 2){//movimento de 1 ou 2 casas
                    if(colunaDestino == colunaOrigem){//movimento reto
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem + 1){//movimento que não seja o primeiro
                    if(colunaDestino == colunaOrigem ){//movimento reto
                        return true;
                    }
                    else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) ){//vai capturar
                        return true;
                    }
                }
            }
        }
        //mesma coisa para o preto, mas o tabuleiro é invertido
        else{  //preto
            if(linhaOrigem == 7){
                if(linhaDestino == linhaOrigem - 1 || linhaDestino == linhaOrigem - 2){
                    if(colunaDestino == colunaOrigem ){
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem - 1){

                    if(colunaDestino == colunaOrigem ){
                        return true;
                    }else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) ){
                        return true;
                        }
                    }

                }
            }

        return false;

    }

    public String caminho(String colunaO,String linhaO,String colunaD,String linhaD){//retorna o caminho que a peça vai fazer

        int linhaOrigem = Integer.parseInt(linhaO);
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);
        String caminhoFinal = "";

        if (colunaDestino!=colunaOrigem){
            return colunaO+linhaO+colunaD+linhaD;
        }
        else {
            if(this.cor.equals("white")){
                if(linhaOrigem == 2){//primeiro movimento
                    if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem + 2){//movimento de 1 ou 2 casas
                        if(colunaDestino == colunaOrigem){//movimento reto
                            for(int i = linhaOrigem; i <= linhaDestino; i++){
                                caminhoFinal +=  colunaO + i;
                            }
                        }
                    }
                }
                else{
                    if(linhaDestino == linhaOrigem + 1){//movimento que não seja o primeiro
                        if(colunaDestino == colunaOrigem ){//movimento reto
                            caminhoFinal +=  colunaO + linhaOrigem;
                            caminhoFinal +=  colunaD + linhaDestino;
                        }
                        else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) ){//vai capturar
                            caminhoFinal +=  colunaO + linhaOrigem;
                            caminhoFinal +=  colunaD + linhaDestino;
                        }
                    }
                }
            }
            //mesma coisa para o preto, mas o tabuleiro é invertido
            else{  //preto
                if(linhaOrigem == 7){
                    if(linhaDestino == linhaOrigem - 1 || linhaDestino == linhaOrigem - 2){
                        if(colunaDestino == colunaOrigem ){
                            for(int i = linhaOrigem; i >= linhaDestino; i--){
                                caminhoFinal +=  colunaO + i;
                            }
                        }
                    }
                }
                else{
                    if(linhaDestino == linhaOrigem - 1){

                        if(colunaDestino == colunaOrigem ){
                            caminhoFinal +=  colunaO + linhaOrigem;
                            caminhoFinal +=  colunaD + linhaDestino;
                        }else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) ){
                            caminhoFinal +=  colunaO + linhaOrigem;
                            caminhoFinal +=  colunaD + linhaDestino;
                        }
                    }
                }
            }
        }
        return caminhoFinal;
    }


}
