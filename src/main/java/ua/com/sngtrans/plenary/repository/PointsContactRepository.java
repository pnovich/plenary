package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.PointsContact;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the PointsContact entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PointsContactRepository extends JpaRepository<PointsContact, Long> {

}
