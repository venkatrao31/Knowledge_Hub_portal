package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.Login;
import com.accumenta.Knowledge_Hub_Portal.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")

public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/savelogin", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveLogin(@RequestBody Login login) {
        Login dbLogin = this.loginService.addLogin(login);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbLogin));
    }
    @GetMapping(value = "/getlogin/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getlogin() {
        List<Login> dbLogin = this.loginService.getAllLogin();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(new ResponseWrapper<>(dbLogin)));
    }
    @PutMapping(value = "/updatelogin/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateLogin(@RequestBody Login login, @PathVariable long id) {
        Login dbLogin = this.loginService.updateLogin(id, login);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbLogin));
    }
    @DeleteMapping(value = "/dellogin{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteLogin(@PathVariable long id) {
        boolean dblogin=this.loginService.deleteLogin(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dblogin));
    }
    @GetMapping(value = "/getalllogin",produces="application/json")
    public ResponseEntity<ResponseWrapper> getalllogin()
    {
        List<Login> dbLogins=this.loginService.getAllLogin();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbLogins));
    }
}

