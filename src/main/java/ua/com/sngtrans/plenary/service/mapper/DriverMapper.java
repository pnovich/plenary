package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.DriverDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Driver and its DTO DriverDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, })
public interface DriverMapper extends EntityMapper <DriverDTO, Driver> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")

    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.fullName", target = "branchFullName")
    DriverDTO toDto(Driver driver); 
    @Mapping(target = "transports", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")
    Driver toEntity(DriverDTO driverDTO); 
    default Driver fromId(Long id) {
        if (id == null) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(id);
        return driver;
    }
}
