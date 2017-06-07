package de.tum.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.tum.dao.local.UserDaoLocal;
import de.tum.entities.Patient;

@Stateless
@Local({ UserDaoLocal.class })
public class UserDao implements UserDaoLocal {
	
	
	private Logger log = Logger.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager em;

	@Override
	public Patient getPatienById(String id) {
		// TODO Auto-generated method stub
		try {
			Patient patient = em.find(Patient.class, id);
			return patient;
		} catch (NullPointerException e) {
			log.error("Patient with id" + id + "notfound" + e.getMessage());
			// exception
			return null;
		}
	}

}
