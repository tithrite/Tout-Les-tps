package com.estn.metier;

import com.estn.dao.EmployeDao;
import com.estn.model.Employe;



public class EmployeService {

    private EmployeDao employeDao;
    

    public void setEmployeDao(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }



    public Employe getEmployeById(int id) {
    	
    	
        return employeDao.getEmployeById(id);
    }



    public double calculerPrime(Employe e) {
    	
    	
        if (e == null) return 0.0;
        
        
        return e.getExperience() * 500 + e.getSalaire();
  
    
    
    
    }
    
    
    
    
}





