/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.dao.AnswerDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import com.intelligentDatabank.models.AnswerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Akash
 */
public class AnswerDAOImpl implements AnswerDAO {

    private Connection con = DBConnection.getConnection();
    
    @Override
    public List<AnswerModel> getAllAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addAnswer(AnswerModel answerModel) {
        Integer row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into answers (answer,question_id) values (?,?)");
            preparedStatement.setString(1, answerModel.getAnswer());
            preparedStatement.setInt(2, answerModel.getQuestionModel().getQuestionId());
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public Integer updateAnswer(AnswerModel answerModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteAnswer(AnswerModel answerModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnswerModel getAnswerWithId(Integer answerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
