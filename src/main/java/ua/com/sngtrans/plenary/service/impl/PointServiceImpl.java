package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.PointService;
import ua.com.sngtrans.plenary.domain.Point;
import ua.com.sngtrans.plenary.repository.PointRepository;
import ua.com.sngtrans.plenary.repository.search.PointSearchRepository;
import ua.com.sngtrans.plenary.service.dto.PointDTO;
import ua.com.sngtrans.plenary.service.mapper.PointMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Point.
 */
@Service
@Transactional
public class PointServiceImpl implements PointService{

    private final Logger log = LoggerFactory.getLogger(PointServiceImpl.class);

    private final PointRepository pointRepository;

    private final PointMapper pointMapper;

    private final PointSearchRepository pointSearchRepository;
    public PointServiceImpl(PointRepository pointRepository, PointMapper pointMapper, PointSearchRepository pointSearchRepository) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
        this.pointSearchRepository = pointSearchRepository;
    }

    /**
     * Save a point.
     *
     * @param pointDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PointDTO save(PointDTO pointDTO) {
        log.debug("Request to save Point : {}", pointDTO);
        Point point = pointMapper.toEntity(pointDTO);
        point = pointRepository.save(point);
        PointDTO result = pointMapper.toDto(point);
        pointSearchRepository.save(point);
        return result;
    }

    /**
     *  Get all the points.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PointDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Points");
        return pointRepository.findAll(pageable)
            .map(pointMapper::toDto);
    }

    /**
     *  Get one point by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PointDTO findOne(Long id) {
        log.debug("Request to get Point : {}", id);
        Point point = pointRepository.findOne(id);
        return pointMapper.toDto(point);
    }

    /**
     *  Delete the  point by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Point : {}", id);
        pointRepository.delete(id);
        pointSearchRepository.delete(id);
    }

    /**
     * Search for the point corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PointDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Points for query {}", query);
        Page<Point> result = pointSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(pointMapper::toDto);
    }
}
