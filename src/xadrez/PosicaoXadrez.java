package src.xadrez;

import src.jogotabuleiro.Posicao;
import src.xadrez.exception.ExcecaoXadrez;

public class PosicaoXadrez {

    private char colunaLetra;
    private int linhaNumero;

    public PosicaoXadrez(char colunaLetra, int linhaNumero) {
        if (colunaLetra < 'a' || colunaLetra > 'h' || linhaNumero < 1 || linhaNumero > 8) {
            throw new ExcecaoXadrez("Error ao iniciar PosicaoXadrez. Valores validos são de a1 até h8. ");
        }
        this.colunaLetra = colunaLetra;
        this.linhaNumero = linhaNumero;
    }

    public char getColunaLetra() {
        return colunaLetra;
    }


    public int getLinhaNumero() {
        return linhaNumero;
    }

    protected Posicao toPosicao() {
        // Converte a posição de xadrez (ex: a1, h8) para índices de matriz (linha e coluna numérica)
        return new Posicao(8 - getLinhaNumero(), getColunaLetra() - 'a');
    }

    protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        // Converte da posição da matriz de volta para notação de xadrez (ex: 0,0 → a8)
        return new PosicaoXadrez((char)('a' - posicao.getColuna()),  (8 - posicao.getLinha()));
    }

    @Override
    public String toString() {
        // Retorna a posição no formato tradicional de xadrez (ex: a1, e5)
        return "" + getColunaLetra() + getLinhaNumero();
    }
}
