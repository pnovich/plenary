package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.PointDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Point.
 */
public interface PointService {

    /**
     * Save a point.
     *
     * @param pointDTO the entity to save
     * @return the persisted entity
     */
    PointDTO save(PointDTO pointDTO);

    /**
     *  Get all the points.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PointDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" point.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PointDTO findOne(Long id);

    /**
     *  Delete the "id" point.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the point corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<PointDTO> search(String query, Pageable pageable);
}
