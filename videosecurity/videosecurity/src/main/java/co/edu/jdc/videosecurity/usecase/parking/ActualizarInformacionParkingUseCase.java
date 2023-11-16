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

    public void execute(Long id, ParkingDto parkingDto){
      
       System.out.println("Datos de entrada" + parkingDto);

      if(parkingRepository.existParking(id).intValue() == 0)
            throw new ParkingException("Parking not found");
        Parking parking = this.parkingRepository.findParkingById(id);


       System.out.println("Datos de entrada" + parkingDto.getPlaca());
       System.out.println("Datos de entrada" + parkingDto.getTipoVehiculo());

        parking.setPlaca(parkingDto.getPlaca());
        parking.setTipoVehiculo(parkingDto.getTipoVehiculo());


        this.parkingRepository.save(parking);
    }
}
