package src.jogotabuleiro;

public class Tabuleiro {

    private int qdtLinhas;
    private int qdtColunas;
    private Peca[][] pecas;

    public Tabuleiro(int qdtLinhas, int qdtColunas) {
        this.qdtLinhas = qdtLinhas;
        this.qdtColunas = qdtColunas;
        pecas = new Peca[qdtLinhas][qdtColunas];
    }

    public int getQdtLinhas() {
        return qdtLinhas;
    }

    public void setQdtLinhas(int qdtLinhas) {
        this.qdtLinhas = qdtLinhas;
    }

    public int getQdtColunas() {
        return qdtColunas;
    }

    public void setQdtColunas(int qdtColunas) {
        this.qdtColunas = qdtColunas;
    }

    // Retorna a peça que está na linha e coluna informadas.
    public Peca peca(int linha, int coluna){
        return pecas[linha][coluna];
    }

    // Retorna a peça com base em um objeto Posicao.
    public Peca peca(Posicao posicao) {
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }


}
