package com.transportation.transportation.service;

import com.transportation.transportation.repository.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.transportation.transportation.entity.Conductor;
import com.transportation.transportation.entity.TipoIdentificacion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConductorServiceImpl implements ConductorService {

    private final ConductorRepository conductorRepository;

    @Override
    public List<Conductor> listAllConductors() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor getConductor(Long id) {
        return conductorRepository.findById(id).orElse(null);
    }

    @Override
    public Conductor createConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public Conductor updateConductor(Conductor conductor) {
        Conductor conductorDB = getConductor(conductor.getId());
        if (null == conductorDB) {
            return null;
        }

        conductorDB.setCiudad(conductor.getCiudad());
        conductorDB.setDepartamento(conductor.getDepartamento());
        conductorDB.setDireccion(conductor.getDireccion());
        conductorDB.setNombre(conductor.getNombre());
        conductorDB.setNumeroDocumento(conductor.getNumeroDocumento());
        conductorDB.setPais(conductor.getPais());
        conductorDB.setTelefono(conductor.getTelefono());
        conductorDB.setTipoIdentificacion(conductor.getTipoIdentificacion());
        conductorDB.setLstVehiculo(conductor.getLstVehiculo());

        return conductorRepository.save(conductorDB);
    }

    @Override
    public boolean deleteConductor(Long id) {
        Conductor conductorDB = getConductor(id);
        if (null == conductorDB) {
            return false;
        }
        conductorRepository.delete(conductorDB);
        
        return true;
    }

    @Override
    public List<Conductor> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion nTipoIdentificacion, int numeroIdentificacion) {

        return conductorRepository.findByTipoIdentificacionAndNumeroDocumento(nTipoIdentificacion, numeroIdentificacion);
    }
}
