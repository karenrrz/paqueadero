package co.edu.jdc.videosecurity.usecase.parking;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.domain.entities.Parking;
import co.edu.jdc.videosecurity.domain.exception.ParkingException;
import co.edu.jdc.videosecurity.domain.mapper.ParkingMapper;
import co.edu.jdc.videosecurity.usecase.validator.ParkingValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import co.edu.jdc.videosecurity.domain.entities.Parking;

public class ActualizarHoraSalidaParkingUseCase {

    private ParkingRepository parkingRepository;

    public ActualizarHoraSalidaParkingUseCase(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }
    public void execute(Long id){
        if(parkingRepository.existParking(id).intValue() == 0)
            throw new ParkingException("Parking not found");
        Parking parking = this.parkingRepository.findParkingById(id);

        // actualizar hora de salida
        parking.setHoraSalida(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        this.parkingRepository.save(parking);
    }
}