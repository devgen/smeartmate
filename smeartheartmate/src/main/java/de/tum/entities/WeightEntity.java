package de.tum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class WeightEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2793829218770391528L;


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
	private Double weight;
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	
	

}
