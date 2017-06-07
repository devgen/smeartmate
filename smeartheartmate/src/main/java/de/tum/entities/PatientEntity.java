package de.tum.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PatientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5613415434108818087L;
	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	@Column
	private String firstName;
	
	@Column
	private String LastName;
	
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AudioRecordEntity> audioRecordEntities;
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HeartRateEntity> heartRateEntities;
	
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NutritionEntity> nutritionEntities;
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StepsEntity> stepsEntities;
	
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WeightEntity> weightEntities;
	
	@OneToMany(mappedBy = "patiententity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PatientReportEntity> patientReportEntities;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public List<AudioRecordEntity> getAudioRecordEntities() {
		return audioRecordEntities;
	}


	public void setAudioRecordEntities(List<AudioRecordEntity> audioRecordEntities) {
		this.audioRecordEntities = audioRecordEntities;
	}


	public List<HeartRateEntity> getHeartRateEntities() {
		return heartRateEntities;
	}


	public void setHeartRateEntities(List<HeartRateEntity> heartRateEntities) {
		this.heartRateEntities = heartRateEntities;
	}


	public List<NutritionEntity> getNutritionEntities() {
		return nutritionEntities;
	}


	public void setNutritionEntities(List<NutritionEntity> nutritionEntities) {
		this.nutritionEntities = nutritionEntities;
	}


	public List<StepsEntity> getStepsEntities() {
		return stepsEntities;
	}


	public void setStepsEntities(List<StepsEntity> stepsEntities) {
		this.stepsEntities = stepsEntities;
	}


	public List<WeightEntity> getWeightEntities() {
		return weightEntities;
	}


	public void setWeightEntities(List<WeightEntity> weightEntities) {
		this.weightEntities = weightEntities;
	}
	
	
	
	
	
	
	
	
}
