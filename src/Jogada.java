import static java.lang.Integer.parseInt;

public class Jogada {
    Casa casaOrigem, casaDestino;
    Caminho caminho;


    public Jogada(String linhaO, String colunaO, String linhaD, String colunaD) {
        Casa casaOrigem = new Casa(null, linhaO, colunaO);
        this.caminho = new Caminho(linhaO,colunaO,linhaD,colunaD);
        this.casaOrigem = casaOrigem;
        this.casaDestino = casaDestino;
    }

    public boolean ehValida(String caminho,Tabuleiro tabuleiro){
        return this.caminho.estaLivre(caminho,tabuleiro);

    }


}
