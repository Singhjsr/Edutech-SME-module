package edutech.sme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception ex) {
        ErrorInfo errorInfo = new ErrorInfo("Exception", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
        
    }
	@ExceptionHandler(SMEException.class)
    public ResponseEntity<ErrorInfo> smeExceptionHandler(SMEException ex) {
        ErrorInfo errorInfo = new ErrorInfo("SMENotFound", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }
}