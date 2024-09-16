package com.accumenta.Knowledge_Hub_Portal.service;

import com.accumenta.Knowledge_Hub_Portal.model.Login;

import java.util.List;

public interface LoginService {
    public List<Login> getAllLogin();
    Login addLogin( Login  Login);
    Login getLoginById(long id);
    Login updateLogin(long id,  Login  Login);
    boolean deleteLogin(long id);
}



