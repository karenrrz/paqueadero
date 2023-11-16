package co.edu.jdc.videosecurity.usecase.parking;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.domain.entities.Parking;

import co.edu.jdc.videosecurity.domain.exception.ParkingException;
import co.edu.jdc.videosecurity.domain.mapper.ParkingMapper;
import co.edu.jdc.videosecurity.usecase.validator.ParkingValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateParkingUseCase {

    private ParkingRepository parkingRepository;

    public CreateParkingUseCase(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    public void execute(ParkingDto dto) {
        // validar informacion de usuario
        ParkingValidator.validateInputDto(dto);
        // validar que el vehiculo  no exista
        if(this.parkingRepository.existsParking(dto.getPlaca().trim()).intValue() > 0)
            throw new ParkingException("El vehiculo ya existe");
        // convertir dto a entidad
        Parking parking = ParkingMapper.INSTANCE.toEntity(dto);
        parking.setHoraEntrada(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        // guardar usuario
        this.parkingRepository.save(parking);
    }

}
