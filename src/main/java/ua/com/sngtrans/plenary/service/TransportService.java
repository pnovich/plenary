package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.TransportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Transport.
 */
public interface TransportService {

    /**
     * Save a transport.
     *
     * @param transportDTO the entity to save
     * @return the persisted entity
     */
    TransportDTO save(TransportDTO transportDTO);

    /**
     *  Get all the transports.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TransportDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" transport.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    TransportDTO findOne(Long id);

    /**
     *  Delete the "id" transport.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the transport corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<TransportDTO> search(String query, Pageable pageable);
}
