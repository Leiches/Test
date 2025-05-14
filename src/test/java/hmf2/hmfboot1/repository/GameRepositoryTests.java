package hmf2.hmfboot1.repository;

import hmf2.hmfboot1.domain.Game;
import hmf2.hmfboot1.domain.Location;
import hmf2.hmfboot1.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GameRepositoryTests {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void testCreateAndFindGame() {
        Team home = teamRepository.save(new Team("Home Team"));
        Team away = teamRepository.save(new Team("Away Team"));
        Location loc = locationRepository.save(new Location("Main Stadium"));

        LocalDateTime dt = LocalDateTime.now();
        Game game = new Game(dt, loc, home, away, "2-1");
        game = gameRepository.save(game);
        assertNotNull(game.getId());

        Optional<Game> found = gameRepository.findById(game.getId());
        assertTrue(found.isPresent());
        assertEquals(dt, found.get().getDateTime());
        assertEquals("2-1", found.get().getResult());
    }
}