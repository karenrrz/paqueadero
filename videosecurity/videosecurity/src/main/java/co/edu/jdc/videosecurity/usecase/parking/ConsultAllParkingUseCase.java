package co.edu.jdc.videosecurity.usecase.parking;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.domain.entities.Parking;
import co.edu.jdc.videosecurity.domain.mapper.ParkingMapper;

import java.util.List;

public class ConsultAllParkingUseCase {

    private ParkingRepository parkingRepository;

    public ConsultAllParkingUseCase(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<ParkingDto> execute() {
        List <Parking> parkings = parkingRepository.findAll();
        List<ParkingDto> listParkings = ParkingMapper.INSTANCE.toDto(parkings);
        return listParkings;
    }

}
