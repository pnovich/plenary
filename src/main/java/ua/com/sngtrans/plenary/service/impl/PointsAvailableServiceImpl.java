package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.PointsAvailableService;
import ua.com.sngtrans.plenary.domain.PointsAvailable;
import ua.com.sngtrans.plenary.repository.PointsAvailableRepository;
import ua.com.sngtrans.plenary.repository.search.PointsAvailableSearchRepository;
import ua.com.sngtrans.plenary.service.dto.PointsAvailableDTO;
import ua.com.sngtrans.plenary.service.mapper.PointsAvailableMapper;
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
 * Service Implementation for managing PointsAvailable.
 */
@Service
@Transactional
public class PointsAvailableServiceImpl implements PointsAvailableService{

    private final Logger log = LoggerFactory.getLogger(PointsAvailableServiceImpl.class);

    private final PointsAvailableRepository pointsAvailableRepository;

    private final PointsAvailableMapper pointsAvailableMapper;

    private final PointsAvailableSearchRepository pointsAvailableSearchRepository;
    public PointsAvailableServiceImpl(PointsAvailableRepository pointsAvailableRepository, PointsAvailableMapper pointsAvailableMapper, PointsAvailableSearchRepository pointsAvailableSearchRepository) {
        this.pointsAvailableRepository = pointsAvailableRepository;
        this.pointsAvailableMapper = pointsAvailableMapper;
        this.pointsAvailableSearchRepository = pointsAvailableSearchRepository;
    }

    /**
     * Save a pointsAvailable.
     *
     * @param pointsAvailableDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PointsAvailableDTO save(PointsAvailableDTO pointsAvailableDTO) {
        log.debug("Request to save PointsAvailable : {}", pointsAvailableDTO);
        PointsAvailable pointsAvailable = pointsAvailableMapper.toEntity(pointsAvailableDTO);
        pointsAvailable = pointsAvailableRepository.save(pointsAvailable);
        PointsAvailableDTO result = pointsAvailableMapper.toDto(pointsAvailable);
        pointsAvailableSearchRepository.save(pointsAvailable);
        return result;
    }

    /**
     *  Get all the pointsAvailables.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsAvailableDTO> findAll() {
        log.debug("Request to get all PointsAvailables");
        return pointsAvailableRepository.findAll().stream()
            .map(pointsAvailableMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one pointsAvailable by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PointsAvailableDTO findOne(Long id) {
        log.debug("Request to get PointsAvailable : {}", id);
        PointsAvailable pointsAvailable = pointsAvailableRepository.findOne(id);
        return pointsAvailableMapper.toDto(pointsAvailable);
    }

    /**
     *  Delete the  pointsAvailable by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PointsAvailable : {}", id);
        pointsAvailableRepository.delete(id);
        pointsAvailableSearchRepository.delete(id);
    }

    /**
     * Search for the pointsAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsAvailableDTO> search(String query) {
        log.debug("Request to search PointsAvailables for query {}", query);
        return StreamSupport
            .stream(pointsAvailableSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(pointsAvailableMapper::toDto)
            .collect(Collectors.toList());
    }
}
