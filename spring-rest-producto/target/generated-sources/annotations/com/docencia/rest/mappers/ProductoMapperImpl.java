package com.docencia.rest.mappers;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.modelo.DetalleProductoDocument;
import com.docencia.rest.modelo.ProductoEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-01T10:33:21+0000",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Autowired
    private DetalleProductoMapper detalleProductoMapper;

    @Override
    public ProductoEntity toProducto(Producto source) {
        if ( source == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setNombre( source.getNombre() );
        productoEntity.setPrecio( source.getPrecio() );
        productoEntity.setStock( source.getStock() );
        productoEntity.setId( source.getId() );

        return productoEntity;
    }

    @Override
    public Producto toProducto(ProductoEntity source) {
        if ( source == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( source.getId() );
        producto.setNombre( source.getNombre() );
        producto.setPrecio( source.getPrecio() );
        producto.setStock( source.getStock() );

        return producto;
    }

    @Override
    public Producto toDomain(ProductoEntity entity, DetalleProductoDocument detalle) {
        if ( entity == null && detalle == null ) {
            return null;
        }

        Producto producto = new Producto();

        if ( entity != null ) {
            producto.setId( entity.getId() );
            producto.setNombre( entity.getNombre() );
            producto.setPrecio( entity.getPrecio() );
            producto.setStock( entity.getStock() );
        }
        producto.setDetalleProducto( detalleProductoMapper.toDocument( detalle ) );

        return producto;
    }
}
