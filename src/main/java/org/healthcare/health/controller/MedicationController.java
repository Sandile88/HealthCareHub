package org.healthcare.health.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.healthcare.health.model.Medication;
import org.healthcare.health.services.medications.MedicationSvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationSvc medicationSvc;

    public MedicationController(MedicationSvc medicationSvc) {
        this.medicationSvc = medicationSvc;
    }

    // Get Medication by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Medication> findById(@PathVariable("id") Long id) {
        Medication medication = medicationSvc.findById(id);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    // Get All Medications by Patient ID
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Medication>> findAllByPatientId(@PathVariable("patientId") Long patientId) {
        List<Medication> medications = medicationSvc.findAllByPatientId(patientId);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    // Add a New Prescription
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Medication> addPrescription(@RequestBody Medication medication) {
        Medication createdMedication = medicationSvc.addPrescription(medication);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

    // Edit an Existing Prescription
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Medication> editPrescription(@PathVariable("id") Long id, @RequestBody Medication medication) {
        Medication updatedMedication = medicationSvc.editPrescription(id, medication);
        return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
    }

    // Delete a Medication by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteMedication(@PathVariable("id") Long id) {
        medicationSvc.deleteMedication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get All Active Medications by Patient ID
    @RequestMapping(value = "/active/patient/{patientId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Medication>> findAllActiveMedicationsByPatientId(@PathVariable("patientId") Long patientId) {
        List<Medication> activeMedications = medicationSvc.findAllActiveMedicationsByPatientId(patientId);
        return new ResponseEntity<>(activeMedications, HttpStatus.OK);
    }
}
