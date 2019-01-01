/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.models;

/**
 *
 * @author Akash
 */
public class PaperModel extends Model{
    private Integer paperId;
    private PaperDescriptionModel paperDescriptionModel;
    private QuestionModel questionModel;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public PaperDescriptionModel getPaperDescriptionModel() {
        return paperDescriptionModel;
    }

    public void setPaperDescriptionModel(PaperDescriptionModel paperDescriptionModel) {
        this.paperDescriptionModel = paperDescriptionModel;
    }

    public QuestionModel getQuestionModel() {
        return questionModel;
    }

    public void setQuestionModel(QuestionModel questionModel) {
        this.questionModel = questionModel;
    }
}
