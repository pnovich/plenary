package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Settlement;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Settlement entity.
 */
public interface SettlementSearchRepository extends ElasticsearchRepository<Settlement, Long> {
}
