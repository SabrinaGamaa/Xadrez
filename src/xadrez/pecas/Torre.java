package src.xadrez.pecas;

import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.Cor;
import src.xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] movimentoPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getQdtLinhas()][getTabuleiro().getQdtColunas()];

        // Fazer os movimentos possiveis da torre
        Posicao p = new Posicao(0, 0);

        //acima
        p.setValor(posicao.getLinha() - 1, posicao.getColuna());
        //enquanto a posicao P existir e não tiver uma peça na posição, é verdadeiro.
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        // Se existir uma peça na posicao que P chegar e existe um peça do oponente, quer dizer verdadeiro
        if (getTabuleiro().existePosicao(p) && existePecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }


        //baixo
        p.setValor(posicao.getLinha() + 1, posicao.getColuna());
        //enquanto a posicao P existir e não tiver uma peça na posição para BAIXO, é verdadeiro.
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        // Se existir uma peça na posicao que P chegar e existe um peça do oponente, quer dizer verdadeiro
        if (getTabuleiro().existePosicao(p) && existePecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }


        //esquerda
        p.setValor(posicao.getLinha(), posicao.getColuna() - 1);
        //enquanto a posicao P existir e não tiver uma peça na posição do lado ESQUERDO, é verdadeiro.
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        // Se existir uma peça na posicao que P chegar e existe um peça do oponente, quer dizer verdadeiro
        if (getTabuleiro().existePosicao(p) && existePecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }


        //direita
        p.setValor(posicao.getLinha(), posicao.getColuna() + 1);
        //enquanto a posicao P existir e não tiver uma peça na posição do lado DIREITO, é verdadeiro.
        while (getTabuleiro().existePosicao(p) && !getTabuleiro().existeUmaPeca(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        // Se existir uma peça na posicao que P chegar e existe um peça do oponente, quer dizer verdadeiro
        if (getTabuleiro().existePosicao(p) && existePecaOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }
}
