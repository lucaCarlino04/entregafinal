package com.techlab.entregafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.entregafinal.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
