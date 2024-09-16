package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exception.LoginAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.Login;
import com.accumenta.Knowledge_Hub_Portal.repository.LoginRepository;
import com.accumenta.Knowledge_Hub_Portal.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl  implements LoginService {

    private LoginRepository loginRepository;
    @Override
    public List<Login> getAllLogin() {
        return this.loginRepository.findAll();
    }

    @Override
    public Login addLogin(Login login) {
            Login dbLogin = this.loginRepository.findById(login.getId()).orElse(null);
            if (dbLogin == null) {
                return this.loginRepository.save(login);
            } else {
                throw new LoginAlreadyExceptionExists("Login Id is not found");
            }
    }

    @Override
    public Login getLoginById(long id) {
            Login dbLogin = this.loginRepository.findById(id).get();
            if (dbLogin != null) {
                return this.loginRepository.findById(id).get();
            } else {
                throw new LoginAlreadyExceptionExists("ApproveUrls Id Already Exists");
            }
        }


    @Override
    public Login updateLogin(long id, Login login) {
            Login dbLogin = this.loginRepository.findById(id).get();
            if (dbLogin != null) {
            dbLogin.setPassword(login.getPassword());
            dbLogin.setUsername(login.getPassword());
                return this.loginRepository.save(dbLogin);
            } else {
                throw new LoginAlreadyExceptionExists("Already exists");
            }

    }

    @Override
    public boolean deleteLogin(long id) {
            Login dbLogin = this.loginRepository.findById(id).get();
            if (dbLogin != null) {
                this.loginRepository.delete(dbLogin);
                return true;
            } else {
                throw new LoginAlreadyExceptionExists("Login Id Already Exists");
            }

        }

    }

