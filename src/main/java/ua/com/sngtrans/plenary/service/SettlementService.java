package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.SettlementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Settlement.
 */
public interface SettlementService {

    /**
     * Save a settlement.
     *
     * @param settlementDTO the entity to save
     * @return the persisted entity
     */
    SettlementDTO save(SettlementDTO settlementDTO);

    /**
     *  Get all the settlements.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<SettlementDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" settlement.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    SettlementDTO findOne(Long id);

    /**
     *  Delete the "id" settlement.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the settlement corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<SettlementDTO> search(String query, Pageable pageable);
}
