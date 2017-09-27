package ua.com.sngtrans.plenary.service;

import ua.com.sngtrans.plenary.service.dto.SensorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Sensor.
 */
public interface SensorService {

    /**
     * Save a sensor.
     *
     * @param sensorDTO the entity to save
     * @return the persisted entity
     */
    SensorDTO save(SensorDTO sensorDTO);

    /**
     *  Get all the sensors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<SensorDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" sensor.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    SensorDTO findOne(Long id);

    /**
     *  Delete the "id" sensor.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sensor corresponding to the query.
     *
     *  @param query the query of the search
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<SensorDTO> search(String query, Pageable pageable);
}
