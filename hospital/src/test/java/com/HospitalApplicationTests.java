package com;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.domain.Address;
import com.domain.PatientDetails;
import com.repository.PatientDetailsRepository;
import com.service.impl.PatientDetailsServiceImpl;

/**
 *
 * @author Firoj Khan
 * @since 2021 Mar 21
 */

@SpringBootTest
class HospitalApplicationTests {

	@Mock
	PatientDetailsRepository patientRepository;

	@InjectMocks
	PatientDetailsServiceImpl patientDetailsService;

	@Test
	public void saveData() {
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setEmail("firojkhan@gmail.com");
		patientDetails.setName("Firoj");
		patientDetails.setPhone(1234567890L);
		patientDetails.setPassword("1123456789");
		Address address = new Address();
		address.setAddressLin1("Maliviye Nagar");
		address.setCity("Hyderabad");
		address.setCountry("India");
		patientDetails.setAddress(address);

		Mockito.when(patientRepository.save(patientDetails)).thenReturn(patientDetails);
		Assert.assertEquals(patientDetails, patientDetailsService.savePatientDetails(patientDetails));
	}

	@Test
	public void updatePatientData() {
		PatientDetails patientDetailsA = new PatientDetails();
		patientDetailsA.setId(1L);
		patientDetailsA.setEmail("firojkhan@gmail.com");
		patientDetailsA.setName("Firoj");
		patientDetailsA.setPhone(1234567890L);
		patientDetailsA.setPassword("Firoj@1234");
		Address addressA = new Address();
		addressA.setAddressLin1("Maliviye Nagar");
		addressA.setCity("Hyderabad");
		addressA.setCountry("India");
		patientDetailsA.setAddress(addressA);

		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setEmail("firojkhan@gmail.com");
		patientDetails.setName("Firoj Khan");
		patientDetails.setPhone(1234567890L);
		patientDetails.setPassword("FirojKhan@123");
		Address address = new Address();
		address.setAddressLin1("Maliviye Nagar");
		address.setCity("Hyderabad");
		address.setCountry("India");
		patientDetails.setAddress(address);

		Mockito.when(patientRepository.save(patientDetailsA)).thenReturn(patientDetailsA);
		Mockito.when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patientDetailsA));
		PatientDetails p = patientDetailsService.updatePatientDetails(1L, patientDetails);
		Assert.assertEquals(patientDetails.getName(), p.getName());
	}

	@Test
	public void fetchAllPatientData() {
		PatientDetails patientDetailsA = new PatientDetails();
		patientDetailsA.setId(1L);
		patientDetailsA.setEmail("firojkhan@gmail.com");
		patientDetailsA.setName("Firoj");
		patientDetailsA.setPhone(1234567890L);
		patientDetailsA.setPassword("Firoj@1234");
		Address addressA = new Address();
		addressA.setAddressLin1("Maliviye Nagar");
		addressA.setCity("Hyderabad");
		addressA.setCountry("India");
		patientDetailsA.setAddress(addressA);

		PatientDetails patientDetailsB = new PatientDetails();
		patientDetailsB.setId(2L);
		patientDetailsB.setEmail("firojkhan@gmail.com");
		patientDetailsB.setName("Firoj Khan");
		patientDetailsB.setPhone(1234567890L);
		patientDetailsB.setPassword("FirojKhan@123");
		Address addressB = new Address();
		addressB.setAddressLin1("Maliviye Nagar");
		addressB.setCity("Hyderabad");
		addressB.setCountry("India");
		patientDetailsB.setAddress(addressB);

		List<PatientDetails> pd = new ArrayList<PatientDetails>();
		pd.add(patientDetailsA);
		pd.add(patientDetailsB);
		Mockito.when(patientRepository.save(patientDetailsA)).thenReturn(patientDetailsA);
		Mockito.when(patientRepository.save(patientDetailsB)).thenReturn(patientDetailsB);
		Mockito.when(patientRepository.findAll()).thenReturn(pd);
		Assert.assertEquals(2, patientDetailsService.fetchAllPatient().size());
	}

}
