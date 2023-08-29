package exceptionAOP.aop;

import lombok.Getter;

@Getter
public class UnexpectedException extends RuntimeException{

    private final Throwable throwable;
    public UnexpectedException(Throwable throwable) {
        this.throwable = throwable;
    }
}
