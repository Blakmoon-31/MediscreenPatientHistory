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

@Api("API pour les opérations CRUD sur les historiques des patients.")
@RestController
public class PatientHistoryController {

	@Autowired
	private PatientHistoryService patientHistoryService;

	/**
	 * Get the list of all histories for one patient
	 * 
	 * @return patientHistoryDtos - A list of PatientHystoryDto objects
	 */
	@ApiOperation("Récupère la liste de tous les historiques d'un patient.")
	@GetMapping("/patient/histories/get")
	public List<PatientHistoryDto> getPatientHistoriesByPatientId(@RequestParam("patientId") int patientId) {

		List<PatientHistoryDto> patientHistoryDtos = patientHistoryService.getPatientHistoriesByPatientId(patientId);

		return patientHistoryDtos;

	}

	/**
	 * Get a patient history by its id
	 * 
	 * @param historyId - The id of the history
	 * @return A PatientHistoryDto object
	 */
	@ApiOperation("Récupère un historique patient à partir de son ID.")
	@GetMapping("/patient/history/get")
	public PatientHistoryDto getPatientHistoryByHistoryId(@RequestParam("historyId") int historyId) {

		PatientHistoryDto patientHistoryDto = patientHistoryService.getPatientHistoryByHistoryId(historyId);

		return patientHistoryDto;
	}

	/**
	 * Add a patient history in the database
	 * 
	 * @param patientHistoryDto - The PatientHistoryDto object to add
	 */
	@ApiOperation("Ajoute un historique patient dans la base de données.")
	@PostMapping("/patient/history/add")
	public void addPatientHistory(@RequestBody PatientHistoryDto patientHistoryDto) {

		patientHistoryService.addPatientHistory(patientHistoryDto);
	}

	/**
	 * Update a patient history in the database
	 * 
	 * @param patientHistoryDto - The PatientHistoryDto object to update
	 * @return The PatientHistoryDto updated
	 */
	@ApiOperation("Met à jour un historique patient.")
	@PutMapping("/patient/history/update")
	public PatientHistoryDto updatePatientHistory(@RequestBody PatientHistoryDto patientHistoryDto) {

		PatientHistoryDto patientHistoryDtoUpdated = patientHistoryService.updatePatientHistory(patientHistoryDto);

		return patientHistoryDtoUpdated;
	}

	/**
	 * Delete a patient history by its id
	 * 
	 * @param patientId - The id of the patient
	 */
	@ApiOperation("Supprime un historique patient de la base de données à partir de son ID.")
	@DeleteMapping("/patient/history/delete")
	public void deletePatientHistoryByPatientId(@RequestParam("historyId") int historyId) {

		patientHistoryService.deletePatientHistoryByHistoryId(historyId);
	}

	/**
	 * Delete all histories of a patient by his id
	 * 
	 * @param patientId - The id of the patient
	 */
	@ApiOperation("En cas de suppression d'un patient, supprime tous ses historiques de la base de données à partir de so ID.")
	@DeleteMapping("/patient/histories/delete")
	public void deleteAllPatientHistoryByPatientId(@RequestParam("patientId") int patientId) {

		patientHistoryService.deleteAllPatientHistoryByPatientId(patientId);
	}
}
