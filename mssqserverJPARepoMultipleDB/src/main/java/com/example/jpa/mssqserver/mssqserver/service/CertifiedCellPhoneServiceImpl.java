package com.example.jpa.mssqserver.mssqserver.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.mssqserver.mssqserver.dao.certified.CertifiedCellPhoneRepository;

@Service
public class CertifiedCellPhoneServiceImpl implements CertifiedCellPhoneService {
	
	@Autowired
	private CertifiedCellPhoneRepository certifiedCellPhoneRepository;
	
	@Override
	public Map<String, String> certifiedCellPhoneValidation(String customer) {
		return certifiedCellPhoneRepository.certifiedCellPhoneValidation(customer, "");
	}

}
