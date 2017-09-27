package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.BranchService;
import ua.com.sngtrans.plenary.domain.Branch;
import ua.com.sngtrans.plenary.repository.BranchRepository;
import ua.com.sngtrans.plenary.repository.search.BranchSearchRepository;
import ua.com.sngtrans.plenary.service.dto.BranchDTO;
import ua.com.sngtrans.plenary.service.mapper.BranchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Branch.
 */
@Service
@Transactional
public class BranchServiceImpl implements BranchService{

    private final Logger log = LoggerFactory.getLogger(BranchServiceImpl.class);

    private final BranchRepository branchRepository;

    private final BranchMapper branchMapper;

    private final BranchSearchRepository branchSearchRepository;
    public BranchServiceImpl(BranchRepository branchRepository, BranchMapper branchMapper, BranchSearchRepository branchSearchRepository) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
        this.branchSearchRepository = branchSearchRepository;
    }

    /**
     * Save a branch.
     *
     * @param branchDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        log.debug("Request to save Branch : {}", branchDTO);
        Branch branch = branchMapper.toEntity(branchDTO);
        branch = branchRepository.save(branch);
        BranchDTO result = branchMapper.toDto(branch);
        branchSearchRepository.save(branch);
        return result;
    }

    /**
     *  Get all the branches.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BranchDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Branches");
        return branchRepository.findAll(pageable)
            .map(branchMapper::toDto);
    }

    /**
     *  Get one branch by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BranchDTO findOne(Long id) {
        log.debug("Request to get Branch : {}", id);
        Branch branch = branchRepository.findOne(id);
        return branchMapper.toDto(branch);
    }

    /**
     *  Delete the  branch by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Branch : {}", id);
        branchRepository.delete(id);
        branchSearchRepository.delete(id);
    }

    /**
     * Search for the branch corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BranchDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Branches for query {}", query);
        Page<Branch> result = branchSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(branchMapper::toDto);
    }
}
