package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Transport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Transport entity.
 */
public interface TransportSearchRepository extends ElasticsearchRepository<Transport, Long> {
}
