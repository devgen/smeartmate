package de.tum.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.tum.dao.local.PatientEntityDaoLocal;
import de.tum.entities.PatientEntity;

@Stateless
@Local({ PatientEntityDaoLocal.class })
public class PatientEntityDao implements PatientEntityDaoLocal {
	
	
	private Logger log = Logger.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager em;

	@Override
	public PatientEntity getPatienById(String id) {
		// TODO Auto-generated method stub
		try {
			PatientEntity patient = em.find(PatientEntity.class, id);
			return patient;
		} catch (NullPointerException e) {
			log.error("Patient with id" + id + "notfound" + e.getMessage());
			// exception
			return null;
		}
	}

}
