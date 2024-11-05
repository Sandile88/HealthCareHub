package org.healthcare.health.services.medications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import org.healthcare.health.model.Medication;
import org.healthcare.health.model.Patient;
import org.healthcare.health.repository.MedicationRepository;
import org.healthcare.health.services.patients.PatientSvc;
import org.springframework.stereotype.Service;

@Service
public class MedicationSvcImpl implements MedicationSvc {

    private final MedicationRepository medicationRepository;
    private final PatientSvc patientSvc;
    private static final Logger logger = LoggerFactory.getLogger(MedicationSvcImpl.class);

    public MedicationSvcImpl(MedicationRepository medicationRepository, PatientSvc patientSvc) {
        this.medicationRepository = medicationRepository;
        this.patientSvc = patientSvc;
    }

    @Override
    public List<Medication> findAllByPatientId(Long patientId) {
        logger.info("Searching for medications with patient ID {}", patientId);
        try {
            List<Medication> medications = medicationRepository.findAllByPatientId(patientId);
            if (medications.isEmpty()) {
                throw new RuntimeException("No medications found for patientId " + patientId);
            }
            logger.info("Found medications for patient ID {}: {}", patientId, medications);
            return medications;
        } catch (Exception e) {
            String message = "Error while searching for medications with patientId " + patientId + ": " + e.getMessage();
            logger.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public Medication findById(Long id) {
        logger.info("Searching for medication with ID {}", id);
        return medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found with ID " + id));
    }

    @Override
    public void deleteMedication(Long id) {
        Medication medication = findById(id);
        medicationRepository.delete(medication);
        logger.info("Deleted medication with ID {}", id);
    }

    @Override
    public Medication addPrescription(Medication medication) {
        if (medication.getPatient() == null || medication.getPatient().getId() == null) {
            throw new RuntimeException("Patient information is required to add a prescription.");
        }
        Patient patient = patientSvc.findByPatientId(medication.getPatient().getId());
        if (patient == null) {
            throw new RuntimeException("Patient not found with ID: " + medication.getPatient().getId());
        }
        medication.setPatient(patient);
        return medicationRepository.save(medication);
    }

    @Override
    public Medication editPrescription(Long id, Medication medication) {
        if (!medicationRepository.existsById(id)) {
            throw new RuntimeException("Medication with ID " + id + " could not be found.");
        }
        medication.setId(id);
        Patient patient = patientSvc.findByPatientId(medication.getPatient().getId());
        if (patient == null) {
            throw new RuntimeException("Patient not found with ID: " + medication.getPatient().getId());
        }
        medication.setPatient(patient);
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> findAllActiveMedicationsByPatientId(Long patientId) {
        return medicationRepository.findAllActiveMedicationsByPatientId(patientId);
    }
}
