package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.WarehouseAvailable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the WarehouseAvailable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WarehouseAvailableRepository extends JpaRepository<WarehouseAvailable, Long> {

}
