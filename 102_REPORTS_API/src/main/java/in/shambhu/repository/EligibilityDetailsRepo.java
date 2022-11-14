package in.shambhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.shambhu.entity.EligibilityDetails;

public interface EligibilityDetailsRepo extends JpaRepository<EligibilityDetails, Integer> {
	
	@Query("select distinct(planName) from EligibilityDetails")
	public List<String> findByNames();
	
	@Query("select distinct(planStatus) from EligibilityDetails")
	public List<String> findByPlanStatuses();

}
