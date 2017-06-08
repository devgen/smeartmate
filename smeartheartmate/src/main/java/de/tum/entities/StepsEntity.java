package de.tum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class StepsEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3464463556738378491L;


	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	
	@Column
	private Date dateTime;
	
	
	@ManyToOne(optional = false)
	@NotNull
	private PatientEntity patiententity;
	
	public PatientEntity getPatientEntity() {
		return patiententity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patiententity = patientEntity;
	}

	@Column
	private int stepts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getStepts() {
		return stepts;
	}

	public void setStepts(int stepts) {
		this.stepts = stepts;
	}
	
	
	

}
