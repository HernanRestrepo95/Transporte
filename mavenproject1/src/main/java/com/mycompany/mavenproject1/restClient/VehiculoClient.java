/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.restClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import java.lang.reflect.Type;

import com.mycompany.mavenproject1.entity.Vehiculo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hernan_Restrepo
 */
public class VehiculoClient {

    private static final String GET_VEHICULOS_URL = "http://localhost:8081/vehiculo";
    private static final String GET_VEHICULO_URL = "http://localhost:8081/vehiculo";
    private static final String CREATE_VEHICULO = "http://localhost:8081/vehiculo";
    private static final String UPDATE_VEHICULO = "http://localhost:8081/vehiculo";
    private static final String DELETE_VEHICULO = "http://localhost:8081/vehiculo";
    private static final Util util = new Util();

    public List<Vehiculo> getVehiculos() {
        try {
            String result = util.get(GET_VEHICULOS_URL, null);
                        
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            Type tipoLista = new TypeToken<List<Vehiculo>>() {
            }.getType();
            
            List<Vehiculo> lstVehiculo = gson.fromJson(result, tipoLista);
            
            return lstVehiculo;
        } catch (Exception ex) {
            Logger.getLogger(VehiculoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    public Vehiculo getVehiculoById(Long id) {

        try {
            String result = util.get(GET_VEHICULO_URL, id);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            Vehiculo vehiculo = gson.fromJson(result, Vehiculo.class);
            
            return vehiculo;
        } catch (Exception ex) {
            Logger.getLogger(VehiculoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Vehiculo createVehiculo(Vehiculo newVehiculo) {

        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(newVehiculo);
            
            String result = util.post(CREATE_VEHICULO, json);
                        
            Vehiculo vehiculo = gson.fromJson(result, Vehiculo.class);
            
            return vehiculo;
        } catch (Exception ex) {
            Logger.getLogger(VehiculoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Vehiculo updateVehiculo(Vehiculo updatedVehiculo) {
        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(updatedVehiculo);
            
            String result = util.put(UPDATE_VEHICULO, json, updatedVehiculo.getId());
            
            Vehiculo vehiculo = gson.fromJson(result, Vehiculo.class);
            
            return vehiculo;
        } catch (Exception ex) {
            Logger.getLogger(VehiculoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void deleteVehiculo(Long id) {
        try {
            util.delete(DELETE_VEHICULO, id);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
