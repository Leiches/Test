package hmf2.hmfboot1.service;

import hmf2.hmfboot1.domain.Team;
import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team createTeam(Team team);
    Optional<Team> getTeamById(Long id);
    List<Team> getAllTeams();
    Team updateTeam(Long id, Team team);
    void deleteTeam(Long id);
}