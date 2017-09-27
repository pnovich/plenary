package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.PointsContactService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.PointsContactDTO;
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
 * REST controller for managing PointsContact.
 */
@RestController
@RequestMapping("/api")
public class PointsContactResource {

    private final Logger log = LoggerFactory.getLogger(PointsContactResource.class);

    private static final String ENTITY_NAME = "pointsContact";

    private final PointsContactService pointsContactService;

    public PointsContactResource(PointsContactService pointsContactService) {
        this.pointsContactService = pointsContactService;
    }

    /**
     * POST  /points-contacts : Create a new pointsContact.
     *
     * @param pointsContactDTO the pointsContactDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pointsContactDTO, or with status 400 (Bad Request) if the pointsContact has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/points-contacts")
    @Timed
    public ResponseEntity<PointsContactDTO> createPointsContact(@Valid @RequestBody PointsContactDTO pointsContactDTO) throws URISyntaxException {
        log.debug("REST request to save PointsContact : {}", pointsContactDTO);
        if (pointsContactDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new pointsContact cannot already have an ID")).body(null);
        }
        PointsContactDTO result = pointsContactService.save(pointsContactDTO);
        return ResponseEntity.created(new URI("/api/points-contacts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /points-contacts : Updates an existing pointsContact.
     *
     * @param pointsContactDTO the pointsContactDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pointsContactDTO,
     * or with status 400 (Bad Request) if the pointsContactDTO is not valid,
     * or with status 500 (Internal Server Error) if the pointsContactDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/points-contacts")
    @Timed
    public ResponseEntity<PointsContactDTO> updatePointsContact(@Valid @RequestBody PointsContactDTO pointsContactDTO) throws URISyntaxException {
        log.debug("REST request to update PointsContact : {}", pointsContactDTO);
        if (pointsContactDTO.getId() == null) {
            return createPointsContact(pointsContactDTO);
        }
        PointsContactDTO result = pointsContactService.save(pointsContactDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, pointsContactDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /points-contacts : get all the pointsContacts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of pointsContacts in body
     */
    @GetMapping("/points-contacts")
    @Timed
    public List<PointsContactDTO> getAllPointsContacts() {
        log.debug("REST request to get all PointsContacts");
        return pointsContactService.findAll();
        }

    /**
     * GET  /points-contacts/:id : get the "id" pointsContact.
     *
     * @param id the id of the pointsContactDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pointsContactDTO, or with status 404 (Not Found)
     */
    @GetMapping("/points-contacts/{id}")
    @Timed
    public ResponseEntity<PointsContactDTO> getPointsContact(@PathVariable Long id) {
        log.debug("REST request to get PointsContact : {}", id);
        PointsContactDTO pointsContactDTO = pointsContactService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(pointsContactDTO));
    }

    /**
     * DELETE  /points-contacts/:id : delete the "id" pointsContact.
     *
     * @param id the id of the pointsContactDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/points-contacts/{id}")
    @Timed
    public ResponseEntity<Void> deletePointsContact(@PathVariable Long id) {
        log.debug("REST request to delete PointsContact : {}", id);
        pointsContactService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/points-contacts?query=:query : search for the pointsContact corresponding
     * to the query.
     *
     * @param query the query of the pointsContact search
     * @return the result of the search
     */
    @GetMapping("/_search/points-contacts")
    @Timed
    public List<PointsContactDTO> searchPointsContacts(@RequestParam String query) {
        log.debug("REST request to search PointsContacts for query {}", query);
        return pointsContactService.search(query);
    }

}
