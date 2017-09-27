package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.TaskDetails;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TaskDetails entity.
 */
public interface TaskDetailsSearchRepository extends ElasticsearchRepository<TaskDetails, Long> {
}
