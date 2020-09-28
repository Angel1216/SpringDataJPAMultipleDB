package com.example.jpa.mssqserver.mssqserver.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.mssqserver.mssqserver.entity.clients.Clients;
import com.example.jpa.mssqserver.mssqserver.service.CertifiedCellPhoneService;
import com.example.jpa.mssqserver.mssqserver.service.ClientService;

@RestController
//@RequestMapping(value = "/retrieve-db")
public class CertifiedCellPhoneController {
	
	@Autowired
	private CertifiedCellPhoneService certifiedCellPhoneService;
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping(value = "/certifiedCellPhone", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> getCertifiedCellPhone() {
		Map<String, String> responseSP = certifiedCellPhoneService.certifiedCellPhoneValidation("254656");
		return new ResponseEntity<>(responseSP, HttpStatus.OK);
	}
	
	@PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Clients>> getClient() {
		Optional<Clients> client = clientService.clientValidation(254656);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
}
