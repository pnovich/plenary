package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.PointsAvailableDTO;
import java.util.List;

/**
 * Service Interface for managing PointsAvailable.
 */
public interface PointsAvailableService {

    /**
     * Save a pointsAvailable.
     *
     * @param pointsAvailableDTO the entity to save
     * @return the persisted entity
     */
    PointsAvailableDTO save(PointsAvailableDTO pointsAvailableDTO);

    /**
     *  Get all the pointsAvailables.
     *
     *  @return the list of entities
     */
    List<PointsAvailableDTO> findAll();

    /**
     *  Get the "id" pointsAvailable.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PointsAvailableDTO findOne(Long id);

    /**
     *  Delete the "id" pointsAvailable.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the pointsAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<PointsAvailableDTO> search(String query);
}
