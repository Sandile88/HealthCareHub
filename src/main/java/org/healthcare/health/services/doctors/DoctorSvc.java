package org.healthcare.health.services.doctors;

import java.util.List;

import org.healthcare.health.model.Doctor;

public interface DoctorSvc {

    Doctor findById(Long id);

    Doctor findBySpeciality(String specality);

    Doctor addDoctor(Doctor doctor);

    Doctor editDoctorDetails(Long id, Doctor doctor);

    void deleteDoctor(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> findAllAvailableDoctors();




    
} 
