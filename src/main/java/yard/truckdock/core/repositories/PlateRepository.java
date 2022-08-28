package yard.truckdock.core.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yard.truckdock.core.entities.Plate;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long>{

}
