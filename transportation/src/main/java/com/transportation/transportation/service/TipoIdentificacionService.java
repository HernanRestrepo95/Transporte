package com.transportation.transportation.service;

import java.util.List;

import com.transportation.transportation.entity.TipoIdentificacion;


public interface TipoIdentificacionService {
    public List<TipoIdentificacion> listAllTipoIdentificacions();
    public TipoIdentificacion getTipoIdentificacion(Long id);
    public TipoIdentificacion createTipoIdentificacion(TipoIdentificacion tipoIdentificacionDTO);
    public TipoIdentificacion updateTipoIdentificacion(TipoIdentificacion tipoIdentificacionDTO);
    public boolean deleteTipoIdentificacion(Long id);
}
