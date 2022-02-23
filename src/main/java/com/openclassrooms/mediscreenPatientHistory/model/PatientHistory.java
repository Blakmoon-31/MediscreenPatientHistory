package com.openclassrooms.mediscreenPatientHistory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientHistory {

	private int historyID;

	private int patientId;

	private String practitionerNote;
}
