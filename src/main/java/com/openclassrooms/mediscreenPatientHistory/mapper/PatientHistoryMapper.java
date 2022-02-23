package com.openclassrooms.mediscreenPatientHistory.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;
import com.openclassrooms.mediscreenPatientHistory.model.PatientHistory;

@Service
public class PatientHistoryMapper {

	/**
	 * Map a PatientHistory object into a PatientHistoryDto object
	 * 
	 * @param patientHistory - The PatientHistory object to map
	 * @return patientHistoryDto - A PatientHistoryDto object
	 */
	public PatientHistoryDto mapPatientHistoryToPatientHistoryDto(PatientHistory patientHistory) {

		PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
		patientHistoryDto.setHistoryID(patientHistory.getHistoryID());
		patientHistoryDto.setPatientId(patientHistory.getPatientId());
		patientHistoryDto.setPractitionerNote(patientHistory.getPractitionerNote());

		return patientHistoryDto;
	}

	/**
	 * Map a PatientHistoryDto object into a PatientHistory object
	 * 
	 * @param patientHistoryDto - The PatientHistoryDto object to map
	 * @return patientHistory - A PatientHistory object
	 */
	public PatientHistory mapPatientHistoryDtoToPatientHistory(PatientHistoryDto patientHistoryDto) {

		PatientHistory patientHistory = new PatientHistory();
		patientHistory.setHistoryID(patientHistoryDto.getHistoryID());
		patientHistory.setPatientId(patientHistoryDto.getPatientId());
		patientHistory.setPractitionerNote(patientHistoryDto.getPractitionerNote());

		return patientHistory;
	}

	/**
	 * Map a list of PatientHistory objects into a list of PatientHistoryDto objects
	 * 
	 * @param patientHistories - The list of PatientHistory objects to map
	 * @return patientHistoryDtos - A list of PatientHistoryDto objects
	 */
	public List<PatientHistoryDto> mapPatientHistoriesToPatientHistoryDtos(List<PatientHistory> patientHistories) {

		List<PatientHistoryDto> patientHistoryDtos = new ArrayList<>();

		for (PatientHistory patientHistory : patientHistories) {
			patientHistoryDtos.add(mapPatientHistoryToPatientHistoryDto(patientHistory));
		}

		return patientHistoryDtos;
	}
}
