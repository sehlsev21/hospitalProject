package com.sevgili.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="medicines")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicine {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

}
