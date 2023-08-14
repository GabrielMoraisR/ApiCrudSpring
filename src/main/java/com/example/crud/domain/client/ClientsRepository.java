package com.example.crud.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, String> {}