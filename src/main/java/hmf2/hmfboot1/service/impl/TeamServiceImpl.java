package hmf2.hmfboot1.service.impl;

import hmf2.hmfboot1.domain.Team;
import hmf2.hmfboot1.repository.TeamRepository;
import hmf2.hmfboot1.service.TeamService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Long id, Team updated) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(updated.getName());
                    return teamRepository.save(team);
                })
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}