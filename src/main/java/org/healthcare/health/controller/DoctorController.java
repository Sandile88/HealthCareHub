package org.healthcare.health.controller;

import java.util.List;

import org.healthcare.health.model.Doctor;
import org.healthcare.health.services.doctors.DoctorSvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorSvc doctorSvc;

    public DoctorController(DoctorSvc doctorSvc) {
        this.doctorSvc = doctorSvc;
    }

    // Get all Doctors
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorSvc.getAllDoctors(), HttpStatus.OK);
    }

    // Get Doctor by ID
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Doctor> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(doctorSvc.findById(id), HttpStatus.OK);
    }

     // Get Doctor by Speciality
     @RequestMapping(value = "/speciality/{speciality}", method=RequestMethod.GET, produces = "application/json")
     public ResponseEntity<Doctor> findBySpeciality(@PathVariable("id") String speciality) {
         return new ResponseEntity<>(doctorSvc.findBySpeciality(speciality), HttpStatus.OK);
     }


    // Get All Available Doctors
    @RequestMapping(value = "/available", method=RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Doctor>> findAllAvailableDoctors() {
        return new ResponseEntity<>(doctorSvc.findAllAvailableDoctors(), HttpStatus.OK);
    }

    // Add a New Doctor
    @RequestMapping(method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorSvc.addDoctor(doctor), HttpStatus.OK);
    }

    //Edit an Existing Doctor
    @RequestMapping(value = "/{id}", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Doctor> editDoctorDetails(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorSvc.editDoctorDetails(id, doctor), HttpStatus.OK);
    } 

    // Delete Doctor Profile
    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorSvc.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
