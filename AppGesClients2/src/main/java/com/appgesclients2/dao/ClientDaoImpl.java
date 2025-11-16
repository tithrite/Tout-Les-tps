package com.appgesclients2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.appgesclients2.model.Client;
import com.appgesclients2.util.DBConnection;

public class ClientDaoImpl implements IClientDao {

    @Override
    public void save(Client c) {
        String sql = "INSERT INTO clients(nom, prenom, age) VALUES(?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    c.setId(id);
                    System.out.println("Inserted client ID: " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client c) {
        String sql = "UPDATE clients SET nom=?, prenom=?, age=? WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setInt(3, c.getAge());
            ps.setLong(4, c.getId());

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM clients WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Rows deleted: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(Long id) {
        Client client = null;
        String sql = "SELECT * FROM clients WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setAge(rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setAge(rs.getInt("age"));
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Total clients fetched: " + clients.size());
        return clients;
    }

  
    
    @Override
    public List<Client> searchClientsByName(String keyword) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE nom LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAge(rs.getInt("age"));
                clients.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }
}
