package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.WarehouseAvailable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the WarehouseAvailable entity.
 */
public interface WarehouseAvailableSearchRepository extends ElasticsearchRepository<WarehouseAvailable, Long> {
}
