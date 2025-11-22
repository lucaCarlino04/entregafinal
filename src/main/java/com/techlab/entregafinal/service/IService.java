package com.techlab.entregafinal.service;

import java.util.List;
import java.util.Optional;

public interface IService<Cosa> {
    List<Cosa> listar();
    Optional<Cosa> obtenerPorId(Long id);
    Cosa guardar(Cosa cosa);
    Cosa actualizar(Long id, Cosa cosa);
    void eliminar(Long id);
}
