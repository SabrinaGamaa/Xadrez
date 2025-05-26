package src.jogotabuleiro;

public class Peca {

    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        // A peça foi criada com um tabuleiro vinculado a ela (this.tabuleiro = tabuleiro).
        // Mas ainda não foi colocada em uma posição específica do tabuleiro.
        posicao = null;
    }

    // Uso interno da camada de Tabuleiro
    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }


}
