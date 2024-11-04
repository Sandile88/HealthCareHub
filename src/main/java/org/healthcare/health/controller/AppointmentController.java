package org.healthcare.health.controller;


import org.springframework.web.bind.annotation.RestController;
import org.healthcare.health.model.Appointment;
import org.healthcare.health.model.Patient;
import org.healthcare.health.services.appointments.AppointmentSvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentSvc appointmentSvc;

    public AppointmentController (AppointmentSvc appointmentSvc) {
        this.appointmentSvc = appointmentSvc;
    }

    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, 
    produces = "application/json")
    public ResponseEntity<Appointment> findById(@PathVariable("id") Long id) {

        Appointment appointment = appointmentSvc.findById(id);
        System.out.println("idddd");

        return checkNullInputs(appointment);
    }


    
    @RequestMapping(method=RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        System.out.println("hereee");
        return new ResponseEntity<>(appointmentSvc.addAppointment(appointment), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method=RequestMethod.PUT,
    produces = "application/json")
    public ResponseEntity<Appointment> editAppointmentDetails(@PathVariable Long id, @RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentSvc.editAppointmentDetails(id, appointment), HttpStatus.OK);
    }


    public ResponseEntity<Appointment> checkNullInputs(Appointment appointment) {
        if (appointment != null) {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
          } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
          }
    }
    
    
}
