package src.xadrez;

import src.jogotabuleiro.Peca;
import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;
import src.xadrez.exception.ExcecaoXadrez;
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

    public boolean[][] movimentoPossiveis(PosicaoXadrez origemPosicao) {
        Posicao posicao = origemPosicao.toPosicao();
        validarOrigemPeca(posicao);
        return tabuleiro.peca(posicao).movimentoPossiveis();
    }

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(new PosicaoXadrez(coluna, linha).toPosicao(), peca);
    }

    private void IniciarJogo() {
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));

    }

    public PecaXadrez RealizarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();
        validarOrigemPeca(origem);
        validarDestinoPeca(origem, destino);
        Peca capturarPeca = fazerMovimento(origem, destino);
        return (PecaXadrez)capturarPeca;
    }

    public void validarOrigemPeca(Posicao posicao) {
        if (!tabuleiro.existeUmaPeca(posicao)) {
            throw new ExcecaoXadrez("Não existe peça na posição de Origem.");
        }
        if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
            throw new ExcecaoXadrez("Não existe movimento possiveis para a peça escolhida. ");
        }
    }

    public void validarDestinoPeca(Posicao origem, Posicao destino) {
        //Se para a peça de origem a posição de destino não é um movimento possivel
        if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
            throw new ExcecaoXadrez("A Peça escolhida, não pode ser mover para a posição de destino");
        }
    }

    public Peca fazerMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(destino, p);
        return pecaCapturada;
    }

}
