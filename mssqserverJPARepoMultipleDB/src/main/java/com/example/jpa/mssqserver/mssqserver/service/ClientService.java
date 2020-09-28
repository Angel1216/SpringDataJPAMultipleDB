package com.example.jpa.mssqserver.mssqserver.service;

import java.util.Optional;

import com.example.jpa.mssqserver.mssqserver.entity.clients.Clients;

public interface ClientService {
	
	Optional<Clients> clientValidation(Integer customer);

}
