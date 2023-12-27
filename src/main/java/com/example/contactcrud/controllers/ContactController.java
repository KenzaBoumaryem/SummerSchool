package com.example.contactcrud.controllers;


import com.example.contactcrud.dto.RequestContact;
import com.example.contactcrud.dto.ResponseContact;
import com.example.contactcrud.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
@Autowired
    private ContactService contactService;

@GetMapping("get")
public List<ResponseContact> findAll(){
    return contactService.findAll();
}
@PostMapping("save")
public ResponseContact ajouterContact(@RequestBody  RequestContact requestContact){
   return contactService.saveContact(requestContact);

}
@DeleteMapping("delete/{id}")
public void SupprimerContact(@PathVariable  Integer id){
    contactService.deleteContact(id);
}
//@PutMapping("update/{id}")
//public ResponseContact updateContact( @RequestBody RequestContact requestContact,@PathVariable Integer id){
//    return contactService.updateContact(requestContact,id);
//}
@GetMapping("get/{id}")
public ResponseContact findById( @PathVariable Integer id){
    return contactService.findByidContact(id);
}
@PostMapping("/sendMail")
    public String sendMail(@RequestParam(value = "file",required = false)MultipartFile[] file,String to,String []cc,String subject,String message){
    return contactService.sendMail(file,to,cc,subject,message);
}
@GetMapping("/getEmail/{id}")
    public String findEmail(@PathVariable Integer id){
    return contactService.findEmail(id);
}
}
