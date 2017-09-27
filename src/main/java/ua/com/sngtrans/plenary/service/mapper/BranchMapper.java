package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.BranchDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Branch and its DTO BranchDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, })
public interface BranchMapper extends EntityMapper <BranchDTO, Branch> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")
    BranchDTO toDto(Branch branch); 
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)
    @Mapping(target = "drivers", ignore = true)
    @Mapping(target = "sensors", ignore = true)
    @Mapping(target = "transports", ignore = true)
    @Mapping(target = "tasks", ignore = true)

    @Mapping(source = "companyId", target = "company")
    Branch toEntity(BranchDTO branchDTO); 
    default Branch fromId(Long id) {
        if (id == null) {
            return null;
        }
        Branch branch = new Branch();
        branch.setId(id);
        return branch;
    }
}
