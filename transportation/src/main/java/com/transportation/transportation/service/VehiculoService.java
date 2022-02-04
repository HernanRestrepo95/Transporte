package com.transportation.transportation.service;

import java.util.List;

import com.transportation.transportation.entity.Vehiculo;


public interface VehiculoService {
    public List<Vehiculo> listAllVehiculos();
    public Vehiculo getVehiculo(Long id);
    public Vehiculo createVehiculo(Vehiculo vehiculoDTO);
    public Vehiculo updateVehiculo(Vehiculo vehiculoDTO);
    public boolean deleteVehiculo(Long id);
}
