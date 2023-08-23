public class Tabuleiro {
    private Casa[][] tabuleiro = new Casa[9][9];

    public Tabuleiro() { //monta o tabuleiro
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

    }

    public void imprimirTabuleiro() {
        for (int i = 1; i < 9; i++) {
            System.out.println();
            System.out.print(" " + i);

            for (int j = 1; j < 9; j++) {
                if(tabuleiro[i][j].temPeca()){
                    System.out.print(" "+ tabuleiro[i][j].getPeca().desenho() + " ");
                }
                else if(tabuleiro[i][j].getCor().equals("white")){
                    System.out.print(" ⛊ ");
                }
                else{
                    System.out.print(" ⛉ ");
                }
            }
        }
        System.out.println("\n   A   B   C  D   E  F   G   H");

    }

    public Peca getPeca(String linha, String coluna){
        Integer linha2,coluna2;
        linha2 = Integer.parseInt(linha);//transforma a string em int
        coluna2=Casa.tranformaColunaNumero(coluna); //transforma a string em int

        if (tabuleiro[linha2][coluna2].temPeca()){
            Peca pecas= tabuleiro[linha2][coluna2].getPeca();
            return pecas;
        }
        else {
            return null;
        }
    }

    public Peca tirarPeca(String linha, String coluna){
        Integer linha2,coluna2;
       linha2 = Integer.parseInt(linha);//transforma a string em int
       coluna2=Casa.tranformaColunaNumero(coluna);////transforma a string em int

        if (tabuleiro[linha2][coluna2].temPeca()){
            Peca pecas= tabuleiro[linha2][coluna2].getPeca();
            tabuleiro[linha2][coluna2].tiraPeca();
            return pecas;
        }
        else {
            return null;
        }
    }

    public Peca colocarPeca(String linha, String coluna, Peca peca){
        int linha2,coluna2;
        linha2 = Integer.parseInt(linha);
        coluna2=Casa.tranformaColunaNumero(coluna);

        if (!tabuleiro[linha2][coluna2].temPeca()){ //se não tiver peça na casa
            tabuleiro[linha2][coluna2].colocaPeca(peca);
            return null;
        }
        else { //se tiver peça na casa, vai capturar a peça
            Peca pecaCapturada = tabuleiro[linha2][coluna2].getPeca();
            tabuleiro[linha2][coluna2].tiraPeca();
            tabuleiro[linha2][coluna2].colocaPeca(peca);
            return pecaCapturada;
        }
    }

    public Casa getCasa(String linha, String coluna){
        Integer linha2,coluna2;
        linha2 = Integer.parseInt(linha);//transforma a string em int
        coluna2=Casa.tranformaColunaNumero(coluna); //transforma a string em int

        return tabuleiro[linha2][coluna2];
    }

    public boolean noLimite(String linha,  String coluna){
        int linha2,coluna2;
        linha2 = Integer.parseInt(linha);
        coluna2=Casa.tranformaColunaNumero(coluna);
        if(linha2>0 && linha2<9 && coluna2>0 && coluna2<9){
            return true;
        }
        else{
            return false;
        }
    }

}
