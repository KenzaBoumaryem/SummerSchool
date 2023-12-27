package com.example.contactcrud.controllers;
import com.example.contactcrud.dto.SaveSessionDto;
import com.example.contactcrud.models.Session;
import com.example.contactcrud.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("/Create")
    public Integer  createSession(@RequestBody SaveSessionDto saveSessionDto) {
        return sessionService.save(saveSessionDto);
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Integer id) {
        System.out.println("1");
        return sessionService.findById(id);
    }

    @GetMapping("/All")
    public List<Session> getAllSessions() {
        return sessionService.findAll();
    }

    @PutMapping("/{id}")
    public void updateSession(@PathVariable Integer id, @RequestBody SaveSessionDto updatedSessionDto) {
        sessionService.update(id, updatedSessionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Integer id) {
        sessionService.delete(id);
    }



}
