package com.estn.dao;

import com.estn.model.Employe;


import java.sql.*;

public class EmployeDaoImpl implements EmployeDao {

    @Override
    public Employe getEmployeById(int id) {
        String sql = "SELECT * FROM employe WHERE id = ?";

        try (
            Connection connection = DBConnection.getConnection();      
            PreparedStatement ps = connection.prepareStatement(sql)    
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
            	
                return new Employe(
                		
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getDate("date_embauche").toLocalDate(),
                    
                    rs.getDouble("salaire")
                );
                
            }

            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
