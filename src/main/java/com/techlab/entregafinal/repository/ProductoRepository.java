package com.techlab.entregafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.entregafinal.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
