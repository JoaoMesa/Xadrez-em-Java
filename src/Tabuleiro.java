public class Tabuleiro {
    private Casa[][] tabuleiro = new Casa[9][9];

    public Tabuleiro() {
        for (int i = 1; i < 9; i++) {
            for(int j = 1; j < 9; j++){
                if((i+j)%2==0){

                    tabuleiro[i][j] = new Casa("black", Casa.transformNumeroColuna(i), String.valueOf(j));
                }
                else{
                    tabuleiro[i][j] = new Casa("white", Casa.transformNumeroColuna(i), String.valueOf(j));
                }
            }
        }

        for(int i = 1; i < 9; i++){
            tabuleiro[2][i].colocaPeca(new Peao("white", tabuleiro[2][i]));
            tabuleiro[7][i].colocaPeca(new Peao("black", tabuleiro[7][i]));
        }

    }

    public void imprimirTabuleiro() {
        for (int i = 1; i < 9; i++) {
            System.out.println();
            for (int j = 1; j < 9; j++) {
                if(tabuleiro[i][j].temPeca()){
                    System.out.print(" "+ tabuleiro[i][j].getPeca().getSimbolo() + " ");
                }
                else if(tabuleiro[i][j].getCor().equals("white")){
                    System.out.print(" ⛊ ");
                }
                else{
                    System.out.print(" ⛉ ");
                }
            }
        }
    }

    public Peao getPeca(String linha, String coluna){
        Integer linha2,coluna2;
        linha2 = Integer.parseInt(linha);
        coluna2=Casa.tranformaColunaNumero(coluna);

        if (tabuleiro[linha2][coluna2].temPeca()){
            Peao peaos= tabuleiro[linha2][coluna2].getPeca();
            return peaos;
        }
        else {
            return null;
        }
    }

    public Peao tirarPeca(String linha, String coluna){
        Integer linha2,coluna2;
       linha2 = Integer.parseInt(linha);
       coluna2=Casa.tranformaColunaNumero(coluna);

        if (tabuleiro[linha2][coluna2].temPeca()){
            Peao peaos= tabuleiro[linha2][coluna2].getPeca();
            tabuleiro[linha2][coluna2].tiraPeca();
            return peaos;
        }
        else {
            return null;
        }
    }

    public Peao colocarPeca(String linha, String coluna, Peao peca){
        int linha2,coluna2;
        linha2 = Integer.parseInt(linha);
        coluna2=Casa.tranformaColunaNumero(coluna);

        if (!tabuleiro[linha2][coluna2].temPeca()){
            tabuleiro[linha2][coluna2].colocaPeca(peca);
            return null;
        }
        else {
            Peao pecaCapturada = tabuleiro[linha2][coluna2].getPeca();
            tabuleiro[linha2][coluna2].tiraPeca();
            tabuleiro[linha2][coluna2].colocaPeca(peca);
            return pecaCapturada;
        }
    }

}
