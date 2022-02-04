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

import com.mycompany.mavenproject1.entity.Conductor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hernan_Restrepo
 */
public class ConductorClient {

    private static final String GET_CONDUCTORES_URL = "http://localhost:8081/conductor";
    private static final String GET_CONDUCTOR_URL = "http://localhost:8081/conductor";
    private static final String CREATE_CONDUCTOR = "http://localhost:8081/conductor";
    private static final String UPDATE_CONDUCTOR = "http://localhost:8081/conductor";
    private static final String DELETE_CONDUCTOR = "http://localhost:8081/conductor";
    private static final Util util = new Util();

    public List<Conductor> getConductors() {
        try {
            String result = util.get(GET_CONDUCTORES_URL, null);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type tipoLista = new TypeToken<List<Conductor>>() {
            }.getType();
            
            List<Conductor> lstConductor = gson.fromJson(result, tipoLista);
            
            return lstConductor;
        } catch (Exception ex) {
            Logger.getLogger(ConductorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    public Conductor getConductorById(Long id) {

        try {
            String result = util.get(GET_CONDUCTOR_URL, id);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            Conductor conductor = gson.fromJson(result, Conductor.class);
            
            return conductor;
        } catch (Exception ex) {
            Logger.getLogger(ConductorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Conductor createConductor(Conductor newConductor) {

        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(newConductor);
            
            String result = util.post(CREATE_CONDUCTOR, json);
            
            Conductor conductor = gson.fromJson(result, Conductor.class);
            
            return conductor;
        } catch (Exception ex) {
            Logger.getLogger(ConductorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Conductor updateConductor(Conductor updatedConductor) {
        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(updatedConductor);
            
            String result = util.put(UPDATE_CONDUCTOR, json, updatedConductor.getId());
            
            Conductor conductor = gson.fromJson(result, Conductor.class);
            
            return conductor;
        } catch (Exception ex) {
            Logger.getLogger(ConductorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void deleteConductor(Long id) {
        try {
            util.delete(DELETE_CONDUCTOR, id);
        } catch (Exception ex) {
            Logger.getLogger(ConductorClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
