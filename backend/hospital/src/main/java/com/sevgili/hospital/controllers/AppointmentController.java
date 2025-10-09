package com.sevgili.hospital.controllers;

import com.sevgili.hospital.business.services.AppointmentService;
import com.sevgili.hospital.dtos.requests.CreateAppointmentRequest;
import com.sevgili.hospital.entities.Appointment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getDoctorAppointments(@RequestParam Optional<Integer> doctorId){
        return appointmentService.getDoctorAppointments(doctorId);
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentById(@RequestParam int appointmentId){
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping
    public Appointment createAppointment(@Validated @RequestBody CreateAppointmentRequest createAppointmentRequest){
        return appointmentService.createAppointment(createAppointmentRequest);
    }
}
