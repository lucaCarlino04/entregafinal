package com.techlab.entregafinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entregafinal.model.Producto;
import com.techlab.entregafinal.repository.ProductoRepository;

@Service
public class ProductoService implements IService<Producto>{
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);    
    }

    @Override
    public Producto guardar(Producto cosa) {
        return productoRepository.save(cosa);
    }

    @Override
    public Producto actualizar(Long id, Producto cosa) {
        cosa.setId(id);
        return productoRepository.save(cosa);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
    
}
