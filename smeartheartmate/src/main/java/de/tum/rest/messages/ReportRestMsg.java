package de.tum.rest.messages;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reportrestmsg")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportRestMsg {
	
	
	@XmlAttribute
	private boolean visitPlaned;
	
	@XmlAttribute
	private String qDiagnosticTreat;
	@XmlAttribute
	private String generalInput;
	@XmlAttribute
	private String famMedHistory;
	
	@XmlAttribute
	private boolean newAllLastVis;
	
	@XmlAttribute
	private boolean effectInfection;
	
	@XmlAttribute
	private boolean headache;
	@XmlAttribute
	private boolean dizziness;
	@XmlAttribute
	private boolean heartPain;
	@XmlAttribute
	private boolean agonalRespiration;
	
	@XmlAttribute
	private boolean experienceConstipation;
	
	@XmlAttribute
	private boolean bloodInStool;
	
	@XmlAttribute
	private boolean bloodInAbdomenPain;
	@XmlAttribute
	private boolean experienceJaundice;
	
	@XmlAttribute
	private boolean changesUrinaryFrequency;
	
	@XmlAttribute
	private boolean experienceLimping;
	
	@XmlAttribute
	private boolean movRestriction;
	@XmlAttribute
	private boolean jointInflammation;
	
	@XmlAttribute
	private boolean jointPain;
	
	@XmlAttribute
	private boolean expRedness;
	
	@XmlAttribute
	private boolean expIrritation;
	@XmlAttribute
	private String syncpTdescription;
	@XmlAttribute
	private String symptomDuration;
	@XmlAttribute
	private int symptomSeverity;
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
	
	
	
	public ReportRestMsg() {
		super();
	}
	@Override
	public String toString() {
		return "ReportRestMsg [visitPlaned=" + visitPlaned + ", qDiagnosticTreat=" + qDiagnosticTreat
				+ ", generalInput=" + generalInput + ", famMedHistory=" + famMedHistory + ", newAllLastVis="
				+ newAllLastVis + ", effectInfection=" + effectInfection + ", headache=" + headache + ", dizziness="
				+ dizziness + ", heartPain=" + heartPain + ", agonalRespiration=" + agonalRespiration
				+ ", experienceConstipation=" + experienceConstipation + ", bloodInStool=" + bloodInStool
				+ ", bloodInAbdomenPain=" + bloodInAbdomenPain + ", experienceJaundice=" + experienceJaundice
				+ ", changesUrinaryFrequency=" + changesUrinaryFrequency + ", experienceLimping=" + experienceLimping
				+ ", movRestriction=" + movRestriction + ", jointInflammation=" + jointInflammation + ", jointPain="
				+ jointPain + ", expRedness=" + expRedness + ", expIrritation=" + expIrritation + ", syncpTdescription="
				+ syncpTdescription + ", symptomDuration=" + symptomDuration + ", symptomSeverity=" + symptomSeverity
				+ "]";
	}
	
	
	
	
	

}
