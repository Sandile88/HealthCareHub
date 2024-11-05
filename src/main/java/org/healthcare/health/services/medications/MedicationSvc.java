package org.healthcare.health.services.medications;

import java.util.List;

import org.healthcare.health.model.Medication;

public interface MedicationSvc {

    List<Medication> findAllByPatientId(Long patientId);

    Medication findById(Long id);

    void deleteMedication(Long id);

    Medication addPrescription(Medication medication);

    Medication editPrescription(Long id, Medication medication);

    List<Medication> findAllActiveMedicationsByPatientId(Long patientId);
    
}
