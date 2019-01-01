/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.intelligentDatabank.dao.DisciplineDAO;
import com.intelligentDatabank.dao.GroupDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.DisciplineModel;
import com.intelligentDatabank.models.GroupModel;
import com.intelligentDatabank.util.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aashique Ali
 */
public class GroupDAOImpl implements GroupDAO{
    Connection con = DBConnection.getConnection();
    @Override
    public List<GroupModel> getAllGroups() {
        List<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from groups where active = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                groupModel = new GroupModel();
                groupModel.setGroupName(resultSet.getString(Constants.COL_GROUP_NAME));
                groupModel.setGroupId(resultSet.getInt(Constants.COL_GROUP_GROUPID));
                groupModel.setRemarks(resultSet.getString(Constants.COL_GROUP_REMARKS));
                groupModels.add(groupModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupModels;
    }

    @Override
    public Integer addGroup(GroupModel groupModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into groups (name, discipline_id, remarks) values(?,?,?)");
            preparedStatement.setString(1, groupModel.getGroupName());
            preparedStatement.setInt(2, groupModel.getDiscilineModel().getDisciplineId());
            preparedStatement.setString(3, groupModel.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateGroup(GroupModel groupModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update groups set name = ? ,discipline_id = ?, remarks = ? where group_id = ? ");
            preparedStatement.setString(1, groupModel.getGroupName());
            preparedStatement.setInt(2, groupModel.getDiscilineModel().getDisciplineId());
            preparedStatement.setString(3, groupModel.getRemarks());
            preparedStatement.setInt(4, groupModel.getGroupId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteGroup(GroupModel groupModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update groups set active = 0 where group_id = ?");
            preparedStatement.setInt(1, groupModel.getGroupId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public GroupModel getGroupWithId(Integer groupId) {
        GroupModel groupModel = null;
        DisciplineDAO disciplineDAO = new DisciplineDAOImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from groups where group_id  = ? ");
            preparedStatement.setInt(1, groupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                groupModel = new GroupModel();
                groupModel.setGroupName(resultSet.getString(Constants.COL_GROUP_NAME));
                groupModel.setRemarks(resultSet.getString(Constants.COL_GROUP_REMARKS));
                groupModel.setDiscilineModel(disciplineDAO.getDisciplineWithId(resultSet.getInt(Constants.COL_DISCIPLINE_DISCIPLINEID)));
                groupModel.setGroupId(resultSet.getInt(Constants.COL_GROUP_GROUPID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupModel;
    }

    @Override
    public GroupModel getGroupIdWithName(String groupName) {
        GroupModel groupModel = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from groups where name  = ? ");
            preparedStatement.setString(1, groupName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                groupModel = new GroupModel();
                groupModel.setGroupId(resultSet.getInt(Constants.COL_GROUP_GROUPID));
                groupModel.setGroupName(resultSet.getString(Constants.COL_GROUP_NAME));
                groupModel.setRemarks(resultSet.getString(Constants.COL_GROUP_REMARKS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupModel;
    }

    @Override
    public ResultSet getAllGroupResultSet() {
        ResultSet rst = null;
        try {
            String sql = "SELECT g.group_id AS 'Group ID',g.name AS 'Group',d.name AS 'Discipline',g.remarks AS 'Remarks',g.created_by AS "
                    + "'Created By',g.created_date AS 'Created Date',g.modified_by AS 'Modified By',g.modified_date "
                    + "AS 'Modified Date' FROM `groups` g INNER JOIN `discipline` d ON g.discipline_id = d.discipline_id"
                    + " WHERE g.active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public List<GroupModel> getAllGroupsByDisciplineId(DisciplineModel disciplineModel) {
        List<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from groups where discipline_id = ? and active = 1");
            preparedStatement.setInt(1, disciplineModel.getDisciplineId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                groupModel = new GroupModel();
                groupModel.setGroupName(resultSet.getString(Constants.COL_GROUP_NAME));
                groupModel.setGroupId(resultSet.getInt(Constants.COL_GROUP_GROUPID));
                groupModel.setRemarks(resultSet.getString(Constants.COL_GROUP_REMARKS));
                groupModels.add(groupModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupModels;
    }
}
