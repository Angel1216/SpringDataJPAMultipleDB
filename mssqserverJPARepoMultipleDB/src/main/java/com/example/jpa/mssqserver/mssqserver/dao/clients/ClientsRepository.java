package com.example.jpa.mssqserver.mssqserver.dao.clients;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.mssqserver.mssqserver.entity.clients.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

}
