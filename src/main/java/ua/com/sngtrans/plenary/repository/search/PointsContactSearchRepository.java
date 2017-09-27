package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.PointsContact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the PointsContact entity.
 */
public interface PointsContactSearchRepository extends ElasticsearchRepository<PointsContact, Long> {
}
