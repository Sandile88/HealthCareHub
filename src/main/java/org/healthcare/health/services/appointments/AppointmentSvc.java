package org.healthcare.health.services.appointments;

import java.time.LocalDateTime;

import org.healthcare.health.model.Appointment;


public interface AppointmentSvc {

    // Appointment findByDate(LocalDateTime date);

    Appointment addAppointment(Appointment appointment);

    Appointment editAppointmentDetails(Long id, Appointment appointment);

    
}
