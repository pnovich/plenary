package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.TransportDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Transport and its DTO TransportDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, WarehouseMapper.class, DriverMapper.class, SensorMapper.class, })
public interface TransportMapper extends EntityMapper <TransportDTO, Transport> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")

    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.fullName", target = "branchFullName")

    @Mapping(source = "warehouse.id", target = "warehouseId")
    @Mapping(source = "warehouse.fullName", target = "warehouseFullName")

    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "driver.fullName", target = "driverFullName")

    @Mapping(source = "sensor.id", target = "sensorId")
    @Mapping(source = "sensor.fullName", target = "sensorFullName")
    TransportDTO toDto(Transport transport); 
    @Mapping(target = "tasks", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")

    @Mapping(source = "warehouseId", target = "warehouse")

    @Mapping(source = "driverId", target = "driver")

    @Mapping(source = "sensorId", target = "sensor")
    Transport toEntity(TransportDTO transportDTO); 
    default Transport fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transport transport = new Transport();
        transport.setId(id);
        return transport;
    }
}
