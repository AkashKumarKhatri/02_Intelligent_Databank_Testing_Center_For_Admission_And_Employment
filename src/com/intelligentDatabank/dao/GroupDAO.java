/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.DisciplineModel;
import com.intelligentDatabank.models.GroupModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface GroupDAO {
    public List<GroupModel> getAllGroups();
    public Integer addGroup(GroupModel groupModel);
    public Integer updateGroup(GroupModel groupModel);
    public Integer deleteGroup(GroupModel groupModel);
    public GroupModel getGroupWithId(Integer groupId);
    public GroupModel getGroupIdWithName(String groupName);
    public ResultSet getAllGroupResultSet();
    public List<GroupModel> getAllGroupsByDisciplineId(DisciplineModel disciplineModel);
}
