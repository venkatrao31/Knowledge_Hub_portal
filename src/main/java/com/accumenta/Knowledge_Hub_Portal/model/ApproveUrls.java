package com.accumenta.Knowledge_Hub_Portal.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "ApproveUrls")
public class ApproveUrls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String url;
    private String catetogry;



}