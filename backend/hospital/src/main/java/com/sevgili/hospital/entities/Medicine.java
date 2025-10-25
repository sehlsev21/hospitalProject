package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="medicine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicine {

    @Id
    @Column(name="medicine_id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "peak_id")
    private Peak peak;

}
