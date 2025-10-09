package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name="peaks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Peak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="id")
    private Appointment appointment;

    @OneToMany(mappedBy = "id")
    private List<Medicine> medicines;
}
