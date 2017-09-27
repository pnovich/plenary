package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.SensorService;
import ua.com.sngtrans.plenary.domain.Sensor;
import ua.com.sngtrans.plenary.repository.SensorRepository;
import ua.com.sngtrans.plenary.repository.search.SensorSearchRepository;
import ua.com.sngtrans.plenary.service.dto.SensorDTO;
import ua.com.sngtrans.plenary.service.mapper.SensorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Sensor.
 */
@Service
@Transactional
public class SensorServiceImpl implements SensorService{

    private final Logger log = LoggerFactory.getLogger(SensorServiceImpl.class);

    private final SensorRepository sensorRepository;

    private final SensorMapper sensorMapper;

    private final SensorSearchRepository sensorSearchRepository;
    public SensorServiceImpl(SensorRepository sensorRepository, SensorMapper sensorMapper, SensorSearchRepository sensorSearchRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorMapper = sensorMapper;
        this.sensorSearchRepository = sensorSearchRepository;
    }

    /**
     * Save a sensor.
     *
     * @param sensorDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SensorDTO save(SensorDTO sensorDTO) {
        log.debug("Request to save Sensor : {}", sensorDTO);
        Sensor sensor = sensorMapper.toEntity(sensorDTO);
        sensor = sensorRepository.save(sensor);
        SensorDTO result = sensorMapper.toDto(sensor);
        sensorSearchRepository.save(sensor);
        return result;
    }

    /**
     *  Get all the sensors.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SensorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Sensors");
        return sensorRepository.findAll(pageable)
            .map(sensorMapper::toDto);
    }

    /**
     *  Get one sensor by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SensorDTO findOne(Long id) {
        log.debug("Request to get Sensor : {}", id);
        Sensor sensor = sensorRepository.findOne(id);
        return sensorMapper.toDto(sensor);
    }

    /**
     *  Delete the  sensor by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sensor : {}", id);
        sensorRepository.delete(id);
        sensorSearchRepository.delete(id);
    }

    /**
     * Search for the sensor corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SensorDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Sensors for query {}", query);
        Page<Sensor> result = sensorSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sensorMapper::toDto);
    }
}
