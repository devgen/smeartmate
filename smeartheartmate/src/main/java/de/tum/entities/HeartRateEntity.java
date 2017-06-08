package de.tum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class HeartRateEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6851102312427989812L;

	
	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	@Column
	private Date dateTime;
	@Column
	private int heartRate;
	@Column
	private boolean activity;
	@Column
	private boolean sleep;
	
	
	@ManyToOne(optional = false)
	@NotNull
	private PatientEntity patiententity;
	public PatientEntity getPatientEntity() {
		return patiententity;
	}
	public void setPatientEntity(PatientEntity patiententity) {
		this.patiententity = patiententity;
	}
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
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	public boolean isSleep() {
		return sleep;
	}
	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}
	
	
	
	
	

}
