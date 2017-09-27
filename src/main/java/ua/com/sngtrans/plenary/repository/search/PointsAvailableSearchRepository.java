package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.PointsAvailable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the PointsAvailable entity.
 */
public interface PointsAvailableSearchRepository extends ElasticsearchRepository<PointsAvailable, Long> {
}
