package co.edu.jdc.videosecurity.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingDto {
    private Long id;
    private String placa;
    private String horaEntrada;
    private String horaSalida;
    private String tipoVehiculo;

}
