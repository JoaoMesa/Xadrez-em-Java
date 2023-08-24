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
        Peca peca = tabuleiro.getPeca(linhaO,colunaO);
        if(peca == null){ // se não tiver peça na casa de origem
            System.out.printf("Nao existe peca na casa inicial");
            return false;
        }
        if(!peca.getCor().equals(jogador.cor)){// se a peça não for da cor do jogador
            System.out.printf("Movimento invalido, o jogador %s nao pode mexer as pecas de outra cor\n", jogador.cor);
            return false;
        }

        Peca pecaDestino = tabuleiro.getPeca(linhaD,colunaD);
        boolean destinoOcupadoPeloInimigo = (pecaDestino != null && !pecaDestino.getCor().equals(jogador.getCor()));// se tiver peça adiversaria na casa de destino
        if(!peca.movimentoValido(linhaO,colunaO,linhaD,colunaD)){ // se o movimento não for valido
            System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.desenho());
            return false;
        }
        //Se for um peao, tem que ver se ele esta tentando comer uma peca
        if(peca instanceof Peao){
            if(destinoOcupadoPeloInimigo == false && !colunaO.equals(colunaD)){//se o peao estiver tentando comer uma peca, mas nao tem peca na casa de destino
                System.out.printf("Movimento invalido, o %s nao mexe assim\n", peca.desenho());
                return false;
            }
            else if(!colunaO.equals(colunaD) && destinoOcupadoPeloInimigo == true){
                return true;
            }else if(colunaO.equals(colunaD) && tabuleiro.getPeca(linhaD,colunaD) != null){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        //Se for bispo
        if(peca instanceof Bispo){
            if( tabuleiro.getPeca(linhaD,colunaD) != null && destinoOcupadoPeloInimigo == false){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        //Se for cavalo
        if(peca instanceof Cavalo){
            if( tabuleiro.getPeca(linhaD,colunaD) != null && destinoOcupadoPeloInimigo == false){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        //Se for torre
        if(peca instanceof Torre){
            if( tabuleiro.getPeca(linhaD,colunaD) != null && destinoOcupadoPeloInimigo == false){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        //Se for rei
        if(peca instanceof Rei){
            if( tabuleiro.getPeca(linhaD,colunaD) != null && destinoOcupadoPeloInimigo == false){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        //Se for rainha
        if(peca instanceof Dama){
            if( tabuleiro.getPeca(linhaD,colunaD) != null && destinoOcupadoPeloInimigo == false){
                System.out.printf("Movimento invalido, tem uma peca no seu destino\n", peca.desenho());
                return false;
            }
        }

        String stringCaminho = peca.caminho(colunaO,linhaO,colunaD,linhaD);

        this.caminho = new Caminho(stringCaminho, tabuleiro);

        if(!(peca instanceof Cavalo))
            return this.caminho.estaLivre();
        else
            return true;

    }

    public boolean ehXeque(){
        String posicaoRei = achaRei(jogador.getCor());

        if(posicaoRei == null){
            return false;
        }

        String linhaRei = String.valueOf(posicaoRei.charAt(1));
        String colunaRei = String.valueOf(posicaoRei.charAt(0));

        for (int i=1;i<9;i++){
            for (char j=97;j<=104;j++){
                String linha = Integer.toString(i);
                String coluna = j+"";
                Casa casa = tabuleiro.getCasa(linha,coluna);
                if(casa.temPeca()){
                    Peca peca = casa.getPeca();
                    String stringCaminho = peca.caminho(coluna,linha,colunaRei,linhaRei);
                    Caminho caminhoLivreRei = new Caminho(stringCaminho, tabuleiro);
                    if(peca.getCor() == jogador.getCor()){// se a peça for sua
                        if(peca.movimentoValido(linha,coluna,linhaRei,colunaRei)){// se a peça puder comer o rei
                            if(peca instanceof Cavalo){
                                return true;
                            }
                            else {
                                if(caminhoLivreRei.estaLivre()){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;

    }

    public String achaRei(String cor){

        if (cor == "white"){

            for (int i=1;i<9;i++){
                for (char j=97;j<=104;j++){
                    String linha=Integer.toString(i);
                    String coluna=j+"";
                    Casa casa = tabuleiro.getCasa(linha,coluna);
                    if(casa.temPeca()){
                        Peca peca = casa.getPeca();
                        if(peca.desenho()=="♔"){// achou o rei
                                return coluna+linha;
                        }
                    }
                }
            }
        }
        else{
            for (int i=1;i<9;i++){
                for (char j=97;j<=104;j++){
                    String linha=Integer.toString(i);
                    String coluna=j+"";
                    Casa casa = tabuleiro.getCasa(linha,coluna);
                    if(casa.temPeca()){
                        Peca peca = casa.getPeca();
                        if(peca.desenho()=="♚"){// achou o rei
                                return coluna+linha;
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getLinhaO() {
        return linhaO;
    }

    public String getColunaO() {
        return colunaO;
    }

    public String getLinhaD() {
        return linhaD;
    }

    public String getColunaD() {
        return colunaD;
    }
}
