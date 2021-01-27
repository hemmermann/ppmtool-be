package cz.hermitech.ppmtool.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PpmError {
    private String message;
    private String description;
    private HttpStatus httpStatus;

    public PpmError(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public PpmError(String message, String description, HttpStatus httpStatus) {
        this.message = message;
        this.description = description;
        this.httpStatus = httpStatus;
    }

}
