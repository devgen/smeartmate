package de.tum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AudioRecordEntity implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4470057920622502089L;
	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	@Lob
	private Byte[] file;

}
