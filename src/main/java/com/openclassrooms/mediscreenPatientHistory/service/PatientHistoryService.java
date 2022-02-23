package com.openclassrooms.mediscreenPatientHistory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatientHistory.dto.PatientHistoryDto;

@Service
public class PatientHistoryService {

	public List<PatientHistoryDto> getPatientHistoriesByPatientId(int patientID) {
		// TODO Auto-generated method stub
		return null;
	}

	public PatientHistoryDto getPatientHistoryByHistoryId(int HistoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPatientHistory(PatientHistoryDto patientHistoryDto) {
		// TODO Auto-generated method stub

	}

	public PatientHistoryDto updatePatientHistory(PatientHistoryDto patientHistoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletePatientHistoryByHistoryId(int historyId) {
		// TODO Auto-generated method stub

	}

	public void deleteAllPatientHistoryByPatientId(int patientId) {
		// TODO Auto-generated method stub

	}

}
