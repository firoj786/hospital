package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.PatientDetails;
import com.service.PatientDetailsService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Firoj Khan
 * @since 2021 Mar 21
 */
@RestController
@RequestMapping(path = "/v1")
public class HospitalController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	PatientDetailsService patientDetails;

	@PostMapping(path = "/patient")
	public PatientDetails savePatientDetails(@RequestBody PatientDetails ptientDetails) {
		LOGGER.info("Save patient record");
		return patientDetails.savePatientDetails(ptientDetails);
	}

	@PutMapping(path = "/patient/{id}")
	public PatientDetails updatePatientDetails(@PathVariable("id") Long id, @RequestBody PatientDetails ptientDetails) {
		LOGGER.info("Update patient record");
		return patientDetails.updatePatientDetails(id, ptientDetails);
	}

	@DeleteMapping(path = "/patient/{name}")
	public PatientDetails deletePatientDetails(@PathVariable String name) {
		LOGGER.info("Delete patient record");
		return patientDetails.deletePatientDetails(name);
	}

	@GetMapping(path = "/getAllPatient")
	public List<PatientDetails> fetchAllPatientDetails() {
		LOGGER.info("fetch all record by name");
		return patientDetails.fetchAllPatient();
	}
}
