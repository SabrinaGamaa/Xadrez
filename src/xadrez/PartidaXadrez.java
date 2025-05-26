package src.xadrez;

import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.pecas.Peao;
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

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(new PosicaoXadrez(coluna, linha).toPosicao(), peca);
    }

    private void IniciarJogo() {
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('a', 3, new Peao(tabuleiro, Cor.BRANCO));

    }

}
