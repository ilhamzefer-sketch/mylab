package az.mylab.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@RestControllerAdvice // sinifi global exception handler elan edir
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // global xetani sobelere ayiriki yalniz
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value()) // 404
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ){
       Map<String, List<String>> validationErrors = new HashMap<>();
       ex.getBindingResult().getFieldErrors().forEach(error ->
               validationErrors
                       .computeIfAbsent(error.getField(), key -> new ArrayList<>())
                       .add(error.getDefaultMessage()));

       ErrorResponse errorResponse =ErrorResponse.builder()
               .timeStamp(LocalDateTime.now())
               .status(HttpStatus.BAD_REQUEST.value())
               .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
               .message("validation failed")
               .path(request.getRequestURI())
               .validationErrors(validationErrors)
               .build();

       return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleGenericException(
            Exception ex,
                HttpServletRequest request

    ) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message("Unexpected Internal error")
                .path(request.getRequestURI())
                .build();


        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(
            UserAlreadyExistsException ex,
            HttpServletRequest request) {

        ErrorResponse errorResponse =ErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

    }

}
