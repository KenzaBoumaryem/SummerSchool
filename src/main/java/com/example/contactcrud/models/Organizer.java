package com.example.contactcrud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Organizer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String institution;
    @Lob
    @Column(name = "Picture", columnDefinition = "LONGBLOB")
    private byte[] Picture;

    @OneToMany(mappedBy = "organizer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Session> sessions;




}
