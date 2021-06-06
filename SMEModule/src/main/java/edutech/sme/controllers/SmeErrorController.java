package edutech.sme.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edutech.sme.exception.ErrorInfo;

@RestController
public class SmeErrorController implements ErrorController{
	@RequestMapping("/error")
    public ResponseEntity<ErrorInfo> handleError() {
        ErrorInfo errorInfo;
        errorInfo = new ErrorInfo("RequestMappingError", "No mapping for the request found",
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
	

}
