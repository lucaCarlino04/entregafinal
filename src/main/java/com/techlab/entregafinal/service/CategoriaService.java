package com.techlab.entregafinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entregafinal.model.Categoria;
import com.techlab.entregafinal.repository.CategoriaRepository;

@Service
public class CategoriaService implements IService<Categoria>{
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardar(Categoria cosa) {
        return categoriaRepository.save(cosa);
    }

    @Override
    public Categoria actualizar(Long id, Categoria cosa) {
        cosa.setId(id);
        return categoriaRepository.save(cosa);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
    
}
