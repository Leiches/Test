package hmf2.hmfboot1.repository;

import hmf2.hmfboot1.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}