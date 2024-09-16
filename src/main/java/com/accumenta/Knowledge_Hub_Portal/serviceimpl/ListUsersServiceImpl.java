package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exception.ListUserAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.ListUsers;
import com.accumenta.Knowledge_Hub_Portal.repository.ListUsersRepository;
import com.accumenta.Knowledge_Hub_Portal.service.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListUsersServiceImpl implements ListUserService {
    @Autowired
    private ListUsersRepository listUsersRepository;

    @Override
    public ListUsers getListUsers(long id, ListUsers listUsers) {
        ListUsers dblListUsers = this.listUsersRepository.findById(listUsers.getId()).orElse(null);
        if (dblListUsers == null) {
            return this.listUsersRepository.findById(id).get();
        } else {
            throw new ListUserAlreadyExceptionExists("ListUsers Id is not found");
        }

    }

    @Override
    public boolean deleteListUsers(long id) {

        ListUsers dbListUsers = this.listUsersRepository.findById(id).get();
        if (dbListUsers != null) {
            this.listUsersRepository.delete(dbListUsers);
            return true;
        } else {
            throw new ListUserAlreadyExceptionExists("ListUsers Id Already Exists");
        }
    }


    @Override
    public ListUsers updateListUsers(long id, ListUsers listUsers) {
        ListUsers dbListUsers1 = this.listUsersRepository.findById(id).get();
        if (dbListUsers1 != null) {
            dbListUsers1.setId(id);
            dbListUsers1.setEdit(listUsers.getEdit());
            dbListUsers1.setUserid(listUsers.getUserid());
            dbListUsers1.setUseremail(listUsers.getUseremail());
            return this.listUsersRepository.save(dbListUsers1);
        } else {
            throw new ListUserAlreadyExceptionExists("Already exists");
        }

    }

    @Override
    public ListUsers getListUsers(long id) {
        return null;
    }


    @Override
    public List<ListUsers> getAllListUsers() {
        return this.listUsersRepository.findAll();

    }

    @Override
    public ListUsers addListUsers(ListUsers listUsers) {
        ListUsers dbListUsers1 = this.listUsersRepository.findById(listUsers.getId()).orElse(null);
        if (dbListUsers1 == null) {
            return this.listUsersRepository.save(listUsers);
        } else {
            throw new ListUserAlreadyExceptionExists("ListUsers Id is not found");
        }
    }

}

