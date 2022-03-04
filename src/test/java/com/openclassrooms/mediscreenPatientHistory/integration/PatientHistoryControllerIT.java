package com.openclassrooms.mediscreenPatientHistory.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatientHistory.controller.PatientHistoryController;
import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PatientHistoryControllerIT {

	@Autowired
	private PatientHistoryController patientHistoryController;

	private String historyIdToDelete;

	@BeforeAll
	public void setTestData() {

		PatientHistoryDto patientHistoryDto1 = new PatientHistoryDto();
		patientHistoryDto1.setPatientId(6);
		patientHistoryDto1.setHistoryDate(LocalDate.now());
		patientHistoryDto1.setPractitionerNote("Test note médecin patient 6");

		patientHistoryController.addPatientHistory(patientHistoryDto1);

		PatientHistoryDto patientHistoryDto2 = new PatientHistoryDto();
		patientHistoryDto2.setPatientId(7);
		patientHistoryDto2.setHistoryDate(LocalDate.now());
		patientHistoryDto2.setPractitionerNote("Test note médecin patient 7 to delete");

		patientHistoryController.addPatientHistory(patientHistoryDto2);
		historyIdToDelete = patientHistoryController.getPatientHistoriesByPatientId(7).get(0).getHistoryId();

		PatientHistoryDto patientHistoryDto3 = new PatientHistoryDto();
		patientHistoryDto3.setPatientId(8);

		patientHistoryController.addPatientHistory(patientHistoryDto3);

		PatientHistoryDto patientHistoryDto4 = new PatientHistoryDto();
		patientHistoryDto4.setPatientId(8);

		patientHistoryController.addPatientHistory(patientHistoryDto4);

	}

	@AfterAll
	private void resetTestData() {

		patientHistoryController.deleteAllPatientHistoryByPatientId(5);
		patientHistoryController.deleteAllPatientHistoryByPatientId(6);

	}

	@Test
	public void testGetPatientHistoriesByPatientId() {

		List<PatientHistoryDto> patientHistoryDtos = patientHistoryController.getPatientHistoriesByPatientId(4);

		assertThat(patientHistoryDtos.size()).isEqualTo(4);
	}

	@Test
	public void testGetPatientHistoryByHistoryId() {

		PatientHistoryDto patientHistoryDto = patientHistoryController
				.getPatientHistoryByHistoryId("621d1a5fe185f9340cfeeb67");

		assertThat(patientHistoryDto.getPatientId()).isEqualTo(3);
	}

	@Test
	public void testAddPatienthistory() {

		PatientHistoryDto patientHistoryDtoToAdd = new PatientHistoryDto();
		patientHistoryDtoToAdd.setPatientId(5);
		patientHistoryDtoToAdd.setHistoryDate(LocalDate.now());
		patientHistoryDtoToAdd.setPractitionerNote("Test note médecin");

		patientHistoryController.addPatientHistory(patientHistoryDtoToAdd);

		PatientHistoryDto patientHistoryDtoAdded = patientHistoryController.getPatientHistoriesByPatientId(5).get(0);

		assertThat(patientHistoryDtoAdded.getPractitionerNote()).isEqualTo("Test note médecin");

	}

	@Test
	public void testUpdatePatientHistory() {

		PatientHistoryDto patientHistoryDtoToUpdate = patientHistoryController.getPatientHistoriesByPatientId(6).get(0);

		patientHistoryDtoToUpdate.setPractitionerNote("Test note médecin patient 6 updated");

		patientHistoryController.updatePatientHistory(patientHistoryDtoToUpdate);

		PatientHistoryDto patientHistoryDtoUpdated = patientHistoryController
				.getPatientHistoryByHistoryId(patientHistoryDtoToUpdate.getHistoryId());

		assertThat(patientHistoryDtoUpdated.getPractitionerNote()).isEqualTo("Test note médecin patient 6 updated");
	}

	@Test
	public void testDeletePatientHistoryByHistoryId() {

		patientHistoryController.deletePatientHistoryByHistoryId(historyIdToDelete);

		List<PatientHistoryDto> patientHistoryDtos = patientHistoryController.getPatientHistoriesByPatientId(7);

		assertThat(patientHistoryDtos.isEmpty()).isTrue();

	}

	@Test
	public void testDeleteAllPatientHistoriesByPatientId() {

		patientHistoryController.deleteAllPatientHistoryByPatientId(8);

		List<PatientHistoryDto> patientHistoryDtosDeleted = patientHistoryController.getPatientHistoriesByPatientId(8);

		assertThat(patientHistoryDtosDeleted.size()).isEqualTo(0);
	}

}
