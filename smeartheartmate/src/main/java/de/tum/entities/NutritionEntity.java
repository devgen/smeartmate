package de.tum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class NutritionEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8438111230353279799L;



	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	
	
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
	private Date date;
	
	
	@Column
	private int burnt;
	
	
	@Column
	private int gained;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getBurnt() {
		return burnt;
	}


	public void setBurnt(int burnt) {
		this.burnt = burnt;
	}


	public int getGained() {
		return gained;
	}


	public void setGained(int gained) {
		this.gained = gained;
	}
	
	
	
	
}
