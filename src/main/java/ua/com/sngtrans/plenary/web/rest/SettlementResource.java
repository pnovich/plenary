package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.SettlementService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.web.rest.util.PaginationUtil;
import ua.com.sngtrans.plenary.service.dto.SettlementDTO;
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
 * REST controller for managing Settlement.
 */
@RestController
@RequestMapping("/api")
public class SettlementResource {

    private final Logger log = LoggerFactory.getLogger(SettlementResource.class);

    private static final String ENTITY_NAME = "settlement";

    private final SettlementService settlementService;

    public SettlementResource(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    /**
     * POST  /settlements : Create a new settlement.
     *
     * @param settlementDTO the settlementDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new settlementDTO, or with status 400 (Bad Request) if the settlement has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/settlements")
    @Timed
    public ResponseEntity<SettlementDTO> createSettlement(@Valid @RequestBody SettlementDTO settlementDTO) throws URISyntaxException {
        log.debug("REST request to save Settlement : {}", settlementDTO);
        if (settlementDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new settlement cannot already have an ID")).body(null);
        }
        SettlementDTO result = settlementService.save(settlementDTO);
        return ResponseEntity.created(new URI("/api/settlements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /settlements : Updates an existing settlement.
     *
     * @param settlementDTO the settlementDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated settlementDTO,
     * or with status 400 (Bad Request) if the settlementDTO is not valid,
     * or with status 500 (Internal Server Error) if the settlementDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/settlements")
    @Timed
    public ResponseEntity<SettlementDTO> updateSettlement(@Valid @RequestBody SettlementDTO settlementDTO) throws URISyntaxException {
        log.debug("REST request to update Settlement : {}", settlementDTO);
        if (settlementDTO.getId() == null) {
            return createSettlement(settlementDTO);
        }
        SettlementDTO result = settlementService.save(settlementDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, settlementDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /settlements : get all the settlements.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of settlements in body
     */
    @GetMapping("/settlements")
    @Timed
    public ResponseEntity<List<SettlementDTO>> getAllSettlements(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Settlements");
        Page<SettlementDTO> page = settlementService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/settlements");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /settlements/:id : get the "id" settlement.
     *
     * @param id the id of the settlementDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the settlementDTO, or with status 404 (Not Found)
     */
    @GetMapping("/settlements/{id}")
    @Timed
    public ResponseEntity<SettlementDTO> getSettlement(@PathVariable Long id) {
        log.debug("REST request to get Settlement : {}", id);
        SettlementDTO settlementDTO = settlementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(settlementDTO));
    }

    /**
     * DELETE  /settlements/:id : delete the "id" settlement.
     *
     * @param id the id of the settlementDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/settlements/{id}")
    @Timed
    public ResponseEntity<Void> deleteSettlement(@PathVariable Long id) {
        log.debug("REST request to delete Settlement : {}", id);
        settlementService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/settlements?query=:query : search for the settlement corresponding
     * to the query.
     *
     * @param query the query of the settlement search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/settlements")
    @Timed
    public ResponseEntity<List<SettlementDTO>> searchSettlements(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Settlements for query {}", query);
        Page<SettlementDTO> page = settlementService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/settlements");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
