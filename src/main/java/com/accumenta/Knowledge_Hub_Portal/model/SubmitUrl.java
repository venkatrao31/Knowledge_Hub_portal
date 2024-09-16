package com.accumenta.Knowledge_Hub_Portal.model;


import com.accumenta.Knowledge_Hub_Portal.enumeration.UrlStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "SubmitUrl")
public class SubmitUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String url;
    private String description;
    private String category;
    @Enumerated(EnumType.STRING)
    private UrlStatus urlStatus;


}