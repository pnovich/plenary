package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.CompanyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Company and its DTO CompanyDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CompanyMapper extends EntityMapper <CompanyDTO, Company> {
    
    @Mapping(target = "branches", ignore = true)
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)
    @Mapping(target = "drivers", ignore = true)
    @Mapping(target = "sensors", ignore = true)
    @Mapping(target = "transports", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Company toEntity(CompanyDTO companyDTO); 
    default Company fromId(Long id) {
        if (id == null) {
            return null;
        }
        Company company = new Company();
        company.setId(id);
        return company;
    }
}
