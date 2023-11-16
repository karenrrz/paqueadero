package co.edu.jdc.videosecurity.domain.mapper;

import co.edu.jdc.videosecurity.domain.dto.ParkingDto;

import co.edu.jdc.videosecurity.domain.entities.Parking;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParkingMapper {
    ParkingMapper INSTANCE = Mappers.getMapper( ParkingMapper.class );
    ParkingDto toDto(Parking parking);
    Parking toEntity(ParkingDto parking);
    List<ParkingDto> toDto(List<Parking> parking);
    List<Parking> toEntity(List<ParkingDto> parking);
}
