package co.edu.jdc.videosecurity.domain.exception;

import lombok.Getter;

@Getter
public class ParkingException extends RuntimeException{
    private String message;
    public ParkingException(String message) {
        super(message);
        this.message = message;
    }
}
