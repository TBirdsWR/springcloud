package ppc.order.exception;

public class OrderException extends RuntimeException {

    private String errorMsg;

    private Integer Code;

    public OrderException(String errorMsg, Integer code) {
        this.errorMsg = errorMsg;
        Code = code;
    }

    public OrderException(String message, String errorMsg, Integer code) {
        super(message);
        this.errorMsg = errorMsg;
        Code = code;
    }

    public OrderException(String message, Throwable cause, String errorMsg, Integer code) {
        super(message, cause);
        this.errorMsg = errorMsg;
        Code = code;
    }

    public OrderException(Throwable cause, String errorMsg, Integer code) {
        super(cause);
        this.errorMsg = errorMsg;
        Code = code;
    }

    public OrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMsg, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMsg = errorMsg;
        Code = code;
    }
}
