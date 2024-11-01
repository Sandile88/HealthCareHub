package org.healthcare.health.controller;

import org.springframework.web.bind.annotation.RestController;
import org.healthcare.health.model.Patient;
import org.healthcare.health.service.PatientSvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@RequestMapping("/patients")

public class PatientController {

    private PatientSvc patientSvc;


    @RequestMapping(value="/index.html", method=RequestMethod.GET)
    @ResponseBody
    public String requestMethodName() {
        return "testinggggg ";
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET, 
    produces = "application/json")
    public ResponseEntity<Patient> findByPatientId(@PathVariable("id") Long id) {

        Patient patient = patientSvc.findByPatientId(id);
        System.out.println("idddd");

        return checkNullInputs(patient);
    }


    @RequestMapping(value = "/email/{email}", method=RequestMethod.GET, 
    produces = "application/json")
    public ResponseEntity<Patient> findByEmail(@PathVariable("email") String email) {

        Patient patient = patientSvc.findByEmail(email);
        System.out.println("emaillll");

        return checkNullInputs(patient);
    }


    @RequestMapping(method=RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        System.out.println("hereee");
        return new ResponseEntity<>(patientSvc.addPatient(patient), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method=RequestMethod.PUT,
    produces = "application/json")
    public ResponseEntity<Patient> editPatientDetails(@PathVariable Long id, @RequestBody Patient patient) {
        return new ResponseEntity<>(patientSvc.editPatientDetails(id, patient), HttpStatus.OK);
    }
    


    public ResponseEntity<Patient> checkNullInputs(Patient patient) {
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
          } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
          }
    }
}


