package com.example.healthcaremanagement.repo;

import com.example.healthcaremanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
