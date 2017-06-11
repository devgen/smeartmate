package de.tum.dao.local;



import de.tum.entities.PatientEntity;
import de.tum.entities.PatientReportEntity;

public interface ReportEntityDaoLocal {
	
	

	
	public PatientReportEntity createReportForPatient(
			PatientEntity patiententity, 
			boolean visitPlaned, 
			String qDiagnosticTreat, 
			String generalInput, 
			String famMedHistory, 
			boolean newAllLastVis, 
			boolean effectInfection, 
			boolean headache, 
			boolean dizziness, 
			boolean heartPain, 
			boolean agonalRespiration, 
			boolean experienceConstipation, 
			boolean bloodInStool, 
			boolean bloodInAbdomenPain, 
			boolean experienceJaundice, 
			boolean changesUrinaryFrequency, 
			boolean experienceLimping, 
			boolean movRestriction, 
			boolean jointInflammation, 
			boolean jointPain, 
			boolean expRedness, 
			boolean expIrritation, 
			String syncpTdescription, 
			String symptomDuration, 
			int symptomSeverity
			
			
			);

}
