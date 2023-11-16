package co.edu.jdc.videosecurity.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
@Data
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "placa", length = 7, nullable = false)
    private String placa;

    @Column(name = "horaentrada", nullable = true)
    private String horaEntrada;

    @Column(name = "horasalida", nullable = true)
    private String horaSalida;

    @Column(name = "tipovehiculo", length = 10, nullable = true)
    private String tipoVehiculo;
}

