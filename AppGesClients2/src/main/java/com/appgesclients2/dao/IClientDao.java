package com.appgesclients2.dao;



import java.util.List;
import com.appgesclients2.model.Client;

public interface IClientDao {
	
    void save(Client c);
    
    
    void update(Client c);
    
    
    void delete(Long id);
    
    Client findById(Long id);
    
    List<Client> findAll();
    
    
    List<Client> searchClientsByName(String keyword);


}
