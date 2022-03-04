package com.openclassrooms.mediscreenPatientHistory.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mediscreenPatientHistory.model.PatientHistory;

/**
 * Repository for CRUD operations on PatientHistory object.
 * 
 * @author emmanuel
 *
 */
@Repository
public interface PatientHistoryRepository extends MongoRepository<PatientHistory, String> {

	public PatientHistory findByHistoryId(String historyId);

	public List<PatientHistory> findByPatientId(int patientId);

	public void deleteAllByPatientId(int patientId);
}
