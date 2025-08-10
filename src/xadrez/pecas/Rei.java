package src.xadrez.pecas;

import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.Cor;
import src.xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    public Rei(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }

    private boolean possoMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentoPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getQdtLinhas()][getTabuleiro().getQdtColunas()];

        Posicao p = new Posicao(0, 0);
        // acima
        p.setValor(posicao.getLinha() - 1, posicao.getColuna());
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // abaixo
        p.setValor(posicao.getLinha() + 1, posicao.getColuna());
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // direita
        p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // noroeste
        p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // suldoeste
        p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // suldeste
        p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // nordeste
        p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if (getTabuleiro().existePosicao(p) && possoMover(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }



        return mat;
    }
}
