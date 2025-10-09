package com.sevgili.hospital.controllers;

import com.sevgili.hospital.business.services.DoctorService;
import com.sevgili.hospital.entities.Doctor;
import com.sevgili.hospital.repositories.DoctorRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
@CrossOrigin("http://localhost:5173/")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable int doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping
    public Doctor createDoctor(@Validated @RequestBody Doctor newDoctor){
        return doctorService.createDoctor(newDoctor);
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@PathVariable int doctorId, @RequestBody Doctor newDoctor){
        return doctorService.updateDoctor(doctorId, newDoctor);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable int doctorId){
        doctorService.deleteDoctor(doctorId);
    }
}
