package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.SensorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Sensor and its DTO SensorDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, })
public interface SensorMapper extends EntityMapper <SensorDTO, Sensor> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")

    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.fullName", target = "branchFullName")
    SensorDTO toDto(Sensor sensor); 
    @Mapping(target = "transports", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")
    Sensor toEntity(SensorDTO sensorDTO); 
    default Sensor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sensor sensor = new Sensor();
        sensor.setId(id);
        return sensor;
    }
}
