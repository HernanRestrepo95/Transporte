package com.transportation.transportation.service;

import com.transportation.transportation.repository.TipoIdentificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.transportation.transportation.entity.TipoIdentificacion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoIdentificacionServiceImpl  implements TipoIdentificacionService{


    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacion> listAllTipoIdentificacions() {
        return tipoIdentificacionRepository.findAll();
    }

    @Override
    public TipoIdentificacion getTipoIdentificacion(Long id) {
        return tipoIdentificacionRepository.findById(id).orElse(null);
    }

    @Override
    public TipoIdentificacion createTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionRepository.save(tipoIdentificacion);
    }

    @Override
    public TipoIdentificacion updateTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
    	TipoIdentificacion tipoIdentificacionDB = getTipoIdentificacion(tipoIdentificacion.getId());
        if (null == tipoIdentificacionDB){
            return null;
        }
        
        tipoIdentificacionDB.setNombre(tipoIdentificacion.getNombre());
        
        return tipoIdentificacionRepository.save(tipoIdentificacionDB);
    }

    @Override
    public boolean deleteTipoIdentificacion(Long id) {
    	TipoIdentificacion tipoIdentificacionDB = getTipoIdentificacion(id);
        if (null == tipoIdentificacionDB){
            return false;
        }
        tipoIdentificacionRepository.delete(tipoIdentificacionDB);
                
        return true;
    }
}
