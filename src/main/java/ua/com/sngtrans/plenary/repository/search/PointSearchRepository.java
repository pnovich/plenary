package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Point;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Point entity.
 */
public interface PointSearchRepository extends ElasticsearchRepository<Point, Long> {
}
