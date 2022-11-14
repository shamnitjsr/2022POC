package in.shambhu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.shambhu.entity.EligibilityDetails;
import in.shambhu.repository.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibilityDetails entity1 = new EligibilityDetails();

		entity1.setEligId(1);
		entity1.setName("John");
		entity1.setMobile((long) 123459);
		entity1.setGender('M');
		entity1.setSsn((long) 5678978);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");
		repo.save(entity1);

		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("Smith");
		entity2.setMobile((long) 1234229);
		entity2.setGender('M');
		entity2.setSsn((long) 5672278);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);

		EligibilityDetails entity3 = new EligibilityDetails();
		entity3.setEligId(3);
		entity3.setName("Robert");
		entity3.setMobile((long) 1211129);
		entity3.setGender('M');
		entity3.setSsn((long) 5671178);
		entity3.setPlanName("Medicaid");
		entity3.setPlanStatus("Closed");
		repo.save(entity3);

	}

}
