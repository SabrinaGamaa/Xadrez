package src.jogotabuleiro;

public abstract class Peca {

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

    public abstract boolean[][] movimentoPossiveis();

    public boolean movimentoPossivel(Posicao posicao) {
        return movimentoPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean existeMovimentoPossivel(){
        boolean[][] mat = movimentoPossiveis();
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat.length; j ++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
