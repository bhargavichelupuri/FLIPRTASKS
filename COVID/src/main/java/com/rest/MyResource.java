package com.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.rest.dto.Patients;
import com.ts.HibernateTemplate;


@Path("myresource")
public class MyResource {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@Path("viewAllPatients")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patients> viewAllCustomers(){

		List<Patients> patientsList = HibernateTemplate.viewAllPatients();	
		System.out.println("retrieved all patients");
		return patientsList;	
	}
	
	@Path("getStatistics/{ageGroup}/{gender}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getStatistics(@PathParam("ageGroup") String ageGroup, @PathParam("gender") String gender){
		Object count =  HibernateTemplate.getStaticstics(ageGroup, gender);	
		System.out.println(count);
		return count;	

	}
}
