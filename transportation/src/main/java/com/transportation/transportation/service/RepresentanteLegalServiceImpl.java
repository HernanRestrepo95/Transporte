package com.transportation.transportation.service;

import com.transportation.transportation.repository.RepresentanteLegalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.transportation.transportation.entity.RepresentanteLegal;
import com.transportation.transportation.entity.TipoIdentificacion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepresentanteLegalServiceImpl implements RepresentanteLegalService {

    private final RepresentanteLegalRepository representanteLegalRepository;

    @Override
    public List<RepresentanteLegal> listAllRepresentanteLegals() {
        return representanteLegalRepository.findAll();
    }

    @Override
    public RepresentanteLegal getRepresentanteLegal(Long id) {
        return representanteLegalRepository.findById(id).orElse(null);
    }

    @Override
    public RepresentanteLegal createRepresentanteLegal(RepresentanteLegal representanteLegal) {
        return representanteLegalRepository.save(representanteLegal);
    }

    @Override
    public RepresentanteLegal updateRepresentanteLegal(RepresentanteLegal representanteLegal) {
        RepresentanteLegal representanteLegalDB = getRepresentanteLegal(representanteLegal.getId());
        if (null == representanteLegalDB) {
            return null;
        }

        representanteLegalDB.setCiudad(representanteLegal.getCiudad());
        representanteLegalDB.setDepartamento(representanteLegal.getDepartamento());
        representanteLegalDB.setDireccion(representanteLegal.getDireccion());
        representanteLegalDB.setNombre(representanteLegal.getNombre());
        representanteLegalDB.setNumeroDocumento(representanteLegal.getNumeroDocumento());
        representanteLegalDB.setPais(representanteLegal.getPais());
        representanteLegalDB.setTelefono(representanteLegal.getTelefono());
        representanteLegalDB.setTipoIdentificacion(representanteLegal.getTipoIdentificacion());

        return representanteLegalRepository.save(representanteLegalDB);
    }

    @Override
    public boolean deleteRepresentanteLegal(Long id) {
        RepresentanteLegal representanteLegalDB = getRepresentanteLegal(id);
        if (null == representanteLegalDB) {
            return false;
        }
        representanteLegalRepository.delete(representanteLegalDB);
        
        return true;
    }

    @Override
    public List<RepresentanteLegal> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion nTipoIdentificacion, int numeroIdentificacion) {

        return representanteLegalRepository.findByTipoIdentificacionAndNumeroDocumento(nTipoIdentificacion, numeroIdentificacion);
    }
}
