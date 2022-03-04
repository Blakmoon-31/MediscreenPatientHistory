package com.openclassrooms.mediscreenPatientHistory.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The model of the PatientHistory document in the database. Will be mapped into
 * PatientHistoryDto objects for exchange with the web UI.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Document("histories")
public class PatientHistory {

	@Id
	private String historyId;

	@Indexed
	private int patientId;

	private LocalDate historyDate;

	@Indexed
	@Field("practitionerNote")
	private String practitionerNote;

}
