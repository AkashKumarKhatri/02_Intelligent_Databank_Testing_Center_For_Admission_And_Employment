/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.dao.QuestionDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.QuestionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akash
 */
public class QuestionDAOImpl implements QuestionDAO {

    private Connection con = DBConnection.getConnection();
    
    @Override
    public List<QuestionModel> getAllQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addQuestion(QuestionModel questionModel) {
        Integer row = 0;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("insert into questions (question) values (?)");
            preparedStatement.setString(1, questionModel.getQuestion());
            row = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateQuestion(QuestionModel questionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteQuestion(QuestionModel questionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionModel getQuestionWithId(Integer questionId) {
        QuestionModel questionModel = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("select * from questions where question_id = ? and active = 1");
            preparedStatement.setInt(1, questionId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                questionModel = new QuestionModel();
                questionModel.setQuestionId(rs.getInt("question_id"));
                questionModel.setQuestion(rs.getString("question"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionModel;
    }
    
    @Override
    public QuestionModel getQuestionIdByQuestion(String question) {
        QuestionModel questionModel = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("select * from questions where question = ? and active = 1");
            preparedStatement.setString(1, question);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                questionModel = new QuestionModel();
                questionModel.setQuestionId(rs.getInt("question_id"));
                questionModel.setQuestion(rs.getString("question"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionModel;
    }
    
}
