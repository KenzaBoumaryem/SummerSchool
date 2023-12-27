package com.example.contactcrud.controllers;


import com.example.contactcrud.dto.ApplicationDto;
import com.example.contactcrud.models.Application;
import com.example.contactcrud.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getAllApplications")
    public List<Application> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return applications;
    }

    @PostMapping("/createApplication")
    public Application createApplication(@ModelAttribute ApplicationDto applicationDto) throws IOException {

            Application createdApplication = applicationService.saveApplication(applicationDto);
            return createdApplication;

    }
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) {
        ResponseEntity<Resource> response = applicationService.downloadFileById(id);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
