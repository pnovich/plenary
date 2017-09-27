package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.TaskDetailsDTO;
import java.util.List;

/**
 * Service Interface for managing TaskDetails.
 */
public interface TaskDetailsService {

    /**
     * Save a taskDetails.
     *
     * @param taskDetailsDTO the entity to save
     * @return the persisted entity
     */
    TaskDetailsDTO save(TaskDetailsDTO taskDetailsDTO);

    /**
     *  Get all the taskDetails.
     *
     *  @return the list of entities
     */
    List<TaskDetailsDTO> findAll();

    /**
     *  Get the "id" taskDetails.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TaskDetailsDTO findOne(Long id);

    /**
     *  Delete the "id" taskDetails.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the taskDetails corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<TaskDetailsDTO> search(String query);
}
