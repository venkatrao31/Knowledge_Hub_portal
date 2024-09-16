package com.accumenta.Knowledge_Hub_Portal.service;


import com.accumenta.Knowledge_Hub_Portal.model.Register;

import java.util.List;

public interface RegisterService {

    public Register addRegister(Register register);

    boolean deleteRegister(long id);

    public Register updateRegister(long id, Register register);
    public Register getRegister(long id);
    List<Register> getAllRegister();

}
