package de.tum.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/rest")
public class SmeartHeartRestApp extends  Application{
	
	
	public Set<Class<?>> getClasses() {

		Set<Class<?>> s = new HashSet<Class<?>>();

		s.add(PatientReportRestServiceIml.class);

		return s;
	}

}
