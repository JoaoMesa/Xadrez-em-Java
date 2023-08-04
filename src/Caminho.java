public class Caminho {

    Casa casas[];
    Tabuleiro tabuleiro;

    Caminho (String caminho, Tabuleiro tabuleiro){
        casas = new Casa[caminho.length()/2];
        int j =0;
        System.out.println(caminho.length());
        for (int i=0;i<caminho.length();i+=2){
            System.out.println(i);
            String coluna,linha;
            coluna= String.valueOf(caminho.charAt(i));
            linha= String.valueOf(caminho.charAt(i+1));
            casas[j] = tabuleiro.getCasa(linha,coluna);
            j++;
        }
    }

    public boolean  estaLivre(){
        Peao peca;
        boolean flag=true;

        //verifica se tem peça no caminho do movimento
        for (int i=1;i <casas.length -1;i++){ //iguinora a casa inicial e final
            if (casas[i].temPeca()){
                flag=false;
            }
        }
        return flag;
    }

    public Casa casaInicial(){
        return casas[0];
    }

    public Casa casaFinal(){
        return casas[casas.length -1];
    }
}
