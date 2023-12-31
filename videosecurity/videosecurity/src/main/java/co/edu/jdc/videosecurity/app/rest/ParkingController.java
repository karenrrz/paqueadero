package co.edu.jdc.videosecurity.app.rest;

import co.edu.jdc.videosecurity.domain.dto.ParkingDto;
import co.edu.jdc.videosecurity.usecase.parking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;


@RestController
@RequestMapping("/api/parking")




public class ParkingController {

    @Autowired
    private CreateParkingUseCase createParkingUseCase;

    @Autowired
    private DeleteParkingByIdUseCase deleteParkingByIdUseCase;

    @Autowired
    private ListarParkingTipoUseCase listartParkingTipoUseCase;

    @Autowired
    private ListarParkingAllUseCase listartParkingAllUseCase;

    @Autowired
    private ActualizarHoraSalidaParkingUseCase actualizarHoraSalidaParkingUseCase;

    @Autowired
    private ActualizarInformacionParkingUseCase actualizarInformacionParkingUseCase;


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createParking(@RequestBody ParkingDto parkingDto) {
        this.createParkingUseCase.execute(parkingDto);
    }

    @GetMapping(value = "/{tipo}")
    public List<ParkingDto> listarParkingTipo(@PathVariable(value = "tipo") String tipo) {

        return this.listartParkingTipoUseCase.execute(tipo);
    }

    @GetMapping(value = "/")
    public List<ParkingDto> listarParkingAll() {

        return this.listartParkingAllUseCase.execute();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteParkingById(@PathVariable(value = "id") Long id) {

        this.deleteParkingByIdUseCase.execute(id);
    }

    @PutMapping(value = "/update/{id}")
    public void actualizarHoraSalidaParkingById(@PathVariable(value = "id") Long id) {

        this.actualizarHoraSalidaParkingUseCase.execute(id);
    }

    @PutMapping(value = "/updateParking/{id}")
    public void actualizarInformacionParking(@PathVariable(value = "id") Long id,@RequestBody ParkingDto parkingDto) {
        actualizarInformacionParkingUseCase.execute(id,parkingDto);


    }
}
