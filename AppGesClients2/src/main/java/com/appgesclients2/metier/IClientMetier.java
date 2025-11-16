package com.appgesclients2.metier;

import java.util.List;
import com.appgesclients2.model.Client;


public interface IClientMetier {
	
    void addClient(Client c);
    
    void updateClient(Client c);
    
    void removeClient(Long id);
    
    
    
    Client getClient(Long id);
    
    
    List<Client> getAllClients();

	List<Client> searchClientsByName(String keyword);
}
