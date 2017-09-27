package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.PointsContactDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity PointsContact and its DTO PointsContactDTO.
 */
@Mapper(componentModel = "spring", uses = {PointMapper.class, })
public interface PointsContactMapper extends EntityMapper <PointsContactDTO, PointsContact> {

    @Mapping(source = "point.id", target = "pointId")
    PointsContactDTO toDto(PointsContact pointsContact); 

    @Mapping(source = "pointId", target = "point")
    PointsContact toEntity(PointsContactDTO pointsContactDTO); 
    default PointsContact fromId(Long id) {
        if (id == null) {
            return null;
        }
        PointsContact pointsContact = new PointsContact();
        pointsContact.setId(id);
        return pointsContact;
    }
}
