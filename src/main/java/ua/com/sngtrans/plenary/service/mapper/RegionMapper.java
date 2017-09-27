package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.RegionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Region and its DTO RegionDTO.
 */
@Mapper(componentModel = "spring", uses = {CountryMapper.class, })
public interface RegionMapper extends EntityMapper <RegionDTO, Region> {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.fullName", target = "countryFullName")
    RegionDTO toDto(Region region); 
    @Mapping(target = "settlements", ignore = true)
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)

    @Mapping(source = "countryId", target = "country")
    Region toEntity(RegionDTO regionDTO); 
    default Region fromId(Long id) {
        if (id == null) {
            return null;
        }
        Region region = new Region();
        region.setId(id);
        return region;
    }
}
