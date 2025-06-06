package src.xadrez;

import src.jogotabuleiro.Peca;
import src.jogotabuleiro.Posicao;
import src.jogotabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

    // Atributo que guarda a cor da peça (ex: branca ou preta)
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        // Chama o construtor da classe pai Peca, passando o tabuleiro para ela
        super(tabuleiro);
        // Inicializa a cor da peçaXadrez com o valor recebido no construtor
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    // Faremos aqui nessa PeçaXadrez para utilizar ela em todas as classes
    protected boolean existePecaOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }


}
