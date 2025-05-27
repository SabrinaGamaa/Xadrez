package src.xadrez.pecas;

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


}
