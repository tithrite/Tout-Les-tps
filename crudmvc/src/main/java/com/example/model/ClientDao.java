package com.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    // Ajouter un client
    public void ajouter(Client c) throws SQLException {
    	
    	
        String sql = "INSERT INTO clients (nom, prenom, age) VALUES (?, ?, ?)";
        
        
        
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());
            ps.executeUpdate();
        }
    }

    // Lister tous les clients
    public List<Client> lister() throws SQLException {
    	
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM clients ORDER BY id DESC";
        try (Connection con = DBConnection.getConnection(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age")));
            }
        }
        return list;
    }

    // Chercher client par id
    public Client chercher(int id) throws SQLException {
    	
    	
        String sql = "SELECT * FROM clients WHERE id = ?";
        
        
        try (Connection con = DBConnection.getConnection(); 
            
        		PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"));
                }
            }
        }
        return null;
    }

    // Modifier client
    public void modifier(Client c) throws SQLException {
    	
    	
        String sql = "UPDATE clients SET nom=?, prenom=?, age=? WHERE id=?";
        
        
        try (Connection con = DBConnection.getConnection(); 
        		
        		
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        }
    }

    // Supprimer client
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM clients WHERE id=?";
        try (Connection con = DBConnection.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    
 // Rechercher clients par nom
    public List<Client> rechercherParNom(String nom) throws SQLException {
    	
    	
        List<Client> list = new ArrayList<>();
        
        
        String sql = "SELECT * FROM clients WHERE nom LIKE ? ORDER BY id DESC";
        
        
        try (Connection con = DBConnection.getConnection();
            
        		PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nom + "%");
            try (ResultSet rs = ps.executeQuery()) {
            	
            	
                while (rs.next()) {
                    list.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age")));
                
                
                }
            }
        }
        
        
        return list;
   
    }
    
    

}
