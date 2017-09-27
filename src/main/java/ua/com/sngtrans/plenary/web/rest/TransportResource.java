package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.TransportService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.web.rest.util.PaginationUtil;
import ua.com.sngtrans.plenary.service.dto.TransportDTO;
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
 * REST controller for managing Transport.
 */
@RestController
@RequestMapping("/api")
public class TransportResource {

    private final Logger log = LoggerFactory.getLogger(TransportResource.class);

    private static final String ENTITY_NAME = "transport";

    private final TransportService transportService;

    public TransportResource(TransportService transportService) {
        this.transportService = transportService;
    }

    /**
     * POST  /transports : Create a new transport.
     *
     * @param transportDTO the transportDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new transportDTO, or with status 400 (Bad Request) if the transport has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/transports")
    @Timed
    public ResponseEntity<TransportDTO> createTransport(@Valid @RequestBody TransportDTO transportDTO) throws URISyntaxException {
        log.debug("REST request to save Transport : {}", transportDTO);
        if (transportDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new transport cannot already have an ID")).body(null);
        }
        TransportDTO result = transportService.save(transportDTO);
        return ResponseEntity.created(new URI("/api/transports/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /transports : Updates an existing transport.
     *
     * @param transportDTO the transportDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated transportDTO,
     * or with status 400 (Bad Request) if the transportDTO is not valid,
     * or with status 500 (Internal Server Error) if the transportDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/transports")
    @Timed
    public ResponseEntity<TransportDTO> updateTransport(@Valid @RequestBody TransportDTO transportDTO) throws URISyntaxException {
        log.debug("REST request to update Transport : {}", transportDTO);
        if (transportDTO.getId() == null) {
            return createTransport(transportDTO);
        }
        TransportDTO result = transportService.save(transportDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, transportDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /transports : get all the transports.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of transports in body
     */
    @GetMapping("/transports")
    @Timed
    public ResponseEntity<List<TransportDTO>> getAllTransports(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Transports");
        Page<TransportDTO> page = transportService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/transports");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /transports/:id : get the "id" transport.
     *
     * @param id the id of the transportDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the transportDTO, or with status 404 (Not Found)
     */
    @GetMapping("/transports/{id}")
    @Timed
    public ResponseEntity<TransportDTO> getTransport(@PathVariable Long id) {
        log.debug("REST request to get Transport : {}", id);
        TransportDTO transportDTO = transportService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(transportDTO));
    }

    /**
     * DELETE  /transports/:id : delete the "id" transport.
     *
     * @param id the id of the transportDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/transports/{id}")
    @Timed
    public ResponseEntity<Void> deleteTransport(@PathVariable Long id) {
        log.debug("REST request to delete Transport : {}", id);
        transportService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/transports?query=:query : search for the transport corresponding
     * to the query.
     *
     * @param query the query of the transport search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/transports")
    @Timed
    public ResponseEntity<List<TransportDTO>> searchTransports(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Transports for query {}", query);
        Page<TransportDTO> page = transportService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/transports");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
