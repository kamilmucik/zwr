package pl.estrix.common.exception;

public class ReturnParcelUIException extends ReturnParcelException {


    public ReturnParcelUIException(String format, Object... args) {
        super(ReturnParcelException.Code.UI, format, args);
    }

    public ReturnParcelUIException(Throwable cause, String format, Object... args) {
        super(cause, ReturnParcelException.Code.UI, format, args);
    }
}
