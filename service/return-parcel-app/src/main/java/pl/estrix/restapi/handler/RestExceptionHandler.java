package pl.estrix.restapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.estrix.common.exception.ReturnParcelRESTException;

@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ReturnParcelRESTException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleReturnParcelRESTException(ReturnParcelRESTException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
