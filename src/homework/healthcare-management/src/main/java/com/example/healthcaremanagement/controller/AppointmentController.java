package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Appointment;
import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repo.AppointmentRepository;
import com.example.healthcaremanagement.repo.DoctorRepository;
import com.example.healthcaremanagement.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping()
    public String appointmentsPage(ModelMap modelMap) {
        List<Appointment> all = appointmentRepository.findAll();
        modelMap.addAttribute("appointment", all);
        return "appointment";
    }

    @GetMapping("/add")
    public String addAppointmentPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctor", all);
        List<Patient> all1 = patientRepository.findAll();
        modelMap.addAttribute("patient", all);
        return "addAppointment";
    }

    @PostMapping("/add")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        appointment.setDate(new Date());
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/{id}")
    public String singleAppointmentPage(@PathVariable("id") int id,
                                        ModelMap modelMap) {
        Optional<Appointment> byId = appointmentRepository.findById(id);
        if (byId.isPresent()) {
            Appointment appointment = byId.get();
            modelMap.addAttribute("appointment", appointment);
            return "singleAppointment";
        } else {
            return "redirect:/Appointments";
        }

    }

    @GetMapping("/remove")
    public String removeAppointment(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }
}
