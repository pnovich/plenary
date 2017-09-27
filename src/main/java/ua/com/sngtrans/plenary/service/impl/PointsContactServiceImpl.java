package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.PointsContactService;
import ua.com.sngtrans.plenary.domain.PointsContact;
import ua.com.sngtrans.plenary.repository.PointsContactRepository;
import ua.com.sngtrans.plenary.repository.search.PointsContactSearchRepository;
import ua.com.sngtrans.plenary.service.dto.PointsContactDTO;
import ua.com.sngtrans.plenary.service.mapper.PointsContactMapper;
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
 * Service Implementation for managing PointsContact.
 */
@Service
@Transactional
public class PointsContactServiceImpl implements PointsContactService{

    private final Logger log = LoggerFactory.getLogger(PointsContactServiceImpl.class);

    private final PointsContactRepository pointsContactRepository;

    private final PointsContactMapper pointsContactMapper;

    private final PointsContactSearchRepository pointsContactSearchRepository;
    public PointsContactServiceImpl(PointsContactRepository pointsContactRepository, PointsContactMapper pointsContactMapper, PointsContactSearchRepository pointsContactSearchRepository) {
        this.pointsContactRepository = pointsContactRepository;
        this.pointsContactMapper = pointsContactMapper;
        this.pointsContactSearchRepository = pointsContactSearchRepository;
    }

    /**
     * Save a pointsContact.
     *
     * @param pointsContactDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PointsContactDTO save(PointsContactDTO pointsContactDTO) {
        log.debug("Request to save PointsContact : {}", pointsContactDTO);
        PointsContact pointsContact = pointsContactMapper.toEntity(pointsContactDTO);
        pointsContact = pointsContactRepository.save(pointsContact);
        PointsContactDTO result = pointsContactMapper.toDto(pointsContact);
        pointsContactSearchRepository.save(pointsContact);
        return result;
    }

    /**
     *  Get all the pointsContacts.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsContactDTO> findAll() {
        log.debug("Request to get all PointsContacts");
        return pointsContactRepository.findAll().stream()
            .map(pointsContactMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one pointsContact by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PointsContactDTO findOne(Long id) {
        log.debug("Request to get PointsContact : {}", id);
        PointsContact pointsContact = pointsContactRepository.findOne(id);
        return pointsContactMapper.toDto(pointsContact);
    }

    /**
     *  Delete the  pointsContact by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PointsContact : {}", id);
        pointsContactRepository.delete(id);
        pointsContactSearchRepository.delete(id);
    }

    /**
     * Search for the pointsContact corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PointsContactDTO> search(String query) {
        log.debug("Request to search PointsContacts for query {}", query);
        return StreamSupport
            .stream(pointsContactSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(pointsContactMapper::toDto)
            .collect(Collectors.toList());
    }
}
