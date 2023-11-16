package co.edu.jdc.videosecurity.adapter.repository;

import co.edu.jdc.videosecurity.domain.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query(value = "SELECT p FROM Parking p")
    List<Parking> findAll();

    @Query(value = "SELECT COUNT (p) FROM Parking p WHERE p.placa=:placa")
    Long existsParking(String placa);

    @Query(value = "SELECT COUNT (p) FROM Parking p WHERE p.id=:id")
    Long existParking(Long id);

    Parking findByPlaca(String placa);

    @Query(value = "SELECT p FROM Parking p WHERE p.tipoVehiculo=:tipo")
    List<Parking> findParkingByTipo(String tipo);

    @Query(value = "SELECT p FROM Parking p WHERE p.id=:id")
    Parking findParkingById(Long id);

    @Query(value = "SELECT p FROM Parking p WHERE p.placa=:placa")
    Parking findParkingByPlaca(Long placa);
}
