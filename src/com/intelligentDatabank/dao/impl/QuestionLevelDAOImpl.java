/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.dao.GroupDAO;
import com.intelligentDatabank.dao.QuestionLevelDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.GroupModel;
import com.intelligentDatabank.models.QuestionLevelModel;
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
public class QuestionLevelDAOImpl implements QuestionLevelDAO{
    Connection con = DBConnection.getConnection();
    @Override
    public List<QuestionLevelModel> getAllQuestionLevel() {
        List<QuestionLevelModel> questionLevelModels = new ArrayList<>();
        QuestionLevelModel questionLevelModel;
        GroupModel groupModel;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from question_level ql inner join "
                    + "groups g on ql.question_level_id = g.group_id where ql.active = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                questionLevelModel = new QuestionLevelModel();
                groupModel = new GroupModel();
                questionLevelModel.setQuestionLevel(resultSet.getString("ql."+Constants.COL_QUESTION_LEVEL_NAME));
                groupModel.setGroupName(resultSet.getString("g."+Constants.COL_GROUP_NAME));
                questionLevelModel.setGroupModel(groupModel);
                questionLevelModel.setRemarks(resultSet.getString(Constants.COL_QUESTION_LEVEL_REMARKS));
                questionLevelModel.setQuestionLevelId(resultSet.getInt(Constants.COL_QUESTION_LEVEL_LEVELID));
                questionLevelModels.add(questionLevelModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionLevelModels;
    }

    @Override
    public Integer addQuestionLevel(QuestionLevelModel questionLevelModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into question_level (name, group_id, remarks) values(?,?,?)");
            preparedStatement.setString(1, questionLevelModel.getQuestionLevel());
            preparedStatement.setInt(2, questionLevelModel.getGroupModel().getGroupId());
            preparedStatement.setString(3, questionLevelModel.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateQuestionLevel(QuestionLevelModel questionLevelModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update question_level set name = ? ,group_id = ?, remarks = ? where question_level_id = ? ");
            preparedStatement.setString(1, questionLevelModel.getQuestionLevel());
            preparedStatement.setInt(2, questionLevelModel.getGroupModel().getGroupId());
            preparedStatement.setString(3, questionLevelModel.getRemarks());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteQuestionLevel(QuestionLevelModel questionLevelModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update question_level set name = ?, group_id = ?, remarks = ? where question_livel_id=?");
            preparedStatement.setInt(1, questionLevelModel.getQuestionLevelId());
            row=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public QuestionLevelModel getQuestioLevelWithId(Integer questionLevelId) {
        QuestionLevelModel questionLevelModel = null;
        GroupDAO groupDAO = new GroupDAOImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from question_level where question_level_id  = ? and active = 1");
            preparedStatement.setInt(1, questionLevelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                questionLevelModel = new QuestionLevelModel();
                questionLevelModel.setQuestionLevelId(resultSet.getInt(Constants.COL_QUESTION_LEVEL_LEVELID));
                questionLevelModel.setQuestionLevel(resultSet.getString(Constants.COL_QUESTION_LEVEL_NAME));
                questionLevelModel.setRemarks(resultSet.getString(Constants.COL_QUESTION_LEVEL_REMARKS));
                questionLevelModel.setGroupModel(groupDAO.getGroupWithId(resultSet.getInt(Constants.COL_GROUP_GROUPID)));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return questionLevelModel;
    }

    @Override
    public QuestionLevelModel getQuestioLevelIdWithName(String questionLevelName) {
        QuestionLevelModel questionLevelModel = null;
        GroupDAO groupDAO = new GroupDAOImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("select * from question_level where name  = ? ");
            preparedStatement.setString(1, questionLevelName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                questionLevelModel = new QuestionLevelModel();
                questionLevelModel.setQuestionLevelId(resultSet.getInt(Constants.COL_QUESTION_LEVEL_LEVELID));
                questionLevelModel.setQuestionLevel(resultSet.getString(Constants.COL_QUESTION_LEVEL_NAME));
                questionLevelModel.setRemarks(resultSet.getString(Constants.COL_QUESTION_LEVEL_REMARKS));
                questionLevelModel.setGroupModel(groupDAO.getGroupWithId(resultSet.getInt(Constants.COL_GROUP_REMARKS)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionLevelModel;
    }

    @Override
    public ResultSet getAllQuestionLevelResultSet() {
        ResultSet rst = null;
        try {
            String sql = "select ql.question_level_id as 'Level ID',ql.name as 'Question Level',g.name as 'Group',"
                    + "d.name as 'Discipline', ql.remarks as 'Remarks',ql.created_by as 'Created By',ql.created_date as "
                    + "'Created Date',ql.modified_by as 'Modified By',ql.modified_date as 'Modified Date' from "
                    + "question_level ql inner join groups g on ql.group_id = g.group_id inner join discipline d on "
                    + "d.discipline_id = g.discipline_id where ql.active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }
    
}
