package kalah.persistence;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameContext, Long>
{    
    Optional<GameContext> findById(Long gameId);
}

