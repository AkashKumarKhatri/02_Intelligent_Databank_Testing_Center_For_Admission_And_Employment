/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.DisciplineModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface DisciplineDAO {
    public Integer addDiscipline(DisciplineModel discilineModel);
    public Integer updateDiscipline(DisciplineModel discilineModel);
    public Integer deleteDiscipline(DisciplineModel discilineModel);
    public List<DisciplineModel> getAllDisciplines();
    public DisciplineModel getDisciplineWithId(Integer disciplineId);
    public DisciplineModel getDisciplineByName(String disciplineName);
    public ResultSet getAllDisciplineResultSet();
}
