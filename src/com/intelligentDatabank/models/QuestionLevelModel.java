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
public class QuestionLevelModel extends Model{
    private Integer questionLevelId;
    private GroupModel groupModel;
    private String questionLevel;
    private String remarks;

    public Integer getQuestionLevelId() {
        return questionLevelId;
    }

    public void setQuestionLevelId(Integer questionLevelId) {
        this.questionLevelId = questionLevelId;
    }

    public GroupModel getGroupModel() {
        return groupModel;
    }

    public void setGroupModel(GroupModel groupModel) {
        this.groupModel = groupModel;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
