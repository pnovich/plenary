package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.SettlementService;
import ua.com.sngtrans.plenary.domain.Settlement;
import ua.com.sngtrans.plenary.repository.SettlementRepository;
import ua.com.sngtrans.plenary.repository.search.SettlementSearchRepository;
import ua.com.sngtrans.plenary.service.dto.SettlementDTO;
import ua.com.sngtrans.plenary.service.mapper.SettlementMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Settlement.
 */
@Service
@Transactional
public class SettlementServiceImpl implements SettlementService{

    private final Logger log = LoggerFactory.getLogger(SettlementServiceImpl.class);

    private final SettlementRepository settlementRepository;

    private final SettlementMapper settlementMapper;

    private final SettlementSearchRepository settlementSearchRepository;
    public SettlementServiceImpl(SettlementRepository settlementRepository, SettlementMapper settlementMapper, SettlementSearchRepository settlementSearchRepository) {
        this.settlementRepository = settlementRepository;
        this.settlementMapper = settlementMapper;
        this.settlementSearchRepository = settlementSearchRepository;
    }

    /**
     * Save a settlement.
     *
     * @param settlementDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SettlementDTO save(SettlementDTO settlementDTO) {
        log.debug("Request to save Settlement : {}", settlementDTO);
        Settlement settlement = settlementMapper.toEntity(settlementDTO);
        settlement = settlementRepository.save(settlement);
        SettlementDTO result = settlementMapper.toDto(settlement);
        settlementSearchRepository.save(settlement);
        return result;
    }

    /**
     *  Get all the settlements.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SettlementDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Settlements");
        return settlementRepository.findAll(pageable)
            .map(settlementMapper::toDto);
    }

    /**
     *  Get one settlement by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SettlementDTO findOne(Long id) {
        log.debug("Request to get Settlement : {}", id);
        Settlement settlement = settlementRepository.findOne(id);
        return settlementMapper.toDto(settlement);
    }

    /**
     *  Delete the  settlement by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Settlement : {}", id);
        settlementRepository.delete(id);
        settlementSearchRepository.delete(id);
    }

    /**
     * Search for the settlement corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SettlementDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Settlements for query {}", query);
        Page<Settlement> result = settlementSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(settlementMapper::toDto);
    }
}
