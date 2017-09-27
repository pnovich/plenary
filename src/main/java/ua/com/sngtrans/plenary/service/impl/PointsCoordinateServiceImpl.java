package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.PointsCoordinateService;
import ua.com.sngtrans.plenary.domain.PointsCoordinate;
import ua.com.sngtrans.plenary.repository.PointsCoordinateRepository;
import ua.com.sngtrans.plenary.repository.search.PointsCoordinateSearchRepository;
import ua.com.sngtrans.plenary.service.dto.PointsCoordinateDTO;
import ua.com.sngtrans.plenary.service.mapper.PointsCoordinateMapper;
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
 * Service Implementation for managing PointsCoordinate.
 */
@Service
@Transactional
public class PointsCoordinateServiceImpl implements PointsCoordinateService{

    private final Logger log = LoggerFactory.getLogger(PointsCoordinateServiceImpl.class);

    private final PointsCoordinateRepository pointsCoordinateRepository;

    private final PointsCoordinateMapper pointsCoordinateMapper;

    private final PointsCoordinateSearchRepository pointsCoordinateSearchRepository;
    public PointsCoordinateServiceImpl(PointsCoordinateRepository pointsCoordinateRepository, PointsCoordinateMapper pointsCoordinateMapper, PointsCoordinateSearchRepository pointsCoordinateSearchRepository) {
        this.pointsCoordinateRepository = pointsCoordinateRepository;
        this.pointsCoordinateMapper = pointsCoordinateMapper;
        this.pointsCoordinateSearchRepository = pointsCoordinateSearchRepository;
    }

    /**
     * Save a pointsCoordinate.
     *
     * @param pointsCoordinateDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PointsCoordinateDTO save(PointsCoordinateDTO pointsCoordinateDTO) {
        log.debug("Request to save PointsCoordinate : {}", pointsCoordinateDTO);
        PointsCoordinate pointsCoordinate = pointsCoordinateMapper.toEntity(pointsCoordinateDTO);
        pointsCoordinate = pointsCoordinateRepository.save(pointsCoordinate);
        PointsCoordinateDTO result = pointsCoordinateMapper.toDto(pointsCoordinate);
        pointsCoordinateSearchRepository.save(pointsCoordinate);
        return result;
    }

    /**
     *  Get all the pointsCoordinates.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsCoordinateDTO> findAll() {
        log.debug("Request to get all PointsCoordinates");
        return pointsCoordinateRepository.findAll().stream()
            .map(pointsCoordinateMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one pointsCoordinate by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PointsCoordinateDTO findOne(Long id) {
        log.debug("Request to get PointsCoordinate : {}", id);
        PointsCoordinate pointsCoordinate = pointsCoordinateRepository.findOne(id);
        return pointsCoordinateMapper.toDto(pointsCoordinate);
    }

    /**
     *  Delete the  pointsCoordinate by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PointsCoordinate : {}", id);
        pointsCoordinateRepository.delete(id);
        pointsCoordinateSearchRepository.delete(id);
    }

    /**
     * Search for the pointsCoordinate corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsCoordinateDTO> search(String query) {
        log.debug("Request to search PointsCoordinates for query {}", query);
        return StreamSupport
            .stream(pointsCoordinateSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(pointsCoordinateMapper::toDto)
            .collect(Collectors.toList());
    }
}
