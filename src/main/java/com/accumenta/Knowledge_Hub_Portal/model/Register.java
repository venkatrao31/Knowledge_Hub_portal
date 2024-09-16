package com.accumenta.Knowledge_Hub_Portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;
    private String useremail;
    private String password;
    private String confirmpassoword;

}
