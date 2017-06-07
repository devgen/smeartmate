package de.tum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5613415434108818087L;
	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
}
