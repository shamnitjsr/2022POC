package in.shambhu.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "patient_table")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", insertable = false, updatable = false, nullable = false)
	private UUID id;

	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull
	@Column(name = "DATA_OF_BIRTH")
	private LocalDate dateOfBirth;

	@NotNull
	@Column(name = "SSN")
	private String ssn;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
