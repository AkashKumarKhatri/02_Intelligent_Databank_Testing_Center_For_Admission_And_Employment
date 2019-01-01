/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.dao.UserDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akash
 */
public class UserDAOImpl implements UserDAO {

    private Connection con = DBConnection.getConnection() ;
    
    @Override
    public Integer addUser(UserModel userModel) {
        Integer row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into user (name,password,email,registration_date,remarks) values (?,?,?,?,?)");
            preparedStatement.setString(1, userModel.getUserName());
            preparedStatement.setString(2, userModel.getUserPassword());
            preparedStatement.setString(3, userModel.getEmail());
            preparedStatement.setTimestamp(4, userModel.getRegistrationDate());
            preparedStatement.setString(5, userModel.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateUser(UserModel userModel) {
        Integer row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update user set name = ?,password = ?,email = ?,registration_date = ?, remarks = ? where user_id = ?");
            preparedStatement.setString(1, userModel.getUserName());
            preparedStatement.setString(2, userModel.getUserPassword());
            preparedStatement.setString(3, userModel.getEmail());
            preparedStatement.setTimestamp(4, userModel.getRegistrationDate());
            preparedStatement.setString(5, userModel.getRemarks());
            preparedStatement.setInt(6, userModel.getUserId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteUser(UserModel userModel) {
        Integer row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update user set active = 0 where user_id = ?");
            preparedStatement.setInt(1, userModel.getUserId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<UserModel> getAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserModel getUserWithId(Integer userId) {
        UserModel userModel = null;        
        String sql = "select * from user where user_id = ? and active = 1";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                userModel = new UserModel();
                userModel.setUserName(rs.getString("name"));
                userModel.setUserPassword(rs.getString("password"));
                userModel.setEmail(rs.getString("email"));
                userModel.setRemarks(rs.getString("remarks"));
                userModel.setRegistrationDate(rs.getTimestamp("registration_date"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return userModel;
    }

    @Override
    public ResultSet getAllUserResultSet() {
        ResultSet rst = null;
        try {
            String sql = "select user_id as 'User ID',name as 'Username',email as 'Email',registration_date as "
                    + "'Registration Date',remarks as 'Remarks',created_by as 'Created By',created_date as "
                    + "'Created Date',modified_by as 'Modified By',modified_date as 'Modified Date' from user where active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public UserModel getUser(String userName, String password) {
        UserModel userModel = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from user where name = ? and password = ? and active = 1");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                userModel = new UserModel();
                userModel.setUserId(resultSet.getInt("user_id"));
                userModel.setUserName(resultSet.getString("name"));
                userModel.setUserPassword(resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return userModel;
    }
}
