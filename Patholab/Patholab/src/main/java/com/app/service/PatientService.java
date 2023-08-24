package com.app.service;

import javax.validation.Valid;

import com.app.dto.PatientDto;

public interface PatientService {
	String addPatientDetails(@Valid PatientDto patient);
}
