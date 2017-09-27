package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.PointsCoordinate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the PointsCoordinate entity.
 */
public interface PointsCoordinateSearchRepository extends ElasticsearchRepository<PointsCoordinate, Long> {
}
