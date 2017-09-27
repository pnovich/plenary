package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.TransportService;
import ua.com.sngtrans.plenary.domain.Transport;
import ua.com.sngtrans.plenary.repository.TransportRepository;
import ua.com.sngtrans.plenary.repository.search.TransportSearchRepository;
import ua.com.sngtrans.plenary.service.dto.TransportDTO;
import ua.com.sngtrans.plenary.service.mapper.TransportMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Transport.
 */
@Service
@Transactional
public class TransportServiceImpl implements TransportService{

    private final Logger log = LoggerFactory.getLogger(TransportServiceImpl.class);

    private final TransportRepository transportRepository;

    private final TransportMapper transportMapper;

    private final TransportSearchRepository transportSearchRepository;
    public TransportServiceImpl(TransportRepository transportRepository, TransportMapper transportMapper, TransportSearchRepository transportSearchRepository) {
        this.transportRepository = transportRepository;
        this.transportMapper = transportMapper;
        this.transportSearchRepository = transportSearchRepository;
    }

    /**
     * Save a transport.
     *
     * @param transportDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TransportDTO save(TransportDTO transportDTO) {
        log.debug("Request to save Transport : {}", transportDTO);
        Transport transport = transportMapper.toEntity(transportDTO);
        transport = transportRepository.save(transport);
        TransportDTO result = transportMapper.toDto(transport);
        transportSearchRepository.save(transport);
        return result;
    }

    /**
     *  Get all the transports.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TransportDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Transports");
        return transportRepository.findAll(pageable)
            .map(transportMapper::toDto);
    }

    /**
     *  Get one transport by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TransportDTO findOne(Long id) {
        log.debug("Request to get Transport : {}", id);
        Transport transport = transportRepository.findOne(id);
        return transportMapper.toDto(transport);
    }

    /**
     *  Delete the  transport by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Transport : {}", id);
        transportRepository.delete(id);
        transportSearchRepository.delete(id);
    }

    /**
     * Search for the transport corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TransportDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Transports for query {}", query);
        Page<Transport> result = transportSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(transportMapper::toDto);
    }
}
