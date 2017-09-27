package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Sensor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Sensor entity.
 */
public interface SensorSearchRepository extends ElasticsearchRepository<Sensor, Long> {
}
