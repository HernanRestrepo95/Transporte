package com.transportation.transportation.service;

import java.util.List;

import com.transportation.transportation.entity.RepresentanteLegal;
import com.transportation.transportation.entity.TipoIdentificacion;


public interface RepresentanteLegalService {
    public List<RepresentanteLegal> listAllRepresentanteLegals();
    public RepresentanteLegal getRepresentanteLegal(Long id);
    public RepresentanteLegal createRepresentanteLegal(RepresentanteLegal clienteDTO);
    public RepresentanteLegal updateRepresentanteLegal(RepresentanteLegal clienteDTO);
    public boolean deleteRepresentanteLegal(Long id);
    public List<RepresentanteLegal> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion tipoIdentificacion, int numeroDocumento);
}
