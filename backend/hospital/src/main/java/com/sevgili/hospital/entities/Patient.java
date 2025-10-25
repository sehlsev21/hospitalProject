package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name="patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private int id;

    @NonNull
    @NotEmpty
    @Column(name="name")
    private String name;

    @NonNull
    @NotEmpty
    @Column(name="surname")
    private String surname;

    @NonNull
    @NotEmpty
    @Column(name="nationality_id")
    private String nationalityId;

    @NonNull
    @NotEmpty
    @Column(name="phone_number")
    private String phoneNumber;
}
