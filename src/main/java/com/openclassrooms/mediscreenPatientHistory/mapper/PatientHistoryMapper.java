package com.openclassrooms.mediscreenPatientHistory.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;
import com.openclassrooms.mediscreenPatientHistory.model.PatientHistory;

/**
 * The mapper between PatientHistory and PatientHistoryDto objects.
 * 
 * @author emmanuel
 *
 */
@Service
public class PatientHistoryMapper {

	/**
	 * Maps a PatientHistory object into a PatientHistoryDto object.
	 * 
	 * @param patientHistory - The PatientHistory object to map
	 * @return A PatientHistoryDto object
	 */
	public PatientHistoryDto mapPatientHistoryToPatientHistoryDto(PatientHistory patientHistory) {

		PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
		patientHistoryDto.setHistoryId(patientHistory.getHistoryId());
		patientHistoryDto.setPatientId(patientHistory.getPatientId());
		patientHistoryDto.setHistoryDate(patientHistory.getHistoryDate());
		patientHistoryDto.setPractitionerNote(patientHistory.getPractitionerNote());

		return patientHistoryDto;
	}

	/**
	 * Maps a PatientHistoryDto object into a PatientHistory object.
	 * 
	 * @param patientHistoryDto - The PatientHistoryDto object to map
	 * @return A PatientHistory object
	 */
	public PatientHistory mapPatientHistoryDtoToPatientHistory(PatientHistoryDto patientHistoryDto) {

		PatientHistory patientHistory = new PatientHistory();
		patientHistory.setHistoryId(patientHistoryDto.getHistoryId());
		patientHistory.setPatientId(patientHistoryDto.getPatientId());
		patientHistory.setHistoryDate(patientHistoryDto.getHistoryDate());
		patientHistory.setPractitionerNote(patientHistoryDto.getPractitionerNote());

		return patientHistory;
	}

	/**
	 * Maps a list of PatientHistory objects into a list of PatientHistoryDto
	 * objects.
	 * 
	 * @param patientHistories - The list of PatientHistory objects to map
	 * @return A list of PatientHistoryDto objects
	 */
	public List<PatientHistoryDto> mapPatientHistoriesToPatientHistoryDtos(List<PatientHistory> patientHistories) {

		List<PatientHistoryDto> patientHistoryDtos = new ArrayList<>();

		for (PatientHistory patientHistory : patientHistories) {
			patientHistoryDtos.add(mapPatientHistoryToPatientHistoryDto(patientHistory));
		}

		return patientHistoryDtos;
	}
}
