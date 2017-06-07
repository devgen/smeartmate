package de.tum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class NutritionEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8438111230353279799L;



	@Id
	@javax.persistence.GeneratedValue(generator = "system-uuid")
	@org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
	private String id;
	
	
	
	@Column
	private Date date;
	
	
	@Column
	private int burnt;
	
	
	@Column
	private int gained;
	
}
