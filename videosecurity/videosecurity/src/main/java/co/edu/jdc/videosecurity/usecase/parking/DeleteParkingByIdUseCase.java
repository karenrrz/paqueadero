package co.edu.jdc.videosecurity.usecase.parking;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.domain.exception.ParkingException;

public class DeleteParkingByIdUseCase {

    private ParkingRepository parkingRepository;

    public DeleteParkingByIdUseCase(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    public void execute(Long id){
        if(parkingRepository.existParking(id).intValue() == 0)
            throw new ParkingException("Parking not found");
        this.parkingRepository.deleteById(id);
    }
}
