package com.sevgili.hospital.business.services;

import com.sevgili.hospital.dtos.requests.CreateAppointmentRequest;
import com.sevgili.hospital.entities.Appointment;
import com.sevgili.hospital.entities.Doctor;
import com.sevgili.hospital.entities.Patient;
import com.sevgili.hospital.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorService doctorService;
    private PatientService patientService;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorService doctorService, PatientService patientService){
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    public List<Appointment> getDoctorAppointments(Optional<Integer> doctorId) {
        if(doctorId.isPresent()){
            return appointmentRepository.findByDoctorId(doctorId.get());
        }
        return appointmentRepository.findAll();
    }


    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    public Appointment createAppointment(CreateAppointmentRequest createAppointmentRequest) {
        Doctor doctor = doctorService.getDoctorById(createAppointmentRequest.getDoctorId());
        Patient patient = patientService.getPatientById(createAppointmentRequest.getPatientId());
        if(doctor == null ){
            return null;
        }
        if(patient == null ){
            return null;
        }
        Appointment toSave = new Appointment();
        toSave.setDoctor(doctor);
        toSave.setPatient(patient);
        toSave.setAppointmentDate(createAppointmentRequest.getAppointmentDate());
        return appointmentRepository.save(toSave);
    }
}
