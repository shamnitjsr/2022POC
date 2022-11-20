package in.shambhu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shambhu.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>{

}
