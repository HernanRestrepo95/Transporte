package com.transportation.transportation.service;

import com.transportation.transportation.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.transportation.transportation.entity.Vehiculo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl  implements VehiculoService{


    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> listAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo getVehiculo(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
    	Vehiculo vehiculoDB = getVehiculo(vehiculo.getId());
        if (null == vehiculoDB){
            return null;
        }
        
        vehiculoDB.setChasis(vehiculo.getChasis());
        vehiculoDB.setEmpresa(vehiculo.getEmpresa());
        vehiculoDB.setFechaMatricula(vehiculo.getFechaMatricula());
        vehiculoDB.setLinea(vehiculo.getLinea());
        vehiculoDB.setLstConductor(vehiculo.getLstConductor());
        vehiculoDB.setMarca(vehiculo.getMarca());
        vehiculoDB.setModelo(vehiculo.getModelo());
        vehiculoDB.setMotor(vehiculo.getMotor());
        vehiculoDB.setPasajerosPie(vehiculo.getPasajerosPie());
        vehiculoDB.setPasajerosSentados(vehiculo.getPasajerosSentados());
        vehiculoDB.setPesoBruto(vehiculo.getPesoBruto());
        vehiculoDB.setPesoSeco(vehiculo.getPesoSeco());
        vehiculoDB.setPlaca(vehiculo.getPlaca());
        vehiculoDB.setPuertas(vehiculo.getPuertas());
        
        return vehiculoRepository.save(vehiculoDB);
    }

    @Override
    public boolean deleteVehiculo(Long id) {
    	Vehiculo vehiculoDB = getVehiculo(id);
        if (null == vehiculoDB){
            return false;
        }
        vehiculoRepository.delete(vehiculoDB);
        
        return true;
    }
}
