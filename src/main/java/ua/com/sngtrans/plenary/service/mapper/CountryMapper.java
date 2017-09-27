package ua.com.sngtrans.plenary.service.mapper;

import ua.com.sngtrans.plenary.domain.*;
import ua.com.sngtrans.plenary.service.dto.CountryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Country and its DTO CountryDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CountryMapper extends EntityMapper <CountryDTO, Country> {
    
    @Mapping(target = "regions", ignore = true)
    @Mapping(target = "warehouses", ignore = true)
    @Mapping(target = "points", ignore = true)
    Country toEntity(CountryDTO countryDTO); 
    default Country fromId(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }
}
