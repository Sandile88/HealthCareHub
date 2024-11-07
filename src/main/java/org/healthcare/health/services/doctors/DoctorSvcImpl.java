package org.healthcare.health.services.doctors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;


import org.healthcare.health.model.Doctor;
import org.healthcare.health.repository.DoctorRepository;
import org.healthcare.health.repository.MedicationRepository;
import org.healthcare.health.services.doctors.DoctorSvc;
import org.springframework.stereotype.Service;

@Service
public class DoctorSvcImpl implements DoctorSvc {

    private final DoctorRepository doctorRepository;
    private static final Logger logger = LoggerFactory.getLogger(DoctorSvcImpl.class);

    public DoctorSvcImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findById(Long id) {
        logger.info("Searching for Doctor with ID {}", id);
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID " + id));
    }

    @Override
    public Doctor findBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality)
                .orElseThrow(() -> new RuntimeException("Doctor not found with speciality " + speciality));
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
       return doctorRepository.save(doctor);
    }

    @Override
    public Doctor editDoctorDetails(Long id, Doctor doctor) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor with ID " + id + " could not be found.");
        }
        doctor.setId(id);  // Ensure we're updating the correct ID
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAllAvailableDoctors() {
       return doctorRepository.findByAcceptingNewPatients(true);
    }
}

