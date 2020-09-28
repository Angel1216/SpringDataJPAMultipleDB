package com.example.jpa.mssqserver.mssqserver.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.mssqserver.mssqserver.dao.CertifiedCellPhoneRepository;

@Service
public class CertifiedCellPhoneServiceImpl implements CertifiedCellPhoneService {
	
//	@Autowired
//	private SpRepository spRepository;
	
	@Autowired
	private CertifiedCellPhoneRepository certifiedCellPhoneRepository;
	
	
//	@Override
//	public String certifiedCellPhoneValidation(String customer) {
//		return spRepository.getQuerySp("sp_Certified_CellPhone_Validation", "20236513", "");
//	}
	
	@Override
	public String certifiedCellPhoneValidation(String customer) {
		return certifiedCellPhoneRepository.CertifiedCellPhoneValidation("20236513", "").get("cellphone");
	}

}
