package com.example.jpa.mssqserver.mssqserver.dao.certified;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.jpa.mssqserver.mssqserver.entity.certified.CertifiedCellPhoneEntity;

@Transactional
public interface CertifiedCellPhoneRepository extends JpaRepository<CertifiedCellPhoneEntity, String> {

	@Procedure(name = "CertifiedCellPhoneValidation")
	Map<String, String> certifiedCellPhoneValidation(@Param("customer_numer") String customerNumber, @Param("Adding") String adding);
	
}
