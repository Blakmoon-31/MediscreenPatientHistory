package com.openclassrooms.mediscreenPatientHistory.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfert Object of PatientHistory used for exchange with the web UI.
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Document("histories")
public class PatientHistoryDto {

	@Id
	private String historyId;

	@Indexed
	private int patientId;

	private LocalDate historyDate;

	@Indexed
	private String practitionerNote;

}
