package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.PointDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Point and its DTO PointDTO.
 */
@Mapper(componentModel = "spring", uses = {CompanyMapper.class, BranchMapper.class, CountryMapper.class, RegionMapper.class, SettlementMapper.class, StreetMapper.class, })
public interface PointMapper extends EntityMapper <PointDTO, Point> {

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
    PointDTO toDto(Point point); 
    @Mapping(target = "pointsCoordinates", ignore = true)
    @Mapping(target = "pointsAvailables", ignore = true)
    @Mapping(target = "pointsContacts", ignore = true)
    @Mapping(target = "tasks", ignore = true)

    @Mapping(source = "companyId", target = "company")

    @Mapping(source = "branchId", target = "branch")

    @Mapping(source = "countryId", target = "country")

    @Mapping(source = "regionId", target = "region")

    @Mapping(source = "settlementId", target = "settlement")

    @Mapping(source = "streetId", target = "street")
    Point toEntity(PointDTO pointDTO); 
    default Point fromId(Long id) {
        if (id == null) {
            return null;
        }
        Point point = new Point();
        point.setId(id);
        return point;
    }
}
