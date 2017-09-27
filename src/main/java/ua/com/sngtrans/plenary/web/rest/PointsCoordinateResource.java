package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.PointsCoordinateService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.PointsCoordinateDTO;
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
 * REST controller for managing PointsCoordinate.
 */
@RestController
@RequestMapping("/api")
public class PointsCoordinateResource {

    private final Logger log = LoggerFactory.getLogger(PointsCoordinateResource.class);

    private static final String ENTITY_NAME = "pointsCoordinate";

    private final PointsCoordinateService pointsCoordinateService;

    public PointsCoordinateResource(PointsCoordinateService pointsCoordinateService) {
        this.pointsCoordinateService = pointsCoordinateService;
    }

    /**
     * POST  /points-coordinates : Create a new pointsCoordinate.
     *
     * @param pointsCoordinateDTO the pointsCoordinateDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pointsCoordinateDTO, or with status 400 (Bad Request) if the pointsCoordinate has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/points-coordinates")
    @Timed
    public ResponseEntity<PointsCoordinateDTO> createPointsCoordinate(@Valid @RequestBody PointsCoordinateDTO pointsCoordinateDTO) throws URISyntaxException {
        log.debug("REST request to save PointsCoordinate : {}", pointsCoordinateDTO);
        if (pointsCoordinateDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new pointsCoordinate cannot already have an ID")).body(null);
        }
        PointsCoordinateDTO result = pointsCoordinateService.save(pointsCoordinateDTO);
        return ResponseEntity.created(new URI("/api/points-coordinates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /points-coordinates : Updates an existing pointsCoordinate.
     *
     * @param pointsCoordinateDTO the pointsCoordinateDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pointsCoordinateDTO,
     * or with status 400 (Bad Request) if the pointsCoordinateDTO is not valid,
     * or with status 500 (Internal Server Error) if the pointsCoordinateDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/points-coordinates")
    @Timed
    public ResponseEntity<PointsCoordinateDTO> updatePointsCoordinate(@Valid @RequestBody PointsCoordinateDTO pointsCoordinateDTO) throws URISyntaxException {
        log.debug("REST request to update PointsCoordinate : {}", pointsCoordinateDTO);
        if (pointsCoordinateDTO.getId() == null) {
            return createPointsCoordinate(pointsCoordinateDTO);
        }
        PointsCoordinateDTO result = pointsCoordinateService.save(pointsCoordinateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, pointsCoordinateDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /points-coordinates : get all the pointsCoordinates.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of pointsCoordinates in body
     */
    @GetMapping("/points-coordinates")
    @Timed
    public List<PointsCoordinateDTO> getAllPointsCoordinates() {
        log.debug("REST request to get all PointsCoordinates");
        return pointsCoordinateService.findAll();
        }

    /**
     * GET  /points-coordinates/:id : get the "id" pointsCoordinate.
     *
     * @param id the id of the pointsCoordinateDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pointsCoordinateDTO, or with status 404 (Not Found)
     */
    @GetMapping("/points-coordinates/{id}")
    @Timed
    public ResponseEntity<PointsCoordinateDTO> getPointsCoordinate(@PathVariable Long id) {
        log.debug("REST request to get PointsCoordinate : {}", id);
        PointsCoordinateDTO pointsCoordinateDTO = pointsCoordinateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(pointsCoordinateDTO));
    }

    /**
     * DELETE  /points-coordinates/:id : delete the "id" pointsCoordinate.
     *
     * @param id the id of the pointsCoordinateDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/points-coordinates/{id}")
    @Timed
    public ResponseEntity<Void> deletePointsCoordinate(@PathVariable Long id) {
        log.debug("REST request to delete PointsCoordinate : {}", id);
        pointsCoordinateService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/points-coordinates?query=:query : search for the pointsCoordinate corresponding
     * to the query.
     *
     * @param query the query of the pointsCoordinate search
     * @return the result of the search
     */
    @GetMapping("/_search/points-coordinates")
    @Timed
    public List<PointsCoordinateDTO> searchPointsCoordinates(@RequestParam String query) {
        log.debug("REST request to search PointsCoordinates for query {}", query);
        return pointsCoordinateService.search(query);
    }

}
