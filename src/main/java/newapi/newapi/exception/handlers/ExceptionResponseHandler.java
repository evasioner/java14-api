package newapi.newapi.exception.handlers;

import newapi.newapi.exception.BaseException;
import newapi.newapi.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response> exceptionHandler(BaseException ex, WebRequest request) {
        Response response = new Response(ex.getErrorCode().getStatus().value(), ex.getMessage());
        return new ResponseEntity<>(response, ex.getErrorCode().getStatus());

    }
}
