package ua.com.sngtrans.plenary.web.rest;

import com.codahale.metrics.annotation.Timed;
import ua.com.sngtrans.plenary.service.WarehouseAvailableService;
import ua.com.sngtrans.plenary.web.rest.util.HeaderUtil;
import ua.com.sngtrans.plenary.service.dto.WarehouseAvailableDTO;
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
 * REST controller for managing WarehouseAvailable.
 */
@RestController
@RequestMapping("/api")
public class WarehouseAvailableResource {

    private final Logger log = LoggerFactory.getLogger(WarehouseAvailableResource.class);

    private static final String ENTITY_NAME = "warehouseAvailable";

    private final WarehouseAvailableService warehouseAvailableService;

    public WarehouseAvailableResource(WarehouseAvailableService warehouseAvailableService) {
        this.warehouseAvailableService = warehouseAvailableService;
    }

    /**
     * POST  /warehouse-availables : Create a new warehouseAvailable.
     *
     * @param warehouseAvailableDTO the warehouseAvailableDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new warehouseAvailableDTO, or with status 400 (Bad Request) if the warehouseAvailable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/warehouse-availables")
    @Timed
    public ResponseEntity<WarehouseAvailableDTO> createWarehouseAvailable(@Valid @RequestBody WarehouseAvailableDTO warehouseAvailableDTO) throws URISyntaxException {
        log.debug("REST request to save WarehouseAvailable : {}", warehouseAvailableDTO);
        if (warehouseAvailableDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new warehouseAvailable cannot already have an ID")).body(null);
        }
        WarehouseAvailableDTO result = warehouseAvailableService.save(warehouseAvailableDTO);
        return ResponseEntity.created(new URI("/api/warehouse-availables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /warehouse-availables : Updates an existing warehouseAvailable.
     *
     * @param warehouseAvailableDTO the warehouseAvailableDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated warehouseAvailableDTO,
     * or with status 400 (Bad Request) if the warehouseAvailableDTO is not valid,
     * or with status 500 (Internal Server Error) if the warehouseAvailableDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/warehouse-availables")
    @Timed
    public ResponseEntity<WarehouseAvailableDTO> updateWarehouseAvailable(@Valid @RequestBody WarehouseAvailableDTO warehouseAvailableDTO) throws URISyntaxException {
        log.debug("REST request to update WarehouseAvailable : {}", warehouseAvailableDTO);
        if (warehouseAvailableDTO.getId() == null) {
            return createWarehouseAvailable(warehouseAvailableDTO);
        }
        WarehouseAvailableDTO result = warehouseAvailableService.save(warehouseAvailableDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, warehouseAvailableDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /warehouse-availables : get all the warehouseAvailables.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of warehouseAvailables in body
     */
    @GetMapping("/warehouse-availables")
    @Timed
    public List<WarehouseAvailableDTO> getAllWarehouseAvailables() {
        log.debug("REST request to get all WarehouseAvailables");
        return warehouseAvailableService.findAll();
        }

    /**
     * GET  /warehouse-availables/:id : get the "id" warehouseAvailable.
     *
     * @param id the id of the warehouseAvailableDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the warehouseAvailableDTO, or with status 404 (Not Found)
     */
    @GetMapping("/warehouse-availables/{id}")
    @Timed
    public ResponseEntity<WarehouseAvailableDTO> getWarehouseAvailable(@PathVariable Long id) {
        log.debug("REST request to get WarehouseAvailable : {}", id);
        WarehouseAvailableDTO warehouseAvailableDTO = warehouseAvailableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(warehouseAvailableDTO));
    }

    /**
     * DELETE  /warehouse-availables/:id : delete the "id" warehouseAvailable.
     *
     * @param id the id of the warehouseAvailableDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/warehouse-availables/{id}")
    @Timed
    public ResponseEntity<Void> deleteWarehouseAvailable(@PathVariable Long id) {
        log.debug("REST request to delete WarehouseAvailable : {}", id);
        warehouseAvailableService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/warehouse-availables?query=:query : search for the warehouseAvailable corresponding
     * to the query.
     *
     * @param query the query of the warehouseAvailable search
     * @return the result of the search
     */
    @GetMapping("/_search/warehouse-availables")
    @Timed
    public List<WarehouseAvailableDTO> searchWarehouseAvailables(@RequestParam String query) {
        log.debug("REST request to search WarehouseAvailables for query {}", query);
        return warehouseAvailableService.search(query);
    }

}
