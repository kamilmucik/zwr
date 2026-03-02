package pl.estrix.common.exception;

import lombok.Getter;

public class ReturnParcelException extends RuntimeException {

    public enum Code {
        REST,
        UI
    }

    @Getter
    private Code code = null;

    public ReturnParcelException(String message) {
        super(message);
    }

    public ReturnParcelException(Code code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
    }

    public ReturnParcelException(Throwable cause, Code code, String format, Object... args) {
        super(String.format(format, args), cause);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return String.format("%s", super.getMessage());
    }
}
