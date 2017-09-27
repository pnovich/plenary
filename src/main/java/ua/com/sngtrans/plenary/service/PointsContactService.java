package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.PointsContactDTO;
import java.util.List;

/**
 * Service Interface for managing PointsContact.
 */
public interface PointsContactService {

    /**
     * Save a pointsContact.
     *
     * @param pointsContactDTO the entity to save
     * @return the persisted entity
     */
    PointsContactDTO save(PointsContactDTO pointsContactDTO);

    /**
     *  Get all the pointsContacts.
     *
     *  @return the list of entities
     */
    List<PointsContactDTO> findAll();

    /**
     *  Get the "id" pointsContact.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    PointsContactDTO findOne(Long id);

    /**
     *  Delete the "id" pointsContact.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the pointsContact corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<PointsContactDTO> search(String query);
}
