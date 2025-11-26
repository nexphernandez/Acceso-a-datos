package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import com.docencia.rest.modelo.DetalleProducto;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public interface IDetalleProductoRepository {
    Optional<DetalleProducto> findByProductoId(int productoId);
    DetalleProducto save(int productoId, DetalleProducto detalle);
    boolean deleteByProductoId(int productoId);
}
