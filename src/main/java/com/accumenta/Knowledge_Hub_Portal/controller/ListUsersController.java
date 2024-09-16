package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.ListUsers;
import com.accumenta.Knowledge_Hub_Portal.service.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list")
public class ListUsersController {
    @Autowired
    private ListUserService listUserService;

    @PostMapping(value = "/savelist", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveListUsers(@RequestBody ListUsers listUsers) {
        ListUsers dbSubmitUrl = this.listUserService.addListUsers(listUsers);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbSubmitUrl));
    }
    @PutMapping(value = "/updateuser/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateListUsers(@RequestBody ListUsers listUsers, @PathVariable long id) {
        ListUsers dblistUsers = this.listUserService.updateListUsers(id, listUsers);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dblistUsers));
    }
    @DeleteMapping(value = "/deleteusers/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteListusers(@PathVariable long id) {
        boolean dbListUsers =this.listUserService.deleteListUsers(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbListUsers));
    }

    @GetMapping(value = "/getlist/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getlistUsers(@PathVariable long id,@RequestBody ListUsers listUsers) {
        ListUsers dbListUsers1 = this.listUserService.getListUsers(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbListUsers1));
    }

    @GetMapping(value = "/getallapp",produces="application/json")
    public ResponseEntity<ResponseWrapper> getAllListUsers() {
        List<ListUsers> dbListUsers=this.listUserService.getAllListUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbListUsers));
    }
}


