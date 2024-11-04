package org.healthcare.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.healthcare.health.model.Appointment;
import org.healthcare.health.model.Patient;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("select a from Appointment a where a.id = :id")
    Optional findById(Long id);
    
}
