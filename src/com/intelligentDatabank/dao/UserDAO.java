/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.UserModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface UserDAO {
    public Integer addUser(UserModel userModel);
    public Integer updateUser(UserModel userModel);
    public Integer deleteUser(UserModel userModel);
    public List<UserModel> getAllUser();
    public UserModel getUserWithId(Integer userId);
    public ResultSet getAllUserResultSet();
    public UserModel getUser(String userName, String password);
}