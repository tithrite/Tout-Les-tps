package com.appgesclients2.metier;



import java.util.List;
import com.appgesclients2.dao.IClientDao;
import com.appgesclients2.model.Client;

public class ClientMetierImpl implements IClientMetier {

    private IClientDao clientDao; 

    public void setClientDao(IClientDao clientDao) {
        this.clientDao = clientDao;
    }
    

    @Override
    public void addClient(Client c) {
    	
        
         clientDao.save(c);
         
    }

    @Override
    public void updateClient(Client c) {

    	clientDao.update(c);
    }

    
    
    @Override
    public void removeClient(Long id) {
        clientDao.delete(id);
    }
    
    

    @Override
    public Client getClient(Long id) {
    	
        return clientDao.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
    	
    	
        return clientDao.findAll();
    }
    
    
    @Override
    public List<Client> searchClientsByName(String keyword) {
        return clientDao.searchClientsByName(keyword);
    }

}
