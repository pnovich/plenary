package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.WarehouseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Warehouse and its DTO WarehouseDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, CountryMapper.class, RegionMapper.class, SettlementMapper.class, StreetMapper.class, })
public interface WarehouseMapper extends EntityMapper <WarehouseDTO, Warehouse> {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "company.fullName", target = "companyFullName")

    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "branch.fullName", target = "branchFullName")

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.fullName", target = "countryFullName")

    @Mapping(source = "region.id", target = "regionId")
    @Mapping(source = "region.fullName", target = "regionFullName")

    @Mapping(source = "settlement.id", target = "settlementId")
    @Mapping(source = "settlement.fullName", target = "settlementFullName")

    @Mapping(source = "street.id", target = "streetId")
    @Mapping(source = "street.fullName", target = "streetFullName")
    WarehouseDTO toDto(Warehouse warehouse); 
    @Mapping(target = "warehouseAvailables", ignore = true)
    @Mapping(target = "transports", ignore = true)
    @Mapping(target = "tasks", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")

    @Mapping(source = "countryId", target = "country")

    @Mapping(source = "regionId", target = "region")

    @Mapping(source = "settlementId", target = "settlement")

    @Mapping(source = "streetId", target = "street")
    Warehouse toEntity(WarehouseDTO warehouseDTO); 
    default Warehouse fromId(Long id) {
        if (id == null) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        return warehouse;
    }
}
