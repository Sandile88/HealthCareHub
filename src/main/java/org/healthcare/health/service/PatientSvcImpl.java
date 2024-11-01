package org.healthcare.health.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.healthcare.health.model.Patient;
import org.healthcare.health.repository.PatientRepository;
import org.springframework.stereotype.Service;


@Service
public class PatientSvcImpl implements PatientSvc {

    private PatientRepository patientRepository;

    private static final Logger logger = LoggerFactory.getLogger(PatientSvcImpl.class); 

    @Override
    public Patient findByPatientId(Long id) {
        logger.info("search for patient with id {}", id);
        try {
            Patient patient = patientRepository.findByPatientId(id);
            if (patient != null) {
              logger.info("Found patient with id {} details {}", id, patient);
            }
            return patient;
            
        } catch (Exception e) {
            String message = "Error while searching for patient with id " + id
            + e.getMessage();
            logger.error(message, e);
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public Patient findByEmail(String email) {
        logger.info("search for patient with email {}", email);
        try {
            Patient patient = patientRepository.findByEmail(email);
            if (patient != null) {
              logger.info("Found patient with email {} details {}", email, patient);
            }
            return patient;
            
        } catch (Exception e) {
            String message = "Error while searching for patient with email " + email
            + e.getMessage();
            logger.error(message, e);
            throw new RuntimeException(message, e);
        }
       }


        
      @Override
      public Patient addPatient(Patient patient) {
          return patientRepository.save(patient);
      }
  
      @Override
      public Patient editPatientDetails(Long id, Patient patient) {
          if (patientRepository.existsById(id)) {
              patient.setId(id);
              return patientRepository.save(patient);
          } else {
            throw new RuntimeException("Patient with id: " + id + " could not be found");
          }
      } 
      

  
}
