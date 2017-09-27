package ua.com.sngtrans.plenary.repository.search;

import ua.com.sngtrans.plenary.domain.Branch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Branch entity.
 */
public interface BranchSearchRepository extends ElasticsearchRepository<Branch, Long> {
}
