package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Value("%{management.upload.image.path}")
    private String imageUploadPath;

    @GetMapping()
    public String doctorPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctor", all);
        return "doctor";
    }

    @GetMapping("/add")
    public String addDoctorPage() {
        return "addDoctor";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor,
                            @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            doctor.setProfilePic(fileName);
        }
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/{id}")
    public String singleDoctorPage(@PathVariable("id") int id,
                                   ModelMap modelMap) {
        Optional<Doctor> byId = doctorRepository.findById(id);
        if (byId.isPresent()) {
            Doctor doctor = byId.get();
            modelMap.addAttribute("doctor", doctor);
            return "singleDoctor";
        } else {
            return "redirect:/doctors";
        }

    }

    @GetMapping("/remove")
    public String removeDoctor(@RequestParam("id") int id) {
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }
}
