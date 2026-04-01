package pl.estrix.common.exception;

public class ReturnParcelRESTException extends ReturnParcelException {

    public ReturnParcelRESTException(String format, Object... args) {
        super(ReturnParcelException.Code.REST, format, args);
    }

    public ReturnParcelRESTException(Throwable cause, String format, Object... args) {
        super(cause, ReturnParcelException.Code.REST, format, args);
    }
}
