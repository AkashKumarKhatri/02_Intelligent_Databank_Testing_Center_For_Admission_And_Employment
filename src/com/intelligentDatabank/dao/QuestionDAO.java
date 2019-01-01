/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.QuestionModel;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface QuestionDAO {
    public List<QuestionModel> getAllQuestions();
    public Integer addQuestion(QuestionModel questionModel);
    public Integer updateQuestion(QuestionModel questionModel);
    public Integer deleteQuestion(QuestionModel questionModel);
    public QuestionModel getQuestionWithId(Integer questionId);
    public QuestionModel getQuestionIdByQuestion(String question);
}
