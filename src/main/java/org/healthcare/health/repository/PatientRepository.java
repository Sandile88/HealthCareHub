package org.healthcare.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.healthcare.health.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    @Query("select p from Patient p where p.id = :id")
    Patient findByPatientId(Long id);

    @Query("select p from Customer p where p.email = :email")
    Patient findByEmail(String email);
}
