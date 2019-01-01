/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.AnswerModel;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface AnswerDAO {
  public List<AnswerModel> getAllAnswer();
  public Integer addAnswer(AnswerModel answerModel);
  public Integer updateAnswer(AnswerModel answerModel);
  public Integer deleteAnswer(AnswerModel answerModel);
  public AnswerModel getAnswerWithId(Integer answerId);
}
