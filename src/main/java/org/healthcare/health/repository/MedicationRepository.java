package org.healthcare.health.repository;

import java.util.List;
import java.util.Optional;

import org.healthcare.health.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query("select m from Medication m where m.id = :id")
    Optional<Medication> findById(Long id); // i can use this for my delete function

     @Query("select m from Medication m where m.patient.id = :patientId")
    List<Medication> findAllByPatientId(@Param("patientId") Long patientId);

    @Query("select m from Medication m where m.patient.id = :patientId AND m.status = 'Active'")
    List<Medication> findAllActiveMedicationsByPatientId(@Param("patientId") Long patientId);

}
