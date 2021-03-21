package com.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.PatientDetails;
import com.repository.PatientDetailsRepository;
import com.service.PatientDetailsService;

/**
 *
 * @author Firoj Khan
 * @since 2021 Mar 21
 */
@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);

	@Autowired
	PatientDetailsRepository patientRecordrepository;

	@Override
	public PatientDetails savePatientDetails(PatientDetails patientDetails) {
		patientDetails.setCratedOn(new Date());
		LOGGER.info("save patient details");
		;
		return patientRecordrepository.save(patientDetails);
	}

	@Override
	public PatientDetails updatePatientDetails(Long id, PatientDetails patientDetails) {
		PatientDetails patient = patientRecordrepository.findById(id).orElse(null);
		patient.setName(patientDetails.getName());
		patient.setEmail(patientDetails.getEmail());
		patient.setPassword(patientDetails.getPassword());
		patient.setPhone(patientDetails.getPhone());
		patient.setAddress(patientDetails.getAddress());
		patientDetails.setCratedOn(new Date());
		LOGGER.info("update patient details");
		;
		return patientRecordrepository.save(patient);
	}

	@Override
	public PatientDetails deletePatientDetails(String name) {
		PatientDetails patient = patientRecordrepository.findByName(name);
		patientRecordrepository.deleteById(patient.getId());
		return patient;
	}

	@Override
	public List<PatientDetails> fetchAllPatient() {
		LOGGER.info("fetch All patient records");
		;
		return patientRecordrepository.findAll();
	}

}
