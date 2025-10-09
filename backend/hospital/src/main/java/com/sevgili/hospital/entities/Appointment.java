package com.sevgili.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name="appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir doktor silindiğinde onun bu randevusunu sil
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir hasta silindiğinde onun bu randevusunu sil
    private Patient patient;

    @Column(name="appointment_date", nullable = false)
    private LocalDate appointmentDate;
}
