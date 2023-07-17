public class Peao {
    private String cor;
    private String simbolo;
    private Casa casa;

    public Peao(String cor, Casa casa) {
        this.cor = cor;
        this.casa = casa;
        if (cor.equals("branco")) {
            this.simbolo = "♙";
        } else {
            this.simbolo = "♟";
        }
    }

    public boolean movimentoValido(String linhaO, String colunaO, String linhaD, String colunaD){

        int linhaOrigem = Integer.parseInt(linhaO);
        int colunaOrigem = Integer.parseInt(colunaO);
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Integer.parseInt(colunaD);

        if(this.cor.equals("branco")){
            if(linhaOrigem == 2){
                if(linhaDestino == linhaOrigem + 1 || linhaDestino == linhaOrigem + 2){
                    if(colunaDestino == colunaOrigem){
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem + 1){
                    if(colunaDestino == colunaOrigem){
                        return true;
                    }
                }
            }
        }
        else{  //preto
            if(linhaOrigem == 7){
                if(linhaDestino == linhaOrigem - 1 || linhaDestino == linhaOrigem - 2){
                    if(colunaDestino == colunaOrigem){
                        return true;
                    }
                }
            }
            else{
                if(linhaDestino == linhaOrigem - 1){
                    if(colunaDestino == colunaOrigem){
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
        int colunaOrigem = Integer.parseInt(colunaO);
        int linhaDestino = Integer.parseInt(linhaD);
        int colunaDestino = Integer.parseInt(colunaD);
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
