package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.TaskAvailable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TaskAvailable entity.
 */
public interface TaskAvailableSearchRepository extends ElasticsearchRepository<TaskAvailable, Long> {
}
