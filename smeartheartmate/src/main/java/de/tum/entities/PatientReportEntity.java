package de.tum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PatientReportEntity implements Serializable {

	private static final long serialVersionUID = 5613415434108818087L;
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
	private boolean visitPlaned;
	
	@Column
	private String qDiagnosticTreat;
	@Column
	private String generalInput;
	@Column
	private String famMedHistory;
	
	@Column
	private boolean newAllLastVis;
	
	@Column
	private boolean effectInfection;
	
	@Column
	private boolean headache;
	@Column
	private boolean dizziness;
	@Column
	private boolean heartPain;
	@Column
	private boolean agonalRespiration;
	
	@Column
	private boolean experienceConstipation;
	
	@Column
	private boolean bloodInStool;
	
	@Column
	private boolean bloodInAbdomenPain;
	@Column
	private boolean experienceJaundice;
	
	@Column
	private boolean changesUrinaryFrequency;
	
	@Column
	private boolean experienceLimping;
	
	@Column
	private boolean movRestriction;
	@Column
	private boolean jointInflammation;
	
	@Column
	private boolean jointPain;
	
	@Column
	private boolean expRedness;
	
	@Column
	private boolean expIrritation;
	@Column
	private String syncpTdescription;
	@Column
	private String symptomDuration;
	@Column
	private int symptomSeverity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isVisitPlaned() {
		return visitPlaned;
	}
	public void setVisitPlaned(boolean visitPlaned) {
		this.visitPlaned = visitPlaned;
	}
	public String getqDiagnosticTreat() {
		return qDiagnosticTreat;
	}
	public void setqDiagnosticTreat(String qDiagnosticTreat) {
		this.qDiagnosticTreat = qDiagnosticTreat;
	}
	public String getGeneralInput() {
		return generalInput;
	}
	public void setGeneralInput(String generalInput) {
		this.generalInput = generalInput;
	}
	public String getFamMedHistory() {
		return famMedHistory;
	}
	public void setFamMedHistory(String famMedHistory) {
		this.famMedHistory = famMedHistory;
	}
	public boolean isNewAllLastVis() {
		return newAllLastVis;
	}
	public void setNewAllLastVis(boolean newAllLastVis) {
		this.newAllLastVis = newAllLastVis;
	}
	public boolean isEffectInfection() {
		return effectInfection;
	}
	public void setEffectInfection(boolean effectInfection) {
		this.effectInfection = effectInfection;
	}
	public boolean isHeadache() {
		return headache;
	}
	public void setHeadache(boolean headache) {
		this.headache = headache;
	}
	public boolean isDizziness() {
		return dizziness;
	}
	public void setDizziness(boolean dizziness) {
		this.dizziness = dizziness;
	}
	public boolean isHeartPain() {
		return heartPain;
	}
	public void setHeartPain(boolean heartPain) {
		this.heartPain = heartPain;
	}
	public boolean isAgonalRespiration() {
		return agonalRespiration;
	}
	public void setAgonalRespiration(boolean agonalRespiration) {
		this.agonalRespiration = agonalRespiration;
	}
	public boolean isExperienceConstipation() {
		return experienceConstipation;
	}
	public void setExperienceConstipation(boolean experienceConstipation) {
		this.experienceConstipation = experienceConstipation;
	}
	public boolean isBloodInStool() {
		return bloodInStool;
	}
	public void setBloodInStool(boolean bloodInStool) {
		this.bloodInStool = bloodInStool;
	}
	public boolean isBloodInAbdomenPain() {
		return bloodInAbdomenPain;
	}
	public void setBloodInAbdomenPain(boolean bloodInAbdomenPain) {
		this.bloodInAbdomenPain = bloodInAbdomenPain;
	}
	public boolean isExperienceJaundice() {
		return experienceJaundice;
	}
	public void setExperienceJaundice(boolean experienceJaundice) {
		this.experienceJaundice = experienceJaundice;
	}
	public boolean isChangesUrinaryFrequency() {
		return changesUrinaryFrequency;
	}
	public void setChangesUrinaryFrequency(boolean changesUrinaryFrequency) {
		this.changesUrinaryFrequency = changesUrinaryFrequency;
	}
	public boolean isExperienceLimping() {
		return experienceLimping;
	}
	public void setExperienceLimping(boolean experienceLimping) {
		this.experienceLimping = experienceLimping;
	}
	public boolean isMovRestriction() {
		return movRestriction;
	}
	public void setMovRestriction(boolean movRestriction) {
		this.movRestriction = movRestriction;
	}
	public boolean isJointInflammation() {
		return jointInflammation;
	}
	public void setJointInflammation(boolean jointInflammation) {
		this.jointInflammation = jointInflammation;
	}
	public boolean isJointPain() {
		return jointPain;
	}
	public void setJointPain(boolean jointPain) {
		this.jointPain = jointPain;
	}
	public boolean isExpRedness() {
		return expRedness;
	}
	public void setExpRedness(boolean expRedness) {
		this.expRedness = expRedness;
	}
	public boolean isExpIrritation() {
		return expIrritation;
	}
	public void setExpIrritation(boolean expIrritation) {
		this.expIrritation = expIrritation;
	}
	public String getSyncpTdescription() {
		return syncpTdescription;
	}
	public void setSyncpTdescription(String syncpTdescription) {
		this.syncpTdescription = syncpTdescription;
	}
	public String getSymptomDuration() {
		return symptomDuration;
	}
	public void setSymptomDuration(String symptomDuration) {
		this.symptomDuration = symptomDuration;
	}
	public int getSymptomSeverity() {
		return symptomSeverity;
	}
	public void setSymptomSeverity(int symptomSeverity) {
		this.symptomSeverity = symptomSeverity;
	}
	
	
	
	
	
}
