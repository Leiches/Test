package hmf2.hmfboot1.service;

import hmf2.hmfboot1.domain.Game;
import hmf2.hmfboot1.dto.GameDTO;
import java.util.List;
import java.util.Optional;

public interface GameService {
    Game createGame(GameDTO gameDTO);
    Optional<Game> getGameById(Long id);
    List<Game> getAllGames();
    Game updateGame(Long id, GameDTO gameDTO);
    void deleteGame(Long id);
}