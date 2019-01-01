/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.GroupQuestionLevelModel;

/**
 *
 * @author IQBAL
 */
public interface GroupQuestionLevelDAO {
    public Integer addGroupQuestionLevel(GroupQuestionLevelModel groupQuestionLevelModel);
    public Integer updateGroupQuestionLevel(GroupQuestionLevelModel groupQuestionLevelModel);
    
}
