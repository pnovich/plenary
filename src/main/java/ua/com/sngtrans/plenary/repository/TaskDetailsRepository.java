package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.TaskDetails;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TaskDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskDetailsRepository extends JpaRepository<TaskDetails, Long> {

}
