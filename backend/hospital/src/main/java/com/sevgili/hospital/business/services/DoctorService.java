package com.sevgili.hospital.business.services;

import com.sevgili.hospital.entities.Doctor;
import com.sevgili.hospital.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }


    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    public Doctor createDoctor(Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }

    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public Doctor updateDoctor(int doctorId, Doctor newDoctor) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isPresent()) {
            Doctor foundDoctor = doctor.get();
            foundDoctor.setName(newDoctor.getName());
            foundDoctor.setSurname(newDoctor.getSurname());
            foundDoctor.setNationalityId(newDoctor.getNationalityId());
            foundDoctor.setPhoneNumber(newDoctor.getPhoneNumber());
            doctorRepository.save(foundDoctor);
            return foundDoctor;
        } else
            return null;
    }
}