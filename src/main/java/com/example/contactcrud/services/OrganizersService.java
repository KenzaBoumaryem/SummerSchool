package com.example.contactcrud.services;

import com.example.contactcrud.dto.*;
import com.example.contactcrud.models.Application;
import com.example.contactcrud.models.Organizer;
import com.example.contactcrud.models.contact;
import com.example.contactcrud.repositories.ContactDAO;
import com.example.contactcrud.repositories.OrganizerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizersService  {
    @Autowired
    private OrganizerRepository organizerRepository;
    private ModelMapper modelMapper;
    @Autowired
    public OrganizersService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ResponseOrganizer saveOrganizer(RequestOrganizer requestOrganizer) throws IOException {

        MultipartFile file = requestOrganizer.getPicture();

        byte[] fileData = file.getBytes();
        Organizer organizer=modelMapper.map(requestOrganizer,Organizer.class);
        organizer.setPicture(fileData);
        Organizer saved=organizerRepository.save(organizer);
        //conversion du  entite au DTO pour renvoyer la reponse
        return modelMapper.map(saved,ResponseOrganizer.class);



    }

    public List<ResponseOrganizer> getAllOrganizers() {
        List<Organizer> organizers = organizerRepository.findAll();
        List<ResponseOrganizer> responseOrganizers = organizers.stream()
                .map(organizer -> modelMapper.map(organizer, ResponseOrganizer.class))
                .collect(Collectors.toList());

        return responseOrganizers;
    }



}
