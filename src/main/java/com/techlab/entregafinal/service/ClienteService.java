package com.techlab.entregafinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entregafinal.model.Cliente;
import com.techlab.entregafinal.repository.ClienteRepository;


@Service
public class ClienteService implements IService<Cliente>{
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

     @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);    
    }

    @Override
    public Cliente guardar(Cliente cosa) {
        return clienteRepository.save(cosa);
    }

    @Override
    public Cliente actualizar(Long id, Cliente cosa) {
        cosa.setId(id);
        return clienteRepository.save(cosa);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    
}
