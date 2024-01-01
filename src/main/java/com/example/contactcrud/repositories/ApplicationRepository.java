package com.example.contactcrud.repositories;

import com.example.contactcrud.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Optional<Application> findByEmail(String email);

}
