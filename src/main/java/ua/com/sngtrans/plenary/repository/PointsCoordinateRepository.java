package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.PointsCoordinate;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the PointsCoordinate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsCoordinateRepository extends JpaRepository<PointsCoordinate, Long> {

}
