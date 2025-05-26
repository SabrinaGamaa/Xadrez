package src.xadrez.exception;

import java.io.Serial;

public class ExcecaoXadrez extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExcecaoXadrez(String msg) {
        super(msg);
    }
}
