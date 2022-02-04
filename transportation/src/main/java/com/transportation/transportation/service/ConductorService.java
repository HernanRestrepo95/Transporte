package com.transportation.transportation.service;

import java.util.List;

import com.transportation.transportation.entity.Conductor;
import com.transportation.transportation.entity.TipoIdentificacion;


public interface ConductorService {
    public List<Conductor> listAllConductors();
    public Conductor getConductor(Long id);
    public Conductor createConductor(Conductor conductorDTO);
    public Conductor updateConductor(Conductor conductorDTO);
    public boolean deleteConductor(Long id);
    public List<Conductor> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion tipoIdentificacion, int numeroDocumento);
}
