public class Caminho {

    Casa casaInicial, casaFinal;

    Caminho (String linhaO, String colunaO, String linhaD, String colunaD){
        casaInicial.setLinha(linhaO);
        casaInicial.setColuna(colunaO);
        casaFinal.setLinha(linhaD);
        casaFinal.setColuna(colunaD);

        this.casaInicial = casaInicial;
        this.casaFinal = casaFinal;
    }

    public boolean  estaLivre(){

        if(casaFinal.temPeca()){
            return false;
        }
        else{
            return true;
        }

    }

    public Casa casaInicial(){
        return casaInicial;
    }

    public Casa casaFinal(){
        return casaFinal;
    }
}
