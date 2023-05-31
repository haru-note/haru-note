package net.harunote.goal;

import lombok.extern.slf4j.Slf4j;
import net.harunote.goal.entity.Goal;
import net.harunote.goal.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author CodeVillains
 */
@Slf4j
@Service
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }


    public Optional<Goal> findById(Long id) {
        return goalRepository.findById(id);
    }
}
