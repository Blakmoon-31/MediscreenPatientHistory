package com.openclassrooms.mediscreenPatientHistory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;
import com.openclassrooms.mediscreenPatientHistory.service.PatientHistoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The REST controller for CRUD operations on patient history.
 * 
 * @author emmanuel
 *
 */
@Api("API pour les opérations CRUD sur les historiques des patients.")
@RestController
public class PatientHistoryController {

	@Autowired
	private PatientHistoryService patientHistoryService;

	/**
	 * Gets the list of all histories for one patient.
	 * 
	 * @return A list of PatientHystoryDto objects
	 */
	@ApiOperation("Récupère la liste de tous les historiques d'un patient.")
	@GetMapping("/patient/histories/get")
	public List<PatientHistoryDto> getPatientHistoriesByPatientId(@RequestParam("patientId") int patientId) {

		List<PatientHistoryDto> patientHistoryDtos = patientHistoryService.getPatientHistoriesByPatientId(patientId);

		return patientHistoryDtos;

	}

	/**
	 * Gets a patient history by its ID.
	 * 
	 * @param historyId - The ID of the history
	 * @return A PatientHistoryDto object
	 */
	@ApiOperation("Récupère un historique patient à partir de son ID.")
	@GetMapping("/patient/history/get")
	public PatientHistoryDto getPatientHistoryByHistoryId(@RequestParam("historyId") String historyId) {

		PatientHistoryDto patientHistoryDto = patientHistoryService.getPatientHistoryByHistoryId(historyId);

		return patientHistoryDto;
	}

	/**
	 * Adds a patient history in the database.
	 * 
	 * @param patientHistoryDto - The patient history to add
	 */
	@ApiOperation("Ajoute un historique patient dans la base de données.")
	@PostMapping("/patient/history/add")
	public void addPatientHistory(@RequestBody PatientHistoryDto patientHistoryDto) {

		patientHistoryService.addPatientHistory(patientHistoryDto);
	}

	/**
	 * Updates a patient history in the database.
	 * 
	 * @param patientHistoryDto - The patient history to update
	 * @return A PatientHistoryDto object
	 */
	@ApiOperation("Met à jour un historique patient.")
	@PutMapping("/patient/history/update")
	public PatientHistoryDto updatePatientHistory(@RequestBody PatientHistoryDto patientHistoryDto) {

		PatientHistoryDto patientHistoryDtoUpdated = patientHistoryService.updatePatientHistory(patientHistoryDto);

		return patientHistoryDtoUpdated;
	}

	/**
	 * Deletes a patient history by its ID.
	 * 
	 * @param historyId - The ID of the patient history to delete
	 */
	@ApiOperation("Supprime un historique patient de la base de données à partir de son ID.")
	@DeleteMapping("/patient/history/delete")
	public void deletePatientHistoryByHistoryId(@RequestParam("historyId") String historyId) {

		patientHistoryService.deletePatientHistoryByHistoryId(historyId);
	}

	/**
	 * Deletes all histories of a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient
	 */
	@ApiOperation("En cas de suppression d'un patient, supprime tous ses historiques de la base de données à partir de son ID.")
	@DeleteMapping("/patient/histories/delete")
	public void deleteAllPatientHistoryByPatientId(@RequestParam("patientId") int patientId) {

		patientHistoryService.deleteAllPatientHistoriesByPatientId(patientId);
	}
}
