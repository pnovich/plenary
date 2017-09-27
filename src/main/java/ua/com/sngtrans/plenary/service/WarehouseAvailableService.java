package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.WarehouseAvailableDTO;
import java.util.List;

/**
 * Service Interface for managing WarehouseAvailable.
 */
public interface WarehouseAvailableService {

    /**
     * Save a warehouseAvailable.
     *
     * @param warehouseAvailableDTO the entity to save
     * @return the persisted entity
     */
    WarehouseAvailableDTO save(WarehouseAvailableDTO warehouseAvailableDTO);

    /**
     *  Get all the warehouseAvailables.
     *
     *  @return the list of entities
     */
    List<WarehouseAvailableDTO> findAll();

    /**
     *  Get the "id" warehouseAvailable.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    WarehouseAvailableDTO findOne(Long id);

    /**
     *  Delete the "id" warehouseAvailable.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the warehouseAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @return the list of entities
     */
    List<WarehouseAvailableDTO> search(String query);
}
