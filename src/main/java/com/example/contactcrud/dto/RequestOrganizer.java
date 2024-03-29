package com.example.contactcrud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrganizer {
    private String firstName;
    private String lastName;
    private String institution;
    private MultipartFile Picture;
}
