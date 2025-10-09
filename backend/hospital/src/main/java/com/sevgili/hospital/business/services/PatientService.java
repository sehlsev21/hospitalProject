package com.sevgili.hospital.business.services;

import com.sevgili.hospital.entities.Patient;
import com.sevgili.hospital.repositories.DoctorRepository;
import com.sevgili.hospital.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(int patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }
}
