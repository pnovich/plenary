package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.PointsCoordinateDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PointsCoordinate and its DTO PointsCoordinateDTO.
 */
@Mapper(componentModel = "spring", uses = {PointMapper.class, })
public interface PointsCoordinateMapper extends EntityMapper <PointsCoordinateDTO, PointsCoordinate> {

    @Mapping(source = "point.id", target = "pointId")
    PointsCoordinateDTO toDto(PointsCoordinate pointsCoordinate); 

    @Mapping(source = "pointId", target = "point")
    PointsCoordinate toEntity(PointsCoordinateDTO pointsCoordinateDTO); 
    default PointsCoordinate fromId(Long id) {
        if (id == null) {
            return null;
        }
        PointsCoordinate pointsCoordinate = new PointsCoordinate();
        pointsCoordinate.setId(id);
        return pointsCoordinate;
    }
}
