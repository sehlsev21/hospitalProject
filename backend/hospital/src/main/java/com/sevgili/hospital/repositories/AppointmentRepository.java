package com.sevgili.hospital.repositories;

import com.sevgili.hospital.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctorId(Integer doctorId);
}
