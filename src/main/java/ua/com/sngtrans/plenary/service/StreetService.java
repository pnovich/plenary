package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.StreetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Street.
 */
public interface StreetService {

    /**
     * Save a street.
     *
     * @param streetDTO the entity to save
     * @return the persisted entity
     */
    StreetDTO save(StreetDTO streetDTO);

    /**
     *  Get all the streets.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<StreetDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" street.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    StreetDTO findOne(Long id);

    /**
     *  Delete the "id" street.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the street corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<StreetDTO> search(String query, Pageable pageable);
}
