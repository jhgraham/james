package kalah.persistence;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for storing Game contexts
 * @author James
 *
 */
public interface GameRepository extends CrudRepository<GameContext, Long>
{    
    Optional<GameContext> findById(Long gameId);
}

