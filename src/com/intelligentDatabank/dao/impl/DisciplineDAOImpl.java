/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.dao.DisciplineDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.DisciplineModel;
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
public class DisciplineDAOImpl implements DisciplineDAO {
    Connection con = DBConnection.getConnection();

    @Override
    public Integer addDiscipline(DisciplineModel disciplineModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into discipline (name, remarks) values(?,?)");
            preparedStatement.setString(1, disciplineModel.getDisciplineName());
            preparedStatement.setString(2, disciplineModel.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateDiscipline(DisciplineModel disciplineModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update discipline set name = ?, remarks = ? where discipline_id = ? ");
            preparedStatement.setString(1, disciplineModel.getDisciplineName());
            preparedStatement.setString(2, disciplineModel.getRemarks());
            preparedStatement.setInt(3, disciplineModel.getDisciplineId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteDiscipline(DisciplineModel disciplineModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update discipline set active = 0 where discipline_id = ?");
            preparedStatement.setInt(1, disciplineModel.getDisciplineId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<DisciplineModel> getAllDisciplines() {
        List<DisciplineModel> disciplineModels = new ArrayList<>();
        DisciplineModel disciplineModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from discipline where active = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                disciplineModel = new DisciplineModel();
                disciplineModel.setDisciplineId(resultSet.getInt(Constants.COL_DISCIPLINE_DISCIPLINEID));
                disciplineModel.setDisciplineName(resultSet.getString(Constants.COL_DISCIPLINE_NAME));
                disciplineModel.setRemarks(resultSet.getString(Constants.COL_DISCIPLINE_REMARKS));
                disciplineModels.add(disciplineModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineModels;
    }

    @Override
    public DisciplineModel getDisciplineWithId(Integer disciplineId) {
        DisciplineModel disciplineModel = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from discipline where discipline_id  = ? ");
            preparedStatement.setInt(1, disciplineId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                disciplineModel = new DisciplineModel();
                disciplineModel.setDisciplineName(resultSet.getString(Constants.COL_DISCIPLINE_NAME));
                disciplineModel.setRemarks(resultSet.getString(Constants.COL_DISCIPLINE_REMARKS));
                disciplineModel.setDisciplineId(resultSet.getInt(Constants.COL_DISCIPLINE_DISCIPLINEID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineModel;
    }

    @Override
    public DisciplineModel getDisciplineByName(String disciplineName) {
        DisciplineModel disciplineModel = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from discipline where name  = ? and active = 1");
            preparedStatement.setString(1, disciplineName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                disciplineModel = new DisciplineModel();
                disciplineModel.setDisciplineName(resultSet.getString(Constants.COL_DISCIPLINE_NAME));
                disciplineModel.setDisciplineId(resultSet.getInt(Constants.COL_DISCIPLINE_DISCIPLINEID));
                disciplineModel.setRemarks(resultSet.getString(Constants.COL_DISCIPLINE_REMARKS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplineModel;
    }

    @Override
    public ResultSet getAllDisciplineResultSet() {
        ResultSet rst = null;
        try {
            String sql = "select discipline_id as 'Discipline ID',name as 'Discipline',remarks as 'Remarks',created_by as 'Created By',created_date as "
                    + "'Created Date',modified_by as 'Modified By',modified_date as 'Modified Date' from discipline where active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }
}