package hmf2.hmfboot1.service.impl;

import hmf2.hmfboot1.domain.Game;
import hmf2.hmfboot1.domain.Location;
import hmf2.hmfboot1.domain.Team;
import hmf2.hmfboot1.dto.GameDTO;
import hmf2.hmfboot1.repository.GameRepository;
import hmf2.hmfboot1.repository.LocationRepository;
import hmf2.hmfboot1.repository.TeamRepository;
import hmf2.hmfboot1.service.GameService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final LocationRepository locationRepository;
    private final TeamRepository teamRepository;

    public GameServiceImpl(GameRepository gameRepository,
                           LocationRepository locationRepository,
                           TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.locationRepository = locationRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Game createGame(GameDTO dto) {
        Location location = locationRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        Team home = teamRepository.findById(dto.getHomeTeamId())
                .orElseThrow(() -> new RuntimeException("Home team not found"));
        Team away = teamRepository.findById(dto.getAwayTeamId())
                .orElseThrow(() -> new RuntimeException("Away team not found"));
        Game game = new Game(dto.getDateTime(), location, home, away, dto.getResult());
        return gameRepository.save(game);
    }

    @Override
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game updateGame(Long id, GameDTO dto) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setDateTime(dto.getDateTime());
                    game.setResult(dto.getResult());
                    game.setLocation(locationRepository.findById(dto.getLocationId())
                            .orElseThrow(() -> new RuntimeException("Location not found")));
                    game.setHomeTeam(teamRepository.findById(dto.getHomeTeamId())
                            .orElseThrow(() -> new RuntimeException("Home team not found")));
                    game.setAwayTeam(teamRepository.findById(dto.getAwayTeamId())
                            .orElseThrow(() -> new RuntimeException("Away team not found")));
                    return gameRepository.save(game);
                })
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}