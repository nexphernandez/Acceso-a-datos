package com.docencia.rest.mappers;

import com.docencia.rest.domain.DetalleProducto;
import com.docencia.rest.modelo.DetalleProductoDocument;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-01T10:33:21+0000",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class DetalleProductoMapperImpl implements DetalleProductoMapper {

    @Override
    public DetalleProductoDocument toDocument(DetalleProducto source) {
        if ( source == null ) {
            return null;
        }

        DetalleProductoDocument detalleProductoDocument = new DetalleProductoDocument();

        detalleProductoDocument.setId( source.getId() );
        detalleProductoDocument.setProductoId( source.getProductoId() );
        detalleProductoDocument.setDescripcionLarga( source.getDescripcionLarga() );
        Map<String, String> map = source.getEspecificacionesTecnicas();
        if ( map != null ) {
            detalleProductoDocument.setEspecificacionesTecnicas( new LinkedHashMap<String, String>( map ) );
        }
        List<String> list = source.getTags();
        if ( list != null ) {
            detalleProductoDocument.setTags( new ArrayList<String>( list ) );
        }

        return detalleProductoDocument;
    }

    @Override
    public DetalleProducto toDocument(DetalleProductoDocument source) {
        if ( source == null ) {
            return null;
        }

        DetalleProducto detalleProducto = new DetalleProducto();

        detalleProducto.setId( source.getId() );
        detalleProducto.setProductoId( source.getProductoId() );
        detalleProducto.setDescripcionLarga( source.getDescripcionLarga() );
        Map<String, String> map = source.getEspecificacionesTecnicas();
        if ( map != null ) {
            detalleProducto.setEspecificacionesTecnicas( new LinkedHashMap<String, String>( map ) );
        }
        List<String> list = source.getTags();
        if ( list != null ) {
            detalleProducto.setTags( new ArrayList<String>( list ) );
        }

        return detalleProducto;
    }
}
