package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.PointsAvailableService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.PointsAvailableDTO;
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
 * REST controller for managing PointsAvailable.
 */
@RestController
@RequestMapping("/api")
public class PointsAvailableResource {

    private final Logger log = LoggerFactory.getLogger(PointsAvailableResource.class);

    private static final String ENTITY_NAME = "pointsAvailable";

    private final PointsAvailableService pointsAvailableService;

    public PointsAvailableResource(PointsAvailableService pointsAvailableService) {
        this.pointsAvailableService = pointsAvailableService;
    }

    /**
     * POST  /points-availables : Create a new pointsAvailable.
     *
     * @param pointsAvailableDTO the pointsAvailableDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pointsAvailableDTO, or with status 400 (Bad Request) if the pointsAvailable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/points-availables")
    @Timed
    public ResponseEntity<PointsAvailableDTO> createPointsAvailable(@Valid @RequestBody PointsAvailableDTO pointsAvailableDTO) throws URISyntaxException {
        log.debug("REST request to save PointsAvailable : {}", pointsAvailableDTO);
        if (pointsAvailableDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new pointsAvailable cannot already have an ID")).body(null);
        }
        PointsAvailableDTO result = pointsAvailableService.save(pointsAvailableDTO);
        return ResponseEntity.created(new URI("/api/points-availables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /points-availables : Updates an existing pointsAvailable.
     *
     * @param pointsAvailableDTO the pointsAvailableDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pointsAvailableDTO,
     * or with status 400 (Bad Request) if the pointsAvailableDTO is not valid,
     * or with status 500 (Internal Server Error) if the pointsAvailableDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/points-availables")
    @Timed
    public ResponseEntity<PointsAvailableDTO> updatePointsAvailable(@Valid @RequestBody PointsAvailableDTO pointsAvailableDTO) throws URISyntaxException {
        log.debug("REST request to update PointsAvailable : {}", pointsAvailableDTO);
        if (pointsAvailableDTO.getId() == null) {
            return createPointsAvailable(pointsAvailableDTO);
        }
        PointsAvailableDTO result = pointsAvailableService.save(pointsAvailableDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, pointsAvailableDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /points-availables : get all the pointsAvailables.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of pointsAvailables in body
     */
    @GetMapping("/points-availables")
    @Timed
    public List<PointsAvailableDTO> getAllPointsAvailables() {
        log.debug("REST request to get all PointsAvailables");
        return pointsAvailableService.findAll();
        }

    /**
     * GET  /points-availables/:id : get the "id" pointsAvailable.
     *
     * @param id the id of the pointsAvailableDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pointsAvailableDTO, or with status 404 (Not Found)
     */
    @GetMapping("/points-availables/{id}")
    @Timed
    public ResponseEntity<PointsAvailableDTO> getPointsAvailable(@PathVariable Long id) {
        log.debug("REST request to get PointsAvailable : {}", id);
        PointsAvailableDTO pointsAvailableDTO = pointsAvailableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(pointsAvailableDTO));
    }

    /**
     * DELETE  /points-availables/:id : delete the "id" pointsAvailable.
     *
     * @param id the id of the pointsAvailableDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/points-availables/{id}")
    @Timed
    public ResponseEntity<Void> deletePointsAvailable(@PathVariable Long id) {
        log.debug("REST request to delete PointsAvailable : {}", id);
        pointsAvailableService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/points-availables?query=:query : search for the pointsAvailable corresponding
     * to the query.
     *
     * @param query the query of the pointsAvailable search
     * @return the result of the search
     */
    @GetMapping("/_search/points-availables")
    @Timed
    public List<PointsAvailableDTO> searchPointsAvailables(@RequestParam String query) {
        log.debug("REST request to search PointsAvailables for query {}", query);
        return pointsAvailableService.search(query);
    }

}
