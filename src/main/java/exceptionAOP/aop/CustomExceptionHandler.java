package exceptionAOP.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;

@Slf4j
//@RestControllerAdvice
 @ControllerAdvice
public class CustomExceptionHandler {

    // CustomException
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ErrorResponse.error(e);
    }

    // Exception
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return ErrorResponse.error(new CustomException(ErrorCode.UnExpectedError));
    }

    // ModelCustomException
    @ExceptionHandler(value = ModelCustomException.class)
    public ResponseEntity<ErrorResponse> modelHandleCustomException(ModelCustomException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(e.getUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
