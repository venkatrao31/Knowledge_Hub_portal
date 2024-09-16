package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exception.RegisterAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.Register;
import com.accumenta.Knowledge_Hub_Portal.repository.RegisterRepository;
import com.accumenta.Knowledge_Hub_Portal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register addRegister(Register register) {
        Register dbRegister1 = this.registerRepository.findById(register.getId()).orElse(null);
        if (dbRegister1 == null) {
            return this.registerRepository.save(register);
        } else {
            throw new RegisterAlreadyExceptionExists("Register Id is not found");
        }
    }

    @Override
    public boolean deleteRegister(long id) {
        Register dbRegister1 = this.registerRepository.findById(id).get();
        if (dbRegister1 != null) {
            this.registerRepository.delete(dbRegister1);
            return true;
        } else {
            throw new RegisterAlreadyExceptionExists("Register Id Already Exists");
        }
    }

    @Override
    public Register updateRegister(long id, Register register) {
        Register dbRegister1 = this.registerRepository.findById(id).get();
        if (dbRegister1 != null) {
            dbRegister1.setId(id);
            dbRegister1.setUseremail(register.getUseremail());
            dbRegister1.setPassword(register.getPassword());
            dbRegister1.setConfirmpassoword(register.getConfirmpassoword());
            return this.registerRepository.save(dbRegister1);
        } else {
            throw new RegisterAlreadyExceptionExists("Already exists");
        }
    }

    @Override
    public Register getRegister(long id) {
        Register dbRegister = this.registerRepository.findById(id).get();
        if (dbRegister != null) {
            return this.registerRepository.findById(id).get();
        } else {
            throw new RegisterAlreadyExceptionExists("Register Id Already Exists");
        }
    }


    @Override
    public List<Register> getAllRegister() {
        return this.registerRepository.findAll();
    }

}