package com.app.service;

import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PatientDto;
import com.app.entities.Patient;
import com.app.repository.PatientRepository;
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addPatientDetails(@Valid PatientDto patient) {
		Patient pat = mapper.map(patient, Patient.class);
		Date currentDate = new Date();
        pat.setCreatedOn(currentDate);
        pat.setModifyOn(currentDate);
        LocalDate dateOfBirth = pat.getDateOfBirth(); 
        pat.setDateOfBirth(dateOfBirth); 

        patientRepo.save(pat);
        
		return pat.getPatientFirstName() + " Added Successfully!";
	}

}
