package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.Register;
import com.accumenta.Knowledge_Hub_Portal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/saveRegister", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveRegister(@RequestBody Register register) {
        Register dbRegister1 = this.registerService.addRegister(register);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbRegister1));
    }
    @PutMapping(value = "/updateRegister/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateRegister(@RequestBody Register register, @PathVariable long id) {
        Register dbRegister1 = this.registerService.updateRegister(id, register);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbRegister1));
    }
    @DeleteMapping(value = "/deleteRegister/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteRegister(@PathVariable long id) {
        boolean dbregister =this.registerService.deleteRegister(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbregister));
    }

    @GetMapping(value = "/getRegister/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getRegister(@PathVariable long id,@RequestBody Register register) {
        Register dbRegister1 = this.registerService.getRegister(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbRegister1));
    }

    @GetMapping(value = "/getRegister",produces="application/json")
    public ResponseEntity<ResponseWrapper> getallApprove() {
        List<Register> dbRegisters=this.registerService.getAllRegister();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbRegisters));
    }
}


