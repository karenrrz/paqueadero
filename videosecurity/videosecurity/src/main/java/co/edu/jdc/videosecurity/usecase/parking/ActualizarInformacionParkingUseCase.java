package co.edu.jdc.videosecurity.usecase.parking;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.domain.entities.Parking;
import co.edu.jdc.videosecurity.domain.exception.ParkingException;
import co.edu.jdc.videosecurity.domain.mapper.ParkingMapper;
import co.edu.jdc.videosecurity.usecase.validator.ParkingValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActualizarInformacionParkingUseCase {

    private ParkingRepository parkingRepository;

    public ActualizarInformacionParkingUseCase(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    public void execute( String placa){
        if(parkingRepository.existParking(Long.valueOf(placa)).intValue() == 0)
            throw new ParkingException("Carro no encontrado");

        Parking parking = this.parkingRepository.findParkingByPlaca(Long.valueOf(placa));

        // Actualizar placa
        parking.setPlaca(placa);

        this.parkingRepository.save(parking);
    }
}