package de.tum.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.tum.dao.local.PatientEntityDaoLocal;
import de.tum.dao.local.ReportEntityDaoLocal;
import de.tum.entities.PatientEntity;
import de.tum.entities.PatientReportEntity;


@Stateless
@Local({ ReportEntityDaoLocal.class })
public class ReportEntityDao implements ReportEntityDaoLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public PatientReportEntity createReportForPatient( PatientEntity patiententity,
			boolean visitPlaned, String qDiagnosticTreat, String generalInput, String famMedHistory,
			boolean newAllLastVis, boolean effectInfection, boolean headache, boolean dizziness, boolean heartPain,
			boolean agonalRespiration, boolean experienceConstipation, boolean bloodInStool, boolean bloodInAbdomenPain,
			boolean experienceJaundice, boolean changesUrinaryFrequency, boolean experienceLimping,
			boolean movRestriction, boolean jointInflammation, boolean jointPain, boolean expRedness,
			boolean expIrritation, String syncpTdescription, String symptomDuration, int symptomSeverity) {
		// TODO Auto-generated method stub
		
		
		PatientReportEntity patientReportEntity = new PatientReportEntity(
				patiententity, 
				visitPlaned, 
				qDiagnosticTreat, 
				generalInput, 
				famMedHistory, 
				newAllLastVis, 
				effectInfection, 
				headache, 
				dizziness, 
				heartPain, 
				agonalRespiration, 
				experienceConstipation, 
				bloodInStool, 
				bloodInAbdomenPain, 
				experienceJaundice, 
				changesUrinaryFrequency, 
				experienceLimping, 
				movRestriction, 
				jointInflammation, 
				jointPain, 
				expRedness, 
				expIrritation, 
				syncpTdescription, 
				symptomDuration, 
				symptomSeverity
				);
		
		
		em.persist(patientReportEntity);
		em.flush();
		
		
		return patientReportEntity;
	}

	
		
	
	
	
	

}
