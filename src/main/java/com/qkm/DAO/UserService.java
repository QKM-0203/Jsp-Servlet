package com.qkm.DAO;

import com.qkm.user.*;

import java.util.List;

public interface UserService {
    public List<user> findAll();
    public void addUser(user User);
    public void deleteUser(String id);
    public void updateUser(user User);
    public user findUser(String id);
}
