package src.xadrez;

import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.pecas.Rei;
import src.xadrez.pecas.Torre;

// CORAÇÃO DO NOSSO XADREZ - REGRAS
public class PartidaXadrez {

    // Uma partida de xadrez precisa de um tabuleiro
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        // Quem tem que saber a dimensão de um tabuleiro é a classe PartidaXadrez
        tabuleiro = new Tabuleiro(8,8);
        IniciarJogo();
    }

    // Tem que retorna uma matriz de peças de xadrez, correspondente a PartidaXadrez
    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getQdtLinhas()][tabuleiro.getQdtColunas()];
        for (int i = 0; i < tabuleiro.getQdtLinhas(); i ++) {
            for (int j = 0; j < tabuleiro.getQdtColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    private void IniciarJogo() {
        tabuleiro.colocarPeca(new Posicao(2, 1), new Torre(tabuleiro, Cor.PRETO));
        tabuleiro.colocarPeca(new Posicao(6, 2), new Rei(tabuleiro, Cor.PRETO));
    }

}
