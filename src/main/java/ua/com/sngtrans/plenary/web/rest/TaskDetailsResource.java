package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.TaskDetailsService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.TaskDetailsDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing TaskDetails.
 */
@RestController
@RequestMapping("/api")
public class TaskDetailsResource {

    private final Logger log = LoggerFactory.getLogger(TaskDetailsResource.class);

    private static final String ENTITY_NAME = "taskDetails";

    private final TaskDetailsService taskDetailsService;

    public TaskDetailsResource(TaskDetailsService taskDetailsService) {
        this.taskDetailsService = taskDetailsService;
    }

    /**
     * POST  /task-details : Create a new taskDetails.
     *
     * @param taskDetailsDTO the taskDetailsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new taskDetailsDTO, or with status 400 (Bad Request) if the taskDetails has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/task-details")
    @Timed
    public ResponseEntity<TaskDetailsDTO> createTaskDetails(@Valid @RequestBody TaskDetailsDTO taskDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save TaskDetails : {}", taskDetailsDTO);
        if (taskDetailsDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new taskDetails cannot already have an ID")).body(null);
        }
        TaskDetailsDTO result = taskDetailsService.save(taskDetailsDTO);
        return ResponseEntity.created(new URI("/api/task-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /task-details : Updates an existing taskDetails.
     *
     * @param taskDetailsDTO the taskDetailsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated taskDetailsDTO,
     * or with status 400 (Bad Request) if the taskDetailsDTO is not valid,
     * or with status 500 (Internal Server Error) if the taskDetailsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/task-details")
    @Timed
    public ResponseEntity<TaskDetailsDTO> updateTaskDetails(@Valid @RequestBody TaskDetailsDTO taskDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update TaskDetails : {}", taskDetailsDTO);
        if (taskDetailsDTO.getId() == null) {
            return createTaskDetails(taskDetailsDTO);
        }
        TaskDetailsDTO result = taskDetailsService.save(taskDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, taskDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /task-details : get all the taskDetails.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of taskDetails in body
     */
    @GetMapping("/task-details")
    @Timed
    public List<TaskDetailsDTO> getAllTaskDetails() {
        log.debug("REST request to get all TaskDetails");
        return taskDetailsService.findAll();
        }

    /**
     * GET  /task-details/:id : get the "id" taskDetails.
     *
     * @param id the id of the taskDetailsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the taskDetailsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/task-details/{id}")
    @Timed
    public ResponseEntity<TaskDetailsDTO> getTaskDetails(@PathVariable Long id) {
        log.debug("REST request to get TaskDetails : {}", id);
        TaskDetailsDTO taskDetailsDTO = taskDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(taskDetailsDTO));
    }

    /**
     * DELETE  /task-details/:id : delete the "id" taskDetails.
     *
     * @param id the id of the taskDetailsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/task-details/{id}")
    @Timed
    public ResponseEntity<Void> deleteTaskDetails(@PathVariable Long id) {
        log.debug("REST request to delete TaskDetails : {}", id);
        taskDetailsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/task-details?query=:query : search for the taskDetails corresponding
     * to the query.
     *
     * @param query the query of the taskDetails search
     * @return the result of the search
     */
    @GetMapping("/_search/task-details")
    @Timed
    public List<TaskDetailsDTO> searchTaskDetails(@RequestParam String query) {
        log.debug("REST request to search TaskDetails for query {}", query);
        return taskDetailsService.search(query);
    }

}
