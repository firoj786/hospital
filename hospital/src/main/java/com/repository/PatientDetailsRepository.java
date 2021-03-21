package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.PatientDetails;

/**
 *
 * @author Firoj Khan
 * @since 2021 Mar 21
 */
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {

	List<PatientDetails> findAll();

	PatientDetails findByName(String name);
}
