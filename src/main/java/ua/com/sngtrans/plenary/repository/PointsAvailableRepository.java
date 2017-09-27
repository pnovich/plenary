package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.PointsAvailable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the PointsAvailable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsAvailableRepository extends JpaRepository<PointsAvailable, Long> {

}
