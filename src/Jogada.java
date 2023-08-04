import static java.lang.Integer.parseInt;

public class Jogada {
    String linhaO,colunaO,linhaD,colunaD;
    Caminho caminho;
    Tabuleiro tabuleiro;

    Jogador jogador;


    public Jogada(String linhaO, String colunaO, String linhaD, String colunaD, Tabuleiro tabuleiro, Jogador jogador) {
        Casa casaOrigem = new Casa(null, linhaO, colunaO);
        this.tabuleiro = tabuleiro;
        this.linhaO = linhaO;
        this.colunaO = colunaO;
        this.linhaD = linhaD;
        this.colunaD = colunaD;
        this.jogador = jogador;
    }

    public boolean ehValida(){
        Peao peca = tabuleiro.getPeca(linhaO,colunaO);
        if(peca == null){ // se não tiver peça na casa de origem
            System.out.printf("Nao existe peca na casa inicial");
            return false;
        }
        if(!peca.getCor().equals(jogador.cor)){// se a peça não for da cor do jogador
            System.out.printf("Movimento invalido, o jogador %s nao pode mexer as pecas de outra cor\n", jogador.cor);
            return false;
        }

        Peao pecaDestino = tabuleiro.getPeca(linhaD,colunaD);
        boolean destinoOcupadoPeloInimigo = (pecaDestino != null && !pecaDestino.getCor().equals(jogador.getCor()));// se tiver peça adiversaria na casa de destino
        if(!peca.movimentoValido(linhaO,colunaO,linhaD,colunaD)){ // se o movimento não for valido
            System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.desenho());
            return false;
        }
        //peao
        if( !colunaO.equals(colunaD) && destinoOcupadoPeloInimigo == false){//tem que ver se eh peao depois
            System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.desenho());
            return false;
        }else if(!colunaO.equals(colunaD) && destinoOcupadoPeloInimigo == true){
            return true;
        }else if(colunaO.equals(colunaD) && tabuleiro.getPeca(linhaD,colunaD) != null){
            System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
            return false;
        }

        String stringCaminho = peca.caminho(linhaO,colunaO,linhaD,colunaD);



        this.caminho = new Caminho(stringCaminho, tabuleiro);

        return this.caminho.estaLivre();

    }


}
