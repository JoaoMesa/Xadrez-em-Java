public class Peao {
    private String cor;
    private String simbolo;
    private Casa casa;

    public Peao(String cor, Casa casa) {
        this.cor = cor;
        this.casa = casa;
        if (cor.equals("white")) {
            this.simbolo = "♟";
        } else {
            this.simbolo = "♙";
        }
    }

    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD, boolean destinoOcupado){

        int linhaOrigem = Integer.parseInt(linhaO);
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);

        if(this.cor.equals("white")){
            if(linhaOrigem == 2){
                if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem + 2){
                    if(colunaDestino == colunaOrigem && !destinoOcupado){
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem + 1){
                    System.out.println(destinoOcupado);
                    if(colunaDestino == colunaOrigem && !destinoOcupado){
                        return true;
                    }
                    else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) && destinoOcupado){
                        return true;
                    }
                }
            }
        }
        else{  //preto
            if(linhaOrigem == 7){
                if(linhaDestino == linhaOrigem - 1 || linhaDestino == linhaOrigem - 2){
                    if(colunaDestino == colunaOrigem && !destinoOcupado){
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem - 1){
                    System.out.println(destinoOcupado);
                    if(colunaDestino == colunaOrigem && !destinoOcupado){
                        return true;
                    }else if((colunaDestino - 1 == colunaOrigem || colunaDestino + 1 == colunaOrigem) && destinoOcupado){
                        return true;
                        }
                    }

                }
            }

        return false;

    }

    public String caminho(String linhaO,String colunaO,String linhaD,String colunaD){

        Caminho caminho = new Caminho(linhaO,colunaO,linhaD,colunaD);
        int linhaOrigem = Integer.parseInt(linhaO);
        int colunaOrigem = Casa.tranformaColunaNumero(colunaO);
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Casa.tranformaColunaNumero(colunaD);
        String caminhoFinal = "";

        if (colunaDestino!=colunaOrigem){
            return linhaO + colunaO+ linhaD + colunaD;
        }
        else {
            for(int i = linhaOrigem; i <= linhaDestino; i++){
                caminhoFinal += i + colunaOrigem;
            }
        }
        return caminhoFinal;
    }

    public String getSimbolo() {
        return simbolo;
    }
    public String getCor() {
        return cor;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
}
