package com.example.jpa.mssqserver.mssqserver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.mssqserver.mssqserver.service.CertifiedCellPhoneService;

@RestController
public class CertifiedCellPhoneController {
	
	@Autowired
	private CertifiedCellPhoneService certifiedCellPhoneService;
	
	@PostMapping(value = "/certifiedCellPhone", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCertifiedCellPhone() {
		String responseSP = certifiedCellPhoneService.certifiedCellPhoneValidation("20236513");
		return new ResponseEntity<>(responseSP, HttpStatus.OK);
	}

}
