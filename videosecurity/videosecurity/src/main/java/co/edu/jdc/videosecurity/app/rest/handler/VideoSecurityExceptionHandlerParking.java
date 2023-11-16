package co.edu.jdc.videosecurity.app.rest.handler;

import co.edu.jdc.videosecurity.domain.dto.ErrorResponseDto;
import co.edu.jdc.videosecurity.domain.exception.ParkingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VideoSecurityExceptionHandlerParking {

    @ExceptionHandler(ParkingException.class)
    public ResponseEntity<ErrorResponseDto> handleException(ParkingException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

}
