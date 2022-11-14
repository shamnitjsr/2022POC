package in.shambhu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shambhu.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
