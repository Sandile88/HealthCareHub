package org.healthcare.health.services.appointments;

import org.healthcare.health.model.Appointment;


public interface AppointmentSvc {

    Appointment findById(Long id);


    Appointment addAppointment(Appointment appointment);

    Appointment editAppointmentDetails(Long id, Appointment appointment);

    
}
