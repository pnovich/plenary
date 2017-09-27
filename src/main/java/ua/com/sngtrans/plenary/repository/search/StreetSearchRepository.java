package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Street;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Street entity.
 */
public interface StreetSearchRepository extends ElasticsearchRepository<Street, Long> {
}
