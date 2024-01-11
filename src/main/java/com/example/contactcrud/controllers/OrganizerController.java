package com.example.contactcrud.controllers;

import com.example.contactcrud.dto.*;
import com.example.contactcrud.models.Application;
import com.example.contactcrud.models.Organizer;
import com.example.contactcrud.services.OrganizersService;
import com.example.contactcrud.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Organizer")

public class OrganizerController {
    @Autowired
    OrganizersService organizersService;

    @PostMapping("/Create")
    public String createOrganizer(@ModelAttribute RequestOrganizer requestOrganizer) throws IOException {

        ResponseOrganizer organizer = organizersService.saveOrganizer(requestOrganizer);

        return "OK";

    }
    @GetMapping("/getAllOrganizers")
    public List<ResponseOrganizer> getAllOrganizers() {
        List<ResponseOrganizer> organizers = organizersService.getAllOrganizers();
        return organizers;
    }
}
