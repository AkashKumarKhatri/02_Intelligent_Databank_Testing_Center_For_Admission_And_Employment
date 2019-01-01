/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao;

import com.intelligentDatabank.models.PaperDescriptionModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface PaperDescriptionDAO {
    public List<PaperDescriptionModel> getAllPaperDescription();
    public Integer addPaperDescription(PaperDescriptionModel descriptionModel);
    public Integer updatePaperDescription(PaperDescriptionModel descriptionModel);
    public Integer deletePaperDescription(PaperDescriptionModel descriptionModel);
    public PaperDescriptionModel getPaperDescriptionWithId(Integer paperDescriptionId);
    public PaperDescriptionModel getPaperDescriptionIdWithName(String paperDescriptionName);
    public ResultSet getAllPaperDescriptionResultSet();
}
