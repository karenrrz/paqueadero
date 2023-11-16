package co.edu.jdc.videosecurity.usecase.validator;

import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.domain.exception.ParkingException;

import static java.util.Objects.isNull;

public class ParkingValidator {

    public static void validateInputDto(ParkingDto dto){
        if(isNull( dto ))
            throw new ParkingException("El parqueadero no puede ser nulo");
        if(dto.getPlaca() == null || dto.getPlaca().trim().isEmpty())
            throw new ParkingException("La placa no puede ser nulo o vacio");
        }
}
