package com.example.jpa.mssqserver.mssqserver.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class SpRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public String getQuerySp(String nameSp, String customer, String adding) {
		
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(nameSp);
		
		storedProcedure.registerStoredProcedureParameter("customer_numer", String.class, ParameterMode.IN);
		storedProcedure.setParameter("customer_numer", customer);
		
		storedProcedure.registerStoredProcedureParameter("Adding", String.class, ParameterMode.IN);
		storedProcedure.setParameter("Adding", customer);
		
		storedProcedure.registerStoredProcedureParameter("cellphone", String.class, ParameterMode.OUT);
	
		
		storedProcedure.registerStoredProcedureParameter("carrier", String.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("certification_type", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("rejected_count", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("blocked", String.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("attemps", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("certification_way", String.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("DB_Status_Code", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("DB_Status_Code_Description", String.class, ParameterMode.OUT);
		
		storedProcedure.execute();
		
		return (String) storedProcedure.getOutputParameterValue("cellphone"); 
	}
}
