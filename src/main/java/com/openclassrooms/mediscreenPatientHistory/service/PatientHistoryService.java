package com.openclassrooms.mediscreenPatientHistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;
import com.openclassrooms.mediscreenPatientHistory.mapper.PatientHistoryMapper;
import com.openclassrooms.mediscreenPatientHistory.model.PatientHistory;
import com.openclassrooms.mediscreenPatientHistory.repository.PatientHistoryRepository;

/**
 * Service for CRUD operations on patient histories. Maps the returns into DTO
 * objects.
 * 
 * @author emmanuel
 *
 */
@Service
public class PatientHistoryService {

	@Autowired
	private PatientHistoryRepository patientHistoryRepository;

	@Autowired
	private PatientHistoryMapper patientHistoryMapper;

	/**
	 * Gets the list of all histories of a patient by his ID and maps it into a list
	 * of PatientHistoryDto objects.
	 * 
	 * @param patientID - The patient's ID of the histories to get
	 * @return A list of PatientHistoryDto objects
	 */
	public List<PatientHistoryDto> getPatientHistoriesByPatientId(int patientID) {

		List<PatientHistory> patientHistories = patientHistoryRepository.findByPatientId(patientID);

		List<PatientHistoryDto> patientHistoryDtos = patientHistoryMapper
				.mapPatientHistoriesToPatientHistoryDtos(patientHistories);

		return patientHistoryDtos;
	}

	/**
	 * Gets a patient history by its ID and maps it into a PatientHistoryDto object.
	 * 
	 * @param historyId - The ID of the patient history to get
	 * @return A PatientHistoryDto object
	 */
	public PatientHistoryDto getPatientHistoryByHistoryId(String historyId) {

		PatientHistoryDto patientHistoryDto = patientHistoryMapper
				.mapPatientHistoryToPatientHistoryDto(patientHistoryRepository.findByHistoryId(historyId));

		return patientHistoryDto;
	}

	/**
	 * Maps a PatientHistoryDto object into a PatientHistory object and adds it into
	 * the database.
	 * 
	 * @param patientHistoryDto - The patient history to add
	 */
	public void addPatientHistory(PatientHistoryDto patientHistoryDto) {

		PatientHistory patientHistoryToSave = patientHistoryMapper
				.mapPatientHistoryDtoToPatientHistory(patientHistoryDto);

		patientHistoryRepository.save(patientHistoryToSave);

	}

	/**
	 * Maps a PatientHistoryDto object into a PatientHistory object, updates it into
	 * the database and returns the updated history as a PatientHistoryDto object.
	 * 
	 * @param patientHistoryDto - The patient history to update
	 * @return A PatientHistoryDto object
	 */
	public PatientHistoryDto updatePatientHistory(PatientHistoryDto patientHistoryDto) {

		PatientHistory patientHistoryToUpdate = patientHistoryMapper
				.mapPatientHistoryDtoToPatientHistory(patientHistoryDto);
		patientHistoryRepository.save(patientHistoryToUpdate);
		PatientHistory patientHistoryUpdated = patientHistoryRepository
				.findByHistoryId(patientHistoryToUpdate.getHistoryId());
		PatientHistoryDto patientHistoryDtoUpdated = patientHistoryMapper
				.mapPatientHistoryToPatientHistoryDto(patientHistoryUpdated);

		return patientHistoryDtoUpdated;
	}

	/**
	 * Deletes a patient history by its ID.
	 * 
	 * @param historyId - The ID of the history to delete
	 */
	public void deletePatientHistoryByHistoryId(String historyId) {

		patientHistoryRepository.deleteById(historyId);

	}

	/**
	 * Deletes all histories of a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient
	 */
	public void deleteAllPatientHistoriesByPatientId(int patientId) {

		patientHistoryRepository.deleteAllByPatientId(patientId);

	}

}
