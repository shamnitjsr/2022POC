package in.shambhu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shambhu.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
