package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.StreetDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Street and its DTO StreetDTO.
 */
@Mapper(componentModel = "spring", uses = {SettlementMapper.class, })
public interface StreetMapper extends EntityMapper <StreetDTO, Street> {

    @Mapping(source = "settlement.id", target = "settlementId")
    @Mapping(source = "settlement.fullName", target = "settlementFullName")
    StreetDTO toDto(Street street); 
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)

    @Mapping(source = "settlementId", target = "settlement")
    Street toEntity(StreetDTO streetDTO); 
    default Street fromId(Long id) {
        if (id == null) {
            return null;
        }
        Street street = new Street();
        street.setId(id);
        return street;
    }
}
