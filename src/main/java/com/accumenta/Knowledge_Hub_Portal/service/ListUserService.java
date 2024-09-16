package com.accumenta.Knowledge_Hub_Portal.service;


import com.accumenta.Knowledge_Hub_Portal.model.ListUsers;

import java.util.List;

public interface ListUserService {
    public List<ListUsers> getAllListUsers();

    ListUsers addListUsers(ListUsers listUsers);

    ListUsers updateListUsers(long id, ListUsers listUsers);



    ListUsers getListUsers( long id );

    ListUsers getListUsers(long id, ListUsers listUsers);

    boolean deleteListUsers(long id);


}