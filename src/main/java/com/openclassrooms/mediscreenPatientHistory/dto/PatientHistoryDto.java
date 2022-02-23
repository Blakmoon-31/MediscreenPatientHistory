package com.openclassrooms.mediscreenPatientHistory.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientHistoryDto {

	private int historyID;

	private int patientId;

	private String practitionerNote;

}
