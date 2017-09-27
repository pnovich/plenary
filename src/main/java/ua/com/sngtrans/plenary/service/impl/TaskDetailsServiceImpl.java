package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.TaskDetailsService;
import ua.com.sngtrans.plenary.domain.TaskDetails;
import ua.com.sngtrans.plenary.repository.TaskDetailsRepository;
import ua.com.sngtrans.plenary.repository.search.TaskDetailsSearchRepository;
import ua.com.sngtrans.plenary.service.dto.TaskDetailsDTO;
import ua.com.sngtrans.plenary.service.mapper.TaskDetailsMapper;
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
 * Service Implementation for managing TaskDetails.
 */
@Service
@Transactional
public class TaskDetailsServiceImpl implements TaskDetailsService{

    private final Logger log = LoggerFactory.getLogger(TaskDetailsServiceImpl.class);

    private final TaskDetailsRepository taskDetailsRepository;

    private final TaskDetailsMapper taskDetailsMapper;

    private final TaskDetailsSearchRepository taskDetailsSearchRepository;
    public TaskDetailsServiceImpl(TaskDetailsRepository taskDetailsRepository, TaskDetailsMapper taskDetailsMapper, TaskDetailsSearchRepository taskDetailsSearchRepository) {
        this.taskDetailsRepository = taskDetailsRepository;
        this.taskDetailsMapper = taskDetailsMapper;
        this.taskDetailsSearchRepository = taskDetailsSearchRepository;
    }

    /**
     * Save a taskDetails.
     *
     * @param taskDetailsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TaskDetailsDTO save(TaskDetailsDTO taskDetailsDTO) {
        log.debug("Request to save TaskDetails : {}", taskDetailsDTO);
        TaskDetails taskDetails = taskDetailsMapper.toEntity(taskDetailsDTO);
        taskDetails = taskDetailsRepository.save(taskDetails);
        TaskDetailsDTO result = taskDetailsMapper.toDto(taskDetails);
        taskDetailsSearchRepository.save(taskDetails);
        return result;
    }

    /**
     *  Get all the taskDetails.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TaskDetailsDTO> findAll() {
        log.debug("Request to get all TaskDetails");
        return taskDetailsRepository.findAll().stream()
            .map(taskDetailsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one taskDetails by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TaskDetailsDTO findOne(Long id) {
        log.debug("Request to get TaskDetails : {}", id);
        TaskDetails taskDetails = taskDetailsRepository.findOne(id);
        return taskDetailsMapper.toDto(taskDetails);
    }

    /**
     *  Delete the  taskDetails by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TaskDetails : {}", id);
        taskDetailsRepository.delete(id);
        taskDetailsSearchRepository.delete(id);
    }

    /**
     * Search for the taskDetails corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TaskDetailsDTO> search(String query) {
        log.debug("Request to search TaskDetails for query {}", query);
        return StreamSupport
            .stream(taskDetailsSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(taskDetailsMapper::toDto)
            .collect(Collectors.toList());
    }
}
