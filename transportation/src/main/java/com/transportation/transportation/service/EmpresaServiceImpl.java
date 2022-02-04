package com.transportation.transportation.service;

import com.transportation.transportation.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.transportation.transportation.entity.Empresa;
import com.transportation.transportation.entity.TipoIdentificacion;
import com.transportation.transportation.entity.Vehiculo;
import com.transportation.transportation.repository.VehiculoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<Empresa> listAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public Empresa createEmpresa(Empresa empresa) {

        List<Vehiculo> lstVehiculo = empresa.getLstVehiculo();
        for (Vehiculo vehiculo : lstVehiculo) {
            vehiculo.setEmpresa(empresa);

            vehiculoRepository.save(vehiculo);
        }

        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        Empresa empresaDB = getEmpresa(empresa.getId());
        if (null == empresaDB) {
            return null;
        }

        List<Vehiculo> lstVehiculo = empresaDB.getLstVehiculo();
        for (Vehiculo vehiculo : lstVehiculo) {
            vehiculo.setEmpresa(null);

            vehiculoRepository.save(vehiculo);
        }

        empresaDB.setCiudad(empresa.getCiudad());
        empresaDB.setDepartamento(empresa.getDepartamento());
        empresaDB.setDireccion(empresa.getDireccion());
        empresaDB.setNombre(empresa.getNombre());
        empresaDB.setNumeroDocumento(empresa.getNumeroDocumento());
        empresaDB.setPais(empresa.getPais());
        empresaDB.setTelefono(empresa.getTelefono());
        empresaDB.setTipoIdentificacion(empresa.getTipoIdentificacion());
        empresaDB.setRepresentanteLegal(empresa.getRepresentanteLegal());
        empresaDB.setLstVehiculo(empresa.getLstVehiculo());

        List<Vehiculo> lstVehiculo2 = empresaDB.getLstVehiculo();
        for (Vehiculo vehiculo : lstVehiculo2) {
            vehiculo.setEmpresa(empresaDB);

            vehiculoRepository.save(vehiculo);
        }

        return empresaRepository.save(empresaDB);
    }

    @Override
    public boolean deleteEmpresa(Long id) {
        Empresa empresaDB = getEmpresa(id);
        if (null == empresaDB) {
            return false;
        }
        empresaRepository.delete(empresaDB);

        return true;
    }

    @Override
    public List<Empresa> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion nTipoIdentificacion, int numeroIdentificacion) {

        return empresaRepository.findByTipoIdentificacionAndNumeroDocumento(nTipoIdentificacion, numeroIdentificacion);
    }
}
