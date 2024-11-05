package org.healthcare.health.services.medications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.healthcare.health.model.Medication;
import org.healthcare.health.repository.MedicationRepository;
import org.healthcare.health.services.patients.PatientSvcImpl;
import org.springframework.stereotype.Service;

@Service
public class MedicationSvcImpl implements MedicationSvc {

    private MedicationRepository medicationRepository;
        private static final Logger logger = LoggerFactory.getLogger(MedicationSvcImpl.class); 


    public MedicationSvcImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }


    @Override
    public List<Medication> findAllByPatientId(Long patientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByPatientId'");
    }


    @Override
    public Medication findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    @Override
    public void deleteMedication(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMedication'");
    }


    @Override
    public Medication addPescription(Medication medication) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPescription'");
    }


    @Override
    public Medication editPescription(Long id, Medication medication) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editPescription'");
    }


    @Override
    public List<Medication> findAllActiveMedicationsByPatientId(Long patientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllActiveMedicationsByPatientId'");
    }

    

   
    
}
