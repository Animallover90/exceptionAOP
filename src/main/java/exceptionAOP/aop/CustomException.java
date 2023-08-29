package exceptionAOP.aop;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private Throwable throwable;
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode, Throwable throwable) {
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
