package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.WarehouseAvailableDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity WarehouseAvailable and its DTO WarehouseAvailableDTO.
 */
@Mapper(componentModel = "spring", uses = {WarehouseMapper.class, })
public interface WarehouseAvailableMapper extends EntityMapper <WarehouseAvailableDTO, WarehouseAvailable> {

    @Mapping(source = "warehouse.id", target = "warehouseId")
    WarehouseAvailableDTO toDto(WarehouseAvailable warehouseAvailable); 

    @Mapping(source = "warehouseId", target = "warehouse")
    WarehouseAvailable toEntity(WarehouseAvailableDTO warehouseAvailableDTO); 
    default WarehouseAvailable fromId(Long id) {
        if (id == null) {
            return null;
        }
        WarehouseAvailable warehouseAvailable = new WarehouseAvailable();
        warehouseAvailable.setId(id);
        return warehouseAvailable;
    }
}
