/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.models;

import java.sql.Timestamp;

/**
 *
 * @author Akash
 */
public class QuestionModel extends Model{
    private Integer questionId;
    private PaperDescriptionModel paperDescriptionModel;
    private String question;
    private Timestamp entryDate;
    private String remarks;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public PaperDescriptionModel getPaperDescriptionModel() {
        return paperDescriptionModel;
    }

    public void setPaperDescriptionModel(PaperDescriptionModel paperDescriptionModel) {
        this.paperDescriptionModel = paperDescriptionModel;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
