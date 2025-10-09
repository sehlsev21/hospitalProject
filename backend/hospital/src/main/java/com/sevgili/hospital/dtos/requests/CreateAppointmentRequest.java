package com.sevgili.hospital.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAppointmentRequest {
    int id;
    int doctorId;
    int patientId;
    LocalDate appointmentDate;
}
