package ua.com.sngtrans.plenary.repository;

import ua.com.sngtrans.plenary.domain.Settlement;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Settlement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

}
