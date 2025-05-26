package src.xadrez;

import src.jogotabuleiro.Peca;
import src.jogotabuleiro.Tabuleiro;

public class PecaXadrez extends Peca {

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


}
