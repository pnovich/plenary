package ua.com.sngtrans.plenary.service.impl;

import ua.com.sngtrans.plenary.service.TaskAvailableService;
import ua.com.sngtrans.plenary.domain.TaskAvailable;
import ua.com.sngtrans.plenary.repository.TaskAvailableRepository;
import ua.com.sngtrans.plenary.repository.search.TaskAvailableSearchRepository;
import ua.com.sngtrans.plenary.service.dto.TaskAvailableDTO;
import ua.com.sngtrans.plenary.service.mapper.TaskAvailableMapper;
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
 * Service Implementation for managing TaskAvailable.
 */
@Service
@Transactional
public class TaskAvailableServiceImpl implements TaskAvailableService{

    private final Logger log = LoggerFactory.getLogger(TaskAvailableServiceImpl.class);

    private final TaskAvailableRepository taskAvailableRepository;

    private final TaskAvailableMapper taskAvailableMapper;

    private final TaskAvailableSearchRepository taskAvailableSearchRepository;
    public TaskAvailableServiceImpl(TaskAvailableRepository taskAvailableRepository, TaskAvailableMapper taskAvailableMapper, TaskAvailableSearchRepository taskAvailableSearchRepository) {
        this.taskAvailableRepository = taskAvailableRepository;
        this.taskAvailableMapper = taskAvailableMapper;
        this.taskAvailableSearchRepository = taskAvailableSearchRepository;
    }

    /**
     * Save a taskAvailable.
     *
     * @param taskAvailableDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TaskAvailableDTO save(TaskAvailableDTO taskAvailableDTO) {
        log.debug("Request to save TaskAvailable : {}", taskAvailableDTO);
        TaskAvailable taskAvailable = taskAvailableMapper.toEntity(taskAvailableDTO);
        taskAvailable = taskAvailableRepository.save(taskAvailable);
        TaskAvailableDTO result = taskAvailableMapper.toDto(taskAvailable);
        taskAvailableSearchRepository.save(taskAvailable);
        return result;
    }

    /**
     *  Get all the taskAvailables.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TaskAvailableDTO> findAll() {
        log.debug("Request to get all TaskAvailables");
        return taskAvailableRepository.findAll().stream()
            .map(taskAvailableMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one taskAvailable by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TaskAvailableDTO findOne(Long id) {
        log.debug("Request to get TaskAvailable : {}", id);
        TaskAvailable taskAvailable = taskAvailableRepository.findOne(id);
        return taskAvailableMapper.toDto(taskAvailable);
    }

    /**
     *  Delete the  taskAvailable by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TaskAvailable : {}", id);
        taskAvailableRepository.delete(id);
        taskAvailableSearchRepository.delete(id);
    }

    /**
     * Search for the taskAvailable corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TaskAvailableDTO> search(String query) {
        log.debug("Request to search TaskAvailables for query {}", query);
        return StreamSupport
            .stream(taskAvailableSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(taskAvailableMapper::toDto)
            .collect(Collectors.toList());
    }
}
