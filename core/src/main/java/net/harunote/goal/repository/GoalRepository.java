package net.harunote.goal.repository;

import net.harunote.goal.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CodeVillains
 */
@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
}
