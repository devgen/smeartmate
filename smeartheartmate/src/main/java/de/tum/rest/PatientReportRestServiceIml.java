package de.tum.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import de.tum.dao.local.PatientEntityDaoLocal;
import de.tum.dao.local.ReportEntityDaoLocal;
import de.tum.entities.PatientEntity;
import de.tum.rest.messages.ReportRestMsg;

@Stateless
@Path("/patient/{patientid}/offers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientReportRestServiceIml {
	
	
	private Logger log = Logger.getLogger(this.getClass());

	@EJB
	private PatientEntityDaoLocal pm;
	@EJB
	private ReportEntityDaoLocal rm;
	
	
	@GET
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientReport(@PathParam("patientid") String patientid){
		
		return Response.status(Status.CREATED).entity("hi").build();
	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPatinetReport(@PathParam("patientid") String patientid, ReportRestMsg reportRestMsg){
		
		log.error("got request");
		PatientEntity patientEntity = pm.getPatienById(patientid);
		rm.createReportForPatient(
				 patientEntity,
				 reportRestMsg.isVisitPlaned(),
				 reportRestMsg.getqDiagnosticTreat(), 
				 reportRestMsg.getGeneralInput(),
				 reportRestMsg.getFamMedHistory(), 
				 reportRestMsg.isNewAllLastVis(), 
				 reportRestMsg.isEffectInfection(), 
				 reportRestMsg.isHeadache(), 
				 reportRestMsg.isDizziness(), 
				 reportRestMsg.isHeartPain(), 
				 reportRestMsg.isAgonalRespiration(), 
				 reportRestMsg.isExperienceConstipation(), 
				 reportRestMsg.isBloodInStool(), 
				 reportRestMsg.isBloodInAbdomenPain(), 
				 reportRestMsg.isExperienceJaundice(), 
				 reportRestMsg.isChangesUrinaryFrequency(), 
				 reportRestMsg.isExperienceLimping(), 
				 reportRestMsg.isMovRestriction(), 
				 reportRestMsg.isJointInflammation(), 
				 reportRestMsg.isJointPain(), 
				 reportRestMsg.isExpRedness(), 
				 reportRestMsg.isExpIrritation(), 
				 reportRestMsg.getSyncpTdescription(), 
				 reportRestMsg.getSymptomDuration(), 
				 reportRestMsg.getSymptomSeverity()
				
				);
		
		
		return Response.status(Status.CREATED).entity("OK").build();
		
	}
	
	

}
