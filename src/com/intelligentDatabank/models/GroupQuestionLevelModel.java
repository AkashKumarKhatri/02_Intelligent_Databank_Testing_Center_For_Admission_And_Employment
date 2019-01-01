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
public class GroupQuestionLevelModel {
    private Integer groupQuestionLevelId;
    private GroupModel groupModel;
    private QuestionLevelModel levelModel;

    public Integer getGroupQuestionLevelId() {
        return groupQuestionLevelId;
    }

    public void setGroupQuestionLevelId(Integer groupQuestionLevelId) {
        this.groupQuestionLevelId = groupQuestionLevelId;
    }

    public GroupModel getGroupModel() {
        return groupModel;
    }

    public void setGroupModel(GroupModel groupModel) {
        this.groupModel = groupModel;
    }

    public QuestionLevelModel getLevelModel() {
        return levelModel;
    }

    public void setLevelModel(QuestionLevelModel levelModel) {
        this.levelModel = levelModel;
    }
}
