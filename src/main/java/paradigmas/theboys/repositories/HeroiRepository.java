package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import paradigmas.theboys.entities.Heroi;

public interface HeroiRepository extends JpaRepository<Heroi, Long> {
}
