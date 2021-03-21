package com.service;

import java.util.List;

import com.domain.PatientDetails;

/**
 *
 * @author Firoj Khan
 * @since 2021 Mar 21
 */
public interface PatientDetailsService {

	PatientDetails savePatientDetails(PatientDetails patientDetails);

	PatientDetails updatePatientDetails(Long id, PatientDetails ptientDetails);

	PatientDetails deletePatientDetails(String name);

	List<PatientDetails> fetchAllPatient();
}
