package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.SettlementDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Settlement and its DTO SettlementDTO.
 */
@Mapper(componentModel = "spring", uses = {RegionMapper.class, })
public interface SettlementMapper extends EntityMapper <SettlementDTO, Settlement> {

    @Mapping(source = "region.id", target = "regionId")
    @Mapping(source = "region.fullName", target = "regionFullName")
    SettlementDTO toDto(Settlement settlement); 
    @Mapping(target = "streets", ignore = true)
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)

    @Mapping(source = "regionId", target = "region")
    Settlement toEntity(SettlementDTO settlementDTO); 
    default Settlement fromId(Long id) {
        if (id == null) {
            return null;
        }
        Settlement settlement = new Settlement();
        settlement.setId(id);
        return settlement;
    }
}
