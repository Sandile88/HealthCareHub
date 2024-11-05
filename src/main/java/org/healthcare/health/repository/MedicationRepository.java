package org.healthcare.health.repository;

import java.util.Optional;

import org.healthcare.health.model.Medication;
import org.healthcare.health.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query("select m from Medication m where m.id = :id")
    Optional findById(Long id);

    @Query("select m from Medication m where m.id = :id")
    Medication findAllByPatientId(Long patientId);

    
}
