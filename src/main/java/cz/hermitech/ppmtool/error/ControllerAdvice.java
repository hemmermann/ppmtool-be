package cz.hermitech.ppmtool.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice(annotations = RestController.class)
@Log4j2
public class ControllerAdvice {
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity unauthorizedException(ForbiddenException ex, HttpServletRequest request) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                             .body(new PpmError(HttpStatus.FORBIDDEN.toString(), ex.getMessage(),
                                     HttpStatus.FORBIDDEN
                             ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(NotFoundException ex,
                                            HttpServletRequest request) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new PpmError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(),
                                     HttpStatus.NOT_FOUND
                             ));
    }

    @ExceptionHandler({BindException.class, ConstraintViolationException.class})
    public ResponseEntity endpointError(Exception ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new PpmError(
                                     HttpStatus.BAD_REQUEST.toString(),
                                     ex.getMessage(),
                                     HttpStatus.BAD_REQUEST
                             ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionError(RuntimeException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new PpmError(
                                     HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                                     ex.getMessage(),
                                     HttpStatus.INTERNAL_SERVER_ERROR
                             ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeError(RuntimeException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new PpmError(
                                     HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                                     ex.getMessage(),
                                     HttpStatus.INTERNAL_SERVER_ERROR
                             ));
    }

    @ExceptionHandler(ConstraintDbException.class)
    public ResponseEntity databaseError(ConstraintDbException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new PpmError(
                                     HttpStatus.BAD_REQUEST.toString(),
                                     ex.getMessage(),
                                     HttpStatus.BAD_REQUEST
                             ));
    }

}
