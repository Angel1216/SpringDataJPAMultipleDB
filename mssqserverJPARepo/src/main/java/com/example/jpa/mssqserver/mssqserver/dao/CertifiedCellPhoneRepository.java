package com.example.jpa.mssqserver.mssqserver.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CertifiedCellPhoneRepository extends JpaRepository<CertifiedCellPhoneEntity, String> {

	@Procedure(name = "CertifiedCellPhoneValidation")
	Map<String, String> CertifiedCellPhoneValidation(@Param("customer_numer") String customerNumber, @Param("Adding") String adding);
	
}
