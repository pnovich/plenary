package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.TaskAvailableService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.TaskAvailableDTO;
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
 * REST controller for managing TaskAvailable.
 */
@RestController
@RequestMapping("/api")
public class TaskAvailableResource {

    private final Logger log = LoggerFactory.getLogger(TaskAvailableResource.class);

    private static final String ENTITY_NAME = "taskAvailable";

    private final TaskAvailableService taskAvailableService;

    public TaskAvailableResource(TaskAvailableService taskAvailableService) {
        this.taskAvailableService = taskAvailableService;
    }

    /**
     * POST  /task-availables : Create a new taskAvailable.
     *
     * @param taskAvailableDTO the taskAvailableDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new taskAvailableDTO, or with status 400 (Bad Request) if the taskAvailable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/task-availables")
    @Timed
    public ResponseEntity<TaskAvailableDTO> createTaskAvailable(@Valid @RequestBody TaskAvailableDTO taskAvailableDTO) throws URISyntaxException {
        log.debug("REST request to save TaskAvailable : {}", taskAvailableDTO);
        if (taskAvailableDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new taskAvailable cannot already have an ID")).body(null);
        }
        TaskAvailableDTO result = taskAvailableService.save(taskAvailableDTO);
        return ResponseEntity.created(new URI("/api/task-availables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /task-availables : Updates an existing taskAvailable.
     *
     * @param taskAvailableDTO the taskAvailableDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated taskAvailableDTO,
     * or with status 400 (Bad Request) if the taskAvailableDTO is not valid,
     * or with status 500 (Internal Server Error) if the taskAvailableDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/task-availables")
    @Timed
    public ResponseEntity<TaskAvailableDTO> updateTaskAvailable(@Valid @RequestBody TaskAvailableDTO taskAvailableDTO) throws URISyntaxException {
        log.debug("REST request to update TaskAvailable : {}", taskAvailableDTO);
        if (taskAvailableDTO.getId() == null) {
            return createTaskAvailable(taskAvailableDTO);
        }
        TaskAvailableDTO result = taskAvailableService.save(taskAvailableDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, taskAvailableDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /task-availables : get all the taskAvailables.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of taskAvailables in body
     */
    @GetMapping("/task-availables")
    @Timed
    public List<TaskAvailableDTO> getAllTaskAvailables() {
        log.debug("REST request to get all TaskAvailables");
        return taskAvailableService.findAll();
        }

    /**
     * GET  /task-availables/:id : get the "id" taskAvailable.
     *
     * @param id the id of the taskAvailableDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the taskAvailableDTO, or with status 404 (Not Found)
     */
    @GetMapping("/task-availables/{id}")
    @Timed
    public ResponseEntity<TaskAvailableDTO> getTaskAvailable(@PathVariable Long id) {
        log.debug("REST request to get TaskAvailable : {}", id);
        TaskAvailableDTO taskAvailableDTO = taskAvailableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(taskAvailableDTO));
    }

    /**
     * DELETE  /task-availables/:id : delete the "id" taskAvailable.
     *
     * @param id the id of the taskAvailableDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/task-availables/{id}")
    @Timed
    public ResponseEntity<Void> deleteTaskAvailable(@PathVariable Long id) {
        log.debug("REST request to delete TaskAvailable : {}", id);
        taskAvailableService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/task-availables?query=:query : search for the taskAvailable corresponding
     * to the query.
     *
     * @param query the query of the taskAvailable search
     * @return the result of the search
     */
    @GetMapping("/_search/task-availables")
    @Timed
    public List<TaskAvailableDTO> searchTaskAvailables(@RequestParam String query) {
        log.debug("REST request to search TaskAvailables for query {}", query);
        return taskAvailableService.search(query);
    }

}
