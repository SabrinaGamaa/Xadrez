package src.jogotabuleiro;

import src.jogotabuleiro.exception.TabuleiroException;

public class Tabuleiro {

    private int qdtLinhas;
    private int qdtColunas;
    private Peca[][] pecas;

    public Tabuleiro(int qdtLinhas, int qdtColunas) {
        if (qdtLinhas < 1 || qdtColunas < 1) {
            throw new TabuleiroException("Erro na criação do tabuleiro: É necessario ter pelo menos 1 linha e 1 coluna!");
        }
        this.qdtLinhas = qdtLinhas;
        this.qdtColunas = qdtColunas;
        pecas = new Peca[qdtLinhas][qdtColunas];
    }


    public int getQdtLinhas() {
        return qdtLinhas;
    }

    public int getQdtColunas() {
        return qdtColunas;
    }

    // Retorna a peça que está na linha e coluna informadas.
    public Peca peca(int linha, int coluna){
        if (!existePosicao(linha, coluna)){
            throw new TabuleiroException("Error na posição: Não existe está posição no tabuleiro!");
        }
        return pecas[linha][coluna];
    }

    // Retorna a peça com base em um objeto Posicao.
    public Peca peca(Posicao posicao) {
        if (!existePosicao(posicao)){
            throw new TabuleiroException("Error na posição: Não existe está posição no tabuleiro!");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Posicao posicao, Peca peca) {
        if (existeUmaPeca(posicao)){
            throw new TabuleiroException("Error: Já existe uma peça nesta posição " + posicao);
        }

        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    private boolean existePosicao(int linha, int coluna) {
        return linha >= 0 && linha < qdtLinhas && coluna >= 0 && coluna < qdtColunas;
    }

    public boolean existePosicao(Posicao posicao){
        return existePosicao(posicao.getLinha(), posicao.getColuna());
    }

    public boolean existeUmaPeca(Posicao posicao) {
        if (!existePosicao(posicao)){
            throw new TabuleiroException("Error: Não existe está posição no tabuleiro " + posicao);
        }
        return peca(posicao) != null;
    }

}




