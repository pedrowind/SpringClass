package paradigmas.theboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import paradigmas.theboys.entities.Missoes;

public interface MissoesRepository extends JpaRepository<Missoes, Long> {
}
