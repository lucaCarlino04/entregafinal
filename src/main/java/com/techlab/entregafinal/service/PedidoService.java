package com.techlab.entregafinal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entregafinal.model.Pedido;
import com.techlab.entregafinal.model.PedidoDetalle;
import com.techlab.entregafinal.model.Producto;
import com.techlab.entregafinal.repository.PedidoRepository;
import com.techlab.entregafinal.repository.ProductoRepository;



@Service
public class PedidoService implements IService<Pedido>{
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;

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
        
        Double totalPedido = 0.0;
        
        for (PedidoDetalle detalle : cosa.getDetalles()) { 
            
            // 1. OBTENER el ID del Producto que el cliente envió
            // Asumimos que al menos el ID del producto viene en el JSON
            Long productoId = detalle.getProducto().getId(); 
            
            // 2. BUSCAR el Producto REAL y COMPLETO de la BD (evitando LAZY y fraude)
            Producto productoReal = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto con ID " + productoId + " no existe."));
            
            // 3. FIJAR la relación completa para la persistencia
            detalle.setProducto(productoReal); // Establecer la entidad completa

            // 4. Calcular y Fijar los Precios
            Double precioUnitario = productoReal.getPrecio();
            
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setSubtotal(precioUnitario * detalle.getCantidad());
            
            totalPedido += detalle.getSubtotal();
        }
        
        // Asignar el total y guardar
        cosa.setTotal(totalPedido); 
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
