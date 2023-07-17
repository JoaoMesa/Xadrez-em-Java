public class Caminho {

    Casa casaInicial, casaFinal;

    Caminho (String linhaO, String colunaO, String linhaD, String colunaD){
        casaInicial = new Casa( "null", linhaO, colunaO);
        casaFinal = new Casa( "null", linhaD, colunaD);;
    }

    public boolean  estaLivre(String caminho,Tabuleiro tabuleiro ){
        Peao peca;
        boolean flag=true;

        for (int i=2;i<caminho.length()-2;i+=2){
            String coluna,linha;
            coluna= String.valueOf(caminho.charAt(i));
            linha= String.valueOf(caminho.charAt(i+1));
            peca=tabuleiro.getPeca(linha,coluna);
            if(peca!=null){
                flag=false;
            }
        }
        return flag;



    }

    public Casa casaInicial(){
        return casaInicial;
    }

    public Casa casaFinal(){
        return casaFinal;
    }
}
