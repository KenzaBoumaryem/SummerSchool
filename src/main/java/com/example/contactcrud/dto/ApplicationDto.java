package com.example.contactcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String namePoster;
    private MultipartFile fileData;
}
