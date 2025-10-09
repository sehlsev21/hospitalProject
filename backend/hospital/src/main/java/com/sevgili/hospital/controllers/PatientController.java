package com.sevgili.hospital.controllers;

import com.sevgili.hospital.business.services.PatientService;
import com.sevgili.hospital.entities.Patient;
import com.sevgili.hospital.repositories.PatientRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin("http://localhost:5173/")
public class PatientController {

    private PatientService patientService;
    private PatientRepository patientRepository;

    public PatientController(PatientService patientService, PatientRepository patientRepository) {
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient createPatient(@Validated @RequestBody Patient newPatient){
        return patientRepository.save(newPatient);
    }

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable int patientId){
        return patientService.getPatientById(patientId);
    }

    /*@DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCartRequest deleteCartRequest){
        return this.cartService.delete(deleteCartRequest);
    }*/
}
