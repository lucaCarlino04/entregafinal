package com.techlab.entregafinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entregafinal.model.Pedido;
import com.techlab.entregafinal.repository.PedidoRepository;

@Service
public class PedidoService implements IService<Pedido>{
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

     @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

     @Override
    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);    
    }

    @Override
    public Pedido guardar(Pedido cosa) {
        return pedidoRepository.save(cosa);
    }

    @Override
    public Pedido actualizar(Long id, Pedido cosa) {
        cosa.setId(id);
        return pedidoRepository.save(cosa);
    }

    @Override
    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
