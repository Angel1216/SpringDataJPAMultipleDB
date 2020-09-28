package com.example.jpa.mssqserver.mssqserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.mssqserver.mssqserver.dao.SpRepository;

@Service
public class CertifiedCellPhoneServiceImpl implements CertifiedCellPhoneService {
	
	@Autowired
	private SpRepository spRepository;
	
	@Override
	public String certifiedCellPhoneValidation(String customer) {
		return spRepository.getQuerySp("sp_Certified_CellPhone_Validation", "20236513", "");
	}

}
