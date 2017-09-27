package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.TaskAvailableDTO;
import java.util.List;

/**
 * Service Interface for managing TaskAvailable.
 */
public interface TaskAvailableService {

    /**
     * Save a taskAvailable.
     *
     * @param taskAvailableDTO the entity to save
     * @return the persisted entity
     */
    TaskAvailableDTO save(TaskAvailableDTO taskAvailableDTO);

    /**
     *  Get all the taskAvailables.
     *
     *  @return the list of entities
     */
    List<TaskAvailableDTO> findAll();

    /**
     *  Get the "id" taskAvailable.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TaskAvailableDTO findOne(Long id);

    /**
     *  Delete the "id" taskAvailable.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the taskAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<TaskAvailableDTO> search(String query);
}
