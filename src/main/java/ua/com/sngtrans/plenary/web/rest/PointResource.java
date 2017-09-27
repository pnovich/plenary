package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.PointService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.web.rest.util.PaginationUtil;
import ua.com.sngtrans.plenary.service.dto.PointDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
 * REST controller for managing Point.
 */
@RestController
@RequestMapping("/api")
public class PointResource {

    private final Logger log = LoggerFactory.getLogger(PointResource.class);

    private static final String ENTITY_NAME = "point";

    private final PointService pointService;

    public PointResource(PointService pointService) {
        this.pointService = pointService;
    }

    /**
     * POST  /points : Create a new point.
     *
     * @param pointDTO the pointDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pointDTO, or with status 400 (Bad Request) if the point has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/points")
    @Timed
    public ResponseEntity<PointDTO> createPoint(@Valid @RequestBody PointDTO pointDTO) throws URISyntaxException {
        log.debug("REST request to save Point : {}", pointDTO);
        if (pointDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new point cannot already have an ID")).body(null);
        }
        PointDTO result = pointService.save(pointDTO);
        return ResponseEntity.created(new URI("/api/points/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /points : Updates an existing point.
     *
     * @param pointDTO the pointDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pointDTO,
     * or with status 400 (Bad Request) if the pointDTO is not valid,
     * or with status 500 (Internal Server Error) if the pointDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/points")
    @Timed
    public ResponseEntity<PointDTO> updatePoint(@Valid @RequestBody PointDTO pointDTO) throws URISyntaxException {
        log.debug("REST request to update Point : {}", pointDTO);
        if (pointDTO.getId() == null) {
            return createPoint(pointDTO);
        }
        PointDTO result = pointService.save(pointDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, pointDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /points : get all the points.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of points in body
     */
    @GetMapping("/points")
    @Timed
    public ResponseEntity<List<PointDTO>> getAllPoints(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Points");
        Page<PointDTO> page = pointService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/points");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /points/:id : get the "id" point.
     *
     * @param id the id of the pointDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pointDTO, or with status 404 (Not Found)
     */
    @GetMapping("/points/{id}")
    @Timed
    public ResponseEntity<PointDTO> getPoint(@PathVariable Long id) {
        log.debug("REST request to get Point : {}", id);
        PointDTO pointDTO = pointService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(pointDTO));
    }

    /**
     * DELETE  /points/:id : delete the "id" point.
     *
     * @param id the id of the pointDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/points/{id}")
    @Timed
    public ResponseEntity<Void> deletePoint(@PathVariable Long id) {
        log.debug("REST request to delete Point : {}", id);
        pointService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/points?query=:query : search for the point corresponding
     * to the query.
     *
     * @param query the query of the point search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/points")
    @Timed
    public ResponseEntity<List<PointDTO>> searchPoints(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Points for query {}", query);
        Page<PointDTO> page = pointService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/points");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
