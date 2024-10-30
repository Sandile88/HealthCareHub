package org.healthcare.health.service;

import org.healthcare.health.model.Patient;

public interface PatientSvc {

    Patient findByPatientId(Long id);

    Patient findByEmail(String email);

    Patient addPatient(Patient patient);

    Patient editPatientDetails(Long id, Patient Patient);
    
}
