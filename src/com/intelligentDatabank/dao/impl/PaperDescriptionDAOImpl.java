/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelligentDatabank.dao.impl;

import com.intelligentDatabank.models.PaperDescriptionModel;
import java.sql.ResultSet;
import java.util.List;
import com.intelligentDatabank.dao.PaperDescriptionDAO;
import com.intelligentDatabank.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Akash
 */
public class PaperDescriptionDAOImpl implements PaperDescriptionDAO {

    private Connection con = DBConnection.getConnection();
    
    @Override
    public List<PaperDescriptionModel> getAllPaperDescription() {
        List<PaperDescriptionModel> descriptionModels = new ArrayList<>();
        PaperDescriptionModel descriptionModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Select * from description where active = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                descriptionModel = new PaperDescriptionModel();
                descriptionModel.setPaperDescriptionId(resultSet.getInt("paper_description_id"));
                descriptionModel.setRemarks(resultSet.getString("remarks"));
                descriptionModel.setPaperDescription(resultSet.getString("description"));
                descriptionModels.add(descriptionModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descriptionModels;
    }

    @Override
    public Integer addPaperDescription(PaperDescriptionModel descriptionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updatePaperDescription(PaperDescriptionModel descriptionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deletePaperDescription(PaperDescriptionModel descriptionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaperDescriptionModel getPaperDescriptionWithId(Integer paperDescriptionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaperDescriptionModel getPaperDescriptionIdWithName(String paperDescriptionName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllPaperDescriptionResultSet() {
        ResultSet rst = null;
        try {
            String sql = "select pd.paper_description_id as 'DESCRIPTION ID',pd.description as 'PAPER DESCRIPTION',pd.paper_year"
                    + " AS 'YEAR',ql.name AS 'QUESTION LEVEL',g.name AS 'GROUP',d.name as 'DISCIPLINE',pd.remarks as 'Remarks',"
                    + "pd.created_by as 'Created By',pd.created_date as 'Created Date',pd.modified_by as 'Modified By',"
                    + "pd.modified_date as 'Modified Date' from paper_description pd inner join question_level ql ON "
                    + "pd.paper_description_id = ql.question_level_id inner join groups g ON ql.question_level_id = g.group_id inner "
                    + "join discipline d ON g.group_id = d.discipline_id where pd.active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }
    
}
