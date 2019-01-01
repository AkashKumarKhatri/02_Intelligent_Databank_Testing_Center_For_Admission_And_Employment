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
public class GroupModel extends Model{
    private Integer groupId;
    private DisciplineModel discilineModel;
    private String groupName;
    private String remarks;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public DisciplineModel getDiscilineModel() {
        return discilineModel;
    }

    public void setDiscilineModel(DisciplineModel discilineModel) {
        this.discilineModel = discilineModel;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
