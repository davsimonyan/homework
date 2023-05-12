package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping()
    public String patientsPage(ModelMap modelMap) {
        List<Patient> all = patientRepository.findAll();
        modelMap.addAttribute("patient", all);
        return "patients";
    }

    @GetMapping("/add")
    public String addPatientPage() {
        return "addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    public String singlePatientPage(@PathVariable("id") int id,
                                    ModelMap modelMap) {
        Optional<Patient> byId = patientRepository.findById(id);
        if (byId.isPresent()) {
            Patient patient = byId.get();
            modelMap.addAttribute("patient", patient);
            return "singlePatient";
        } else {
            return "redirect:/patients";
        }

    }

    @GetMapping("/remove")
    public String removePatient(@RequestParam("id") int id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}
