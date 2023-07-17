public class Tabuleiro {
    private Casa[][] tabuleiro = new Casa[9][9];

    public Tabuleiro() {
        for (int i = 1; i < 9; i++) {
            for(int j = 1; j < 9; j++){
                if(i+j%2==0){

                    tabuleiro[i][j] = new Casa("preta", Casa.transformNumeroColuna(i), String.valueOf(j));
                }
                else{
                    tabuleiro[i][j] = new Casa("branca", Casa.transformNumeroColuna(i), String.valueOf(j));
                }
            }
        }

        for(int i = 1; i < 9; i++){
            tabuleiro[2][i].colocaPeca(new Peao("preto", tabuleiro[2][i]));
            tabuleiro[7][i].colocaPeca(new Peao("branco", tabuleiro[7][i]));
        }

    }

    public void imprimirTabuleiro() {
        for (int i = 1; i < 9; i++) {
            System.out.println();
            for (int j = 1; j < 9; j++) {
                if(tabuleiro[i][j].temPeca()){
                    System.out.print(" " + tabuleiro[i][j].getPeca().getSimbolo());
                }
                else if(tabuleiro[i][j].getCor().equals("preta")){
                    System.out.print(" ■ ");
                }
                else{
                    System.out.print(" □");
                }
            }
        }
    }

}
