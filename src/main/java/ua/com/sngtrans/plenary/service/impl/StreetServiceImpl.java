package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.StreetService;
import ua.com.sngtrans.plenary.domain.Street;
import ua.com.sngtrans.plenary.repository.StreetRepository;
import ua.com.sngtrans.plenary.repository.search.StreetSearchRepository;
import ua.com.sngtrans.plenary.service.dto.StreetDTO;
import ua.com.sngtrans.plenary.service.mapper.StreetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Street.
 */
@Service
@Transactional
public class StreetServiceImpl implements StreetService{

    private final Logger log = LoggerFactory.getLogger(StreetServiceImpl.class);

    private final StreetRepository streetRepository;

    private final StreetMapper streetMapper;

    private final StreetSearchRepository streetSearchRepository;
    public StreetServiceImpl(StreetRepository streetRepository, StreetMapper streetMapper, StreetSearchRepository streetSearchRepository) {
        this.streetRepository = streetRepository;
        this.streetMapper = streetMapper;
        this.streetSearchRepository = streetSearchRepository;
    }

    /**
     * Save a street.
     *
     * @param streetDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public StreetDTO save(StreetDTO streetDTO) {
        log.debug("Request to save Street : {}", streetDTO);
        Street street = streetMapper.toEntity(streetDTO);
        street = streetRepository.save(street);
        StreetDTO result = streetMapper.toDto(street);
        streetSearchRepository.save(street);
        return result;
    }

    /**
     *  Get all the streets.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StreetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Streets");
        return streetRepository.findAll(pageable)
            .map(streetMapper::toDto);
    }

    /**
     *  Get one street by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public StreetDTO findOne(Long id) {
        log.debug("Request to get Street : {}", id);
        Street street = streetRepository.findOne(id);
        return streetMapper.toDto(street);
    }

    /**
     *  Delete the  street by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Street : {}", id);
        streetRepository.delete(id);
        streetSearchRepository.delete(id);
    }

    /**
     * Search for the street corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StreetDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Streets for query {}", query);
        Page<Street> result = streetSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(streetMapper::toDto);
    }
}
