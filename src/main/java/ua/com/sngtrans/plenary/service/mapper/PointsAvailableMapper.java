package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.PointsAvailableDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PointsAvailable and its DTO PointsAvailableDTO.
 */
@Mapper(componentModel = "spring", uses = {PointMapper.class, })
public interface PointsAvailableMapper extends EntityMapper <PointsAvailableDTO, PointsAvailable> {

    @Mapping(source = "point.id", target = "pointId")
    PointsAvailableDTO toDto(PointsAvailable pointsAvailable); 

    @Mapping(source = "pointId", target = "point")
    PointsAvailable toEntity(PointsAvailableDTO pointsAvailableDTO); 
    default PointsAvailable fromId(Long id) {
        if (id == null) {
            return null;
        }
        PointsAvailable pointsAvailable = new PointsAvailable();
        pointsAvailable.setId(id);
        return pointsAvailable;
    }
}
