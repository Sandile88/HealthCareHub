package org.healthcare.health.services.appointments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.healthcare.health.model.Appointment;
import org.healthcare.health.model.Patient;
import org.healthcare.health.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.healthcare.health.services.patients.PatientSvc;
import org.healthcare.health.services.patients.PatientSvcImpl;
import org.healthcare.health.controller.PatientController;


@Service
public class AppointmentSvcImpl implements AppointmentSvc {

    private final AppointmentRepository appointmentRepository;
    private final PatientSvc patientSvc;
    private PatientController patientController;
        private static final Logger logger = LoggerFactory.getLogger(PatientSvcImpl.class); 


    public AppointmentSvcImpl(AppointmentRepository appointmentRepository, PatientSvc patientSvc) {
        this.appointmentRepository = appointmentRepository;
        this.patientSvc = patientSvc;
    }

    @Override
    public Appointment findById(Long id) {
        logger.info("Searching for appointment with id {}", id);
        try {
            Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
            Appointment appointment = optionalAppointment.orElseThrow(() -> 
                new RuntimeException("Appointment not found with id " + id)
            );
            logger.info("Found appointment with id {} details {}", id, appointment);
            return appointment;
        } catch (Exception e) {
            String message = "Error while searching for appointment with id " + id + ": " + e.getMessage();
            logger.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        Patient patient = patientSvc.findByPatientId(appointment.getPatient().getId());
        if (patient == null) {
            throw new RuntimeException("Patient not found with ID: " + appointment.getPatient().getId());
        }
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
        }

    @Override
    public Appointment editAppointmentDetails(Long id, Appointment appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id);

        Patient patient = patientSvc.findByPatientId(appointment.getPatient().getId());
        if (patient == null) {
            throw new RuntimeException("Patient not found with ID: " + appointment.getPatient().getId());
        }
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    } else {
        throw new RuntimeException("Appointment with ID: " + id + " could not be found");
    }

}


    // public Patient retrievePatient(Patient patient) {
    //     Patient patient = patientSvc.findByPatientId(appointment.getPatient().getId());
    //     if (patient == null) {
    //         throw new RuntimeException("Patient not found with ID: " + appointment.getPatient().getId());
    //     }
    //     return patient;

    // }
}

