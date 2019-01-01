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
public class PaperDescriptionModel extends Model {
    private Integer paperDescriptionId;
    private QuestionLevelModel questionLevelModel;
    private String paperDescription;
    private String paperYear;
    private String remarks;

    public  String getPaperYear() {
        return paperYear;
    }
    
    public void setPaperYear(String paperYear) {
        this.paperYear = paperYear;
    }
    
    public Integer getPaperDescriptionId() {
        return paperDescriptionId;
    }

    public void setPaperDescriptionId(Integer paperDescriptionId) {
        this.paperDescriptionId = paperDescriptionId;
    }

    public QuestionLevelModel getQuestionLevelModel() {
        return questionLevelModel;
    }

    public void setQuestionLevelModel(QuestionLevelModel questionLevelModel) {
        this.questionLevelModel = questionLevelModel;
    }

    public String getPaperDescription() {
        return paperDescription;
    }

    public void setPaperDescription(String paperDescription) {
        this.paperDescription = paperDescription;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
