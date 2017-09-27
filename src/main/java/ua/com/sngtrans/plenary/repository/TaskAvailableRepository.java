package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.TaskAvailable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TaskAvailable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskAvailableRepository extends JpaRepository<TaskAvailable, Long> {

}
