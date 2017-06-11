package de.tum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AudioRecordEntity implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4470057920622502089L;
	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	@Lob
	private Byte[] file;
	
	
	@ManyToOne(optional = false)
	@NotNull
	private PatientEntity patiententity;

	public PatientEntity getPatientEntity() {
		return patiententity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patiententity = patientEntity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public AudioRecordEntity(Byte[] file, PatientEntity patiententity) {
		super();
		this.file = file;
		this.patiententity = patiententity;
	}

	
}
