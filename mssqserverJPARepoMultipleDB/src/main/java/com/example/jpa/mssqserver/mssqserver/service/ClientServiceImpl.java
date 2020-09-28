package com.example.jpa.mssqserver.mssqserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.mssqserver.mssqserver.dao.clients.ClientsRepository;
import com.example.jpa.mssqserver.mssqserver.entity.clients.Clients;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientsRepository clientsRepository;
	
	@Override
	public Optional<Clients> clientValidation(Integer customer) {
		return clientsRepository.findById(customer);
	}

}
