package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.PointsCoordinateDTO;
import java.util.List;

/**
 * Service Interface for managing PointsCoordinate.
 */
public interface PointsCoordinateService {

    /**
     * Save a pointsCoordinate.
     *
     * @param pointsCoordinateDTO the entity to save
     * @return the persisted entity
     */
    PointsCoordinateDTO save(PointsCoordinateDTO pointsCoordinateDTO);

    /**
     *  Get all the pointsCoordinates.
     *
     *  @return the list of entities
     */
    List<PointsCoordinateDTO> findAll();

    /**
     *  Get the "id" pointsCoordinate.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PointsCoordinateDTO findOne(Long id);

    /**
     *  Delete the "id" pointsCoordinate.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the pointsCoordinate corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<PointsCoordinateDTO> search(String query);
}
