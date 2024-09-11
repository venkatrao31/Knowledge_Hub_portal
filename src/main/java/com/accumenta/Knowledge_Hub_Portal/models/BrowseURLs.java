package com.accumenta.Knowledge_Hub_Portal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class BrowseURLs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (name = "Title")
    private String title;
    @Column (name = "URL")
    private String url;
    @Column (name = "Description")
    private String description;
    @Column (name = "PostedBy")
    private String postedBy;


}
