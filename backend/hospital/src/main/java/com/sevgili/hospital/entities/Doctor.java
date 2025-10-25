package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name="doctor")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int id;

    @Column(name="name")
    @NonNull
    @NotEmpty
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
