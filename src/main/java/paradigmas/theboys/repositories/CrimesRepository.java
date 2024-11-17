package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paradigmas.theboys.entities.Crimes;


public interface CrimesRepository extends JpaRepository<Crimes, Long> {

}
