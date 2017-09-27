package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.WarehouseAvailableService;
import ua.com.sngtrans.plenary.domain.WarehouseAvailable;
import ua.com.sngtrans.plenary.repository.WarehouseAvailableRepository;
import ua.com.sngtrans.plenary.repository.search.WarehouseAvailableSearchRepository;
import ua.com.sngtrans.plenary.service.dto.WarehouseAvailableDTO;
import ua.com.sngtrans.plenary.service.mapper.WarehouseAvailableMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing WarehouseAvailable.
 */
@Service
@Transactional
public class WarehouseAvailableServiceImpl implements WarehouseAvailableService{

    private final Logger log = LoggerFactory.getLogger(WarehouseAvailableServiceImpl.class);

    private final WarehouseAvailableRepository warehouseAvailableRepository;

    private final WarehouseAvailableMapper warehouseAvailableMapper;

    private final WarehouseAvailableSearchRepository warehouseAvailableSearchRepository;
    public WarehouseAvailableServiceImpl(WarehouseAvailableRepository warehouseAvailableRepository, WarehouseAvailableMapper warehouseAvailableMapper, WarehouseAvailableSearchRepository warehouseAvailableSearchRepository) {
        this.warehouseAvailableRepository = warehouseAvailableRepository;
        this.warehouseAvailableMapper = warehouseAvailableMapper;
        this.warehouseAvailableSearchRepository = warehouseAvailableSearchRepository;
    }

    /**
     * Save a warehouseAvailable.
     *
     * @param warehouseAvailableDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WarehouseAvailableDTO save(WarehouseAvailableDTO warehouseAvailableDTO) {
        log.debug("Request to save WarehouseAvailable : {}", warehouseAvailableDTO);
        WarehouseAvailable warehouseAvailable = warehouseAvailableMapper.toEntity(warehouseAvailableDTO);
        warehouseAvailable = warehouseAvailableRepository.save(warehouseAvailable);
        WarehouseAvailableDTO result = warehouseAvailableMapper.toDto(warehouseAvailable);
        warehouseAvailableSearchRepository.save(warehouseAvailable);
        return result;
    }

    /**
     *  Get all the warehouseAvailables.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<WarehouseAvailableDTO> findAll() {
        log.debug("Request to get all WarehouseAvailables");
        return warehouseAvailableRepository.findAll().stream()
            .map(warehouseAvailableMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one warehouseAvailable by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public WarehouseAvailableDTO findOne(Long id) {
        log.debug("Request to get WarehouseAvailable : {}", id);
        WarehouseAvailable warehouseAvailable = warehouseAvailableRepository.findOne(id);
        return warehouseAvailableMapper.toDto(warehouseAvailable);
    }

    /**
     *  Delete the  warehouseAvailable by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WarehouseAvailable : {}", id);
        warehouseAvailableRepository.delete(id);
        warehouseAvailableSearchRepository.delete(id);
    }

    /**
     * Search for the warehouseAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<WarehouseAvailableDTO> search(String query) {
        log.debug("Request to search WarehouseAvailables for query {}", query);
        return StreamSupport
            .stream(warehouseAvailableSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(warehouseAvailableMapper::toDto)
            .collect(Collectors.toList());
    }
}
