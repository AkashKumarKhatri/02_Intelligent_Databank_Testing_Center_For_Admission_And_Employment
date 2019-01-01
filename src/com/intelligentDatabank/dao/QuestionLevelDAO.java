/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.QuestionLevelModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface QuestionLevelDAO {
    public List<QuestionLevelModel> getAllQuestionLevel();
    public Integer addQuestionLevel(QuestionLevelModel questionLevelModel);
    public Integer updateQuestionLevel(QuestionLevelModel questionLevelModel);
    public Integer deleteQuestionLevel(QuestionLevelModel questionLevelModel);
    public QuestionLevelModel getQuestioLevelWithId(Integer questionLevelId);
    public QuestionLevelModel getQuestioLevelIdWithName(String questionLevelName);
    public ResultSet getAllQuestionLevelResultSet();
}
