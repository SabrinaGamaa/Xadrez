package src.xadrez.exception;

import src.jogotabuleiro.exception.TabuleiroException;

import java.io.Serial;

public class ExcecaoXadrez extends TabuleiroException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExcecaoXadrez(String msg) {
        super(msg);
    }
}
