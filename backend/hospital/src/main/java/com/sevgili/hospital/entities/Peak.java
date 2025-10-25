package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name="peak")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Peak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="peak_id")
    private int id;

    @OneToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    @OneToMany(mappedBy = "peak")
    private List<Medicine> medicines;
}
