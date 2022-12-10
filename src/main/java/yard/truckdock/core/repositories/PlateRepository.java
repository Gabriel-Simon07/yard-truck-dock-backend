package yard.truckdock.core.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yard.truckdock.core.entities.Plate;

import java.util.Optional;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {
    Optional<Plate> findById(Long id);
}
