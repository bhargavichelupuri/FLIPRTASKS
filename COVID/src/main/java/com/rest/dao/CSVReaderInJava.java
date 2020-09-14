package com.rest.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.rest.dto.Patients;
import com.ts.HibernateTemplate;

public class CSVReaderInJava {

	public static void main(String[] args) {
		readPatientsFromCSV("C:/Users/Bhagath/Downloads/covid19india.csv");

	}

	private static List<Patients> readPatientsFromCSV(String fileName) {
		List<Patients> patients  = new ArrayList<Patients>();
		Path pathToFile = Paths.get(fileName);

		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
			String line = br.readLine();
// StandardCharsets.US_ASCII
			while(line != null){
				String[] attributes = line.split(",");
				Patients patient = createPatient(attributes);

				patients.add(patient);
				System.out.println(line);
				line = br.readLine();
				
			}


		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patients;
	}

	private static Patients createPatient(String[] metadata) throws Exception{

		Patients patient = new Patients();
		
		patient.setPatientId(Integer.parseInt(metadata[0]));
		//System.out.println(patient.getPatientId());


		if(!metadata[2].equals("")){
			patient.setReportedOn(new SimpleDateFormat("dd/MM/yyyy").parse(metadata[1]));
		}

		//System.out.println(metadata[2].equals(""));
		if(!metadata[2].equals("")){
			patient.setOnSet(Integer.parseInt(metadata[2]));
		}
		if(!metadata[3].equals("")){
			String ageRange;
			int age;
			try{
				 age =Integer.parseInt( metadata[3]);
				 if(age >= 0 && age < 10){
						ageRange = "0-9";
					} else if( age <= 20){
						ageRange = "10-19";

					}else if( age <= 30){
						ageRange = "20-29";

					}else if( age <= 40){
						ageRange = "30-39";

					}else if( age <= 50){
						ageRange = "40-49";

					}else if( age < 60){
						ageRange = "50-59";

					}else if( age < 70){
						ageRange = "60-69";

					}else {
						ageRange = "70 and above";
					}
				
			} catch(Exception e){
				
				  ageRange = metadata[3];
			}
			
			
			  
			patient.setAgeEstimate(ageRange);
			  
		}
		if(!metadata[4].equals("")){
			patient.setGender(metadata[4]);

		}
		if(!metadata[5].equals("")){
			patient.setCity(metadata[5]);

		}
		if(!metadata[6].equals("")){
			patient.setDistrict( metadata[6]);

		}

		if(!metadata[7].equals("")){

			patient.setState(metadata[7]);;

		}
		if( !metadata[8].equals("")){

			patient.setStatus(metadata[8]);

		}

		if( metadata.length == 10 && !metadata[9].equals("")){
			patient.setNotes(metadata[9]);

		}

		if( metadata.length == 11 && !metadata[10].equals("") ){
			patient.setContractedFrom(metadata[10]);

		}
		
		HibernateTemplate.addObject(patient);
		return patient;
	}

}
