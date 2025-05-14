package hmf2.hmfboot1.repository;

import hmf2.hmfboot1.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TeamRepositoryTests {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void testCreateAndFindTeam() {
        Team team = new Team("Team A");
        team = teamRepository.save(team);
        assertNotNull(team.getId());

        Optional<Team> found = teamRepository.findById(team.getId());
        assertTrue(found.isPresent());
        assertEquals("Team A", found.get().getName());
    }
}