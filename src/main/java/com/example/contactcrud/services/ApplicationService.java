package com.example.contactcrud.services;



import com.example.contactcrud.dto.ApplicationDto;
import com.example.contactcrud.models.Application;
import com.example.contactcrud.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications;
    }

    public Application saveApplication(ApplicationDto applicationDto) throws IOException {
        MultipartFile file = applicationDto.getFileData();

        byte[] fileData = file.getBytes();

        Application application = new Application();
        application.setFirstName(applicationDto.getFirstName());
        application.setLastName(applicationDto.getLastName());
        application.setEmail(applicationDto.getEmail());
        application.setTelephone(applicationDto.getTelephone());
        application.setNamePoster(applicationDto.getNamePoster());
        application.setFileData(fileData);

        return applicationRepository.save(application);
    }
    public ResponseEntity<Resource> downloadFileById(Integer id) {
        Application application = applicationRepository.findById(id).orElse(null);

        if (application != null && application.getFileData() != null) {
            byte[] fileData = application.getFileData();
            ByteArrayResource resource = new ByteArrayResource(fileData);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=my_file.pdf");
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileData.length)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public Application getApplicationById(Integer id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        return optionalApplication.orElse(null);
    }

}
