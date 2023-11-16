package co.edu.jdc.videosecurity.app.config;

import co.edu.jdc.videosecurity.adapter.repository.ParkingRepository;
import co.edu.jdc.videosecurity.usecase.parking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Autowired
    private ParkingRepository parkingRepository;

    @Bean
    public CreateParkingUseCase createParkingUseCase(){
        return new CreateParkingUseCase(parkingRepository);
    }

    @Bean
    public ActualizarInformacionParkingUseCase actualizarInformacionParkingUseCase(){
        return new ActualizarInformacionParkingUseCase(parkingRepository);
    }
   @Bean
    public ActualizarHoraSalidaParkingUseCase actualizarHoraSalidaParkingUseCase(){
        return new ActualizarHoraSalidaParkingUseCase(parkingRepository);
    }

    @Bean
    public ListarParkingTipoUseCase listarParkingTipoUseCase(){
        return new ListarParkingTipoUseCase(parkingRepository);
    }

    @Bean
    public ListarParkingAllUseCase listarParkingAllUseCase(){
        return new ListarParkingAllUseCase(parkingRepository);
    }

    @Bean
    public DeleteParkingByIdUseCase deleteParkingByIdUseCase(){
        return new DeleteParkingByIdUseCase(parkingRepository);
    }
}

