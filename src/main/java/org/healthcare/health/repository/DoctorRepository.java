package org.healthcare.health.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.healthcare.health.model.Doctor;
import java.util.List;
import java.util.Optional;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("select d from Doctor d where d.id = :id")
    Optional<Doctor> findById(Long id);

    @Query("select d from Doctor d")
    List<Doctor> findAllDoctors();

    @Query("select d from Doctor d where d.speciality = :speciality")
    Optional<Doctor> findBySpeciality(String speciality);
    
    @Query("select d from Doctor d where d.acceptingNewPatients = :acceptingNewPatients")
    List<Doctor> findByAcceptingNewPatients(boolean acceptingNewPatients);

    
    
} 
