package org.healthcare.health.services.appointments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import org.healthcare.health.model.Appointment;
import org.healthcare.health.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.healthcare.health.services.patients.PatientSvcImpl;


@Service
public class AppointmentSvcImpl implements AppointmentSvc {

    public final AppointmentRepository appointmentRepository;

    public AppointmentSvcImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment editAppointmentDetails(Long id, Appointment appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id);
            return appointmentRepository.save(appointment);
        } else {
          throw new RuntimeException("Appointment with id: " + id + " could not be found");
        }
    
}

}