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

import com.mycompany.mavenproject1.entity.RepresentanteLegal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hernan_Restrepo
 */
public class RepresentanteLegalClient {

    private static final String GET_REPRESENTANTE_LEGALS_URL = "http://localhost:8081/representantelegal";
    private static final String GET_REPRESENTANTE_LEGAL_URL = "http://localhost:8081/representantelegal";
    private static final String CREATE_REPRESENTANTE_LEGAL = "http://localhost:8081/representantelegal";
    private static final String UPDATE_REPRESENTANTE_LEGAL = "http://localhost:8081/representantelegal";
    private static final String DELETE_REPRESENTANTE_LEGAL = "http://localhost:8081/representantelegal";
    private static final Util util = new Util();

    public List<RepresentanteLegal> getRepresentanteLegals() {
        try {
            String result = util.get(GET_REPRESENTANTE_LEGALS_URL, null);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type tipoLista = new TypeToken<List<RepresentanteLegal>>() {
            }.getType();
            
            List<RepresentanteLegal> lstRepresentanteLegal = gson.fromJson(result, tipoLista);
            
            return lstRepresentanteLegal;
        } catch (Exception ex) {
            Logger.getLogger(RepresentanteLegalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    public RepresentanteLegal getRepresentanteLegalById(Long id) {

        try {
            String result = util.get(GET_REPRESENTANTE_LEGAL_URL, id);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            RepresentanteLegal representanteLegal = gson.fromJson(result, RepresentanteLegal.class);
            
            return representanteLegal;
        } catch (Exception ex) {
            Logger.getLogger(RepresentanteLegalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public RepresentanteLegal createRepresentanteLegal(RepresentanteLegal newRepresentanteLegal) {

        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(newRepresentanteLegal);
            
            String result = util.post(CREATE_REPRESENTANTE_LEGAL, json);
            
            RepresentanteLegal representanteLegal = gson.fromJson(result, RepresentanteLegal.class);
            
            return representanteLegal;
        } catch (Exception ex) {
            Logger.getLogger(RepresentanteLegalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public RepresentanteLegal updateRepresentanteLegal(RepresentanteLegal updatedRepresentanteLegal) {
        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(updatedRepresentanteLegal);
            
            String result = util.put(UPDATE_REPRESENTANTE_LEGAL, json, updatedRepresentanteLegal.getId());
            
            RepresentanteLegal representanteLegal = gson.fromJson(result, RepresentanteLegal.class);
            
            return representanteLegal;
        } catch (Exception ex) {
            Logger.getLogger(RepresentanteLegalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void deleteRepresentanteLegal(Long id) {
        try {
            util.delete(DELETE_REPRESENTANTE_LEGAL, id);            
        } catch (Exception ex) {
            Logger.getLogger(RepresentanteLegalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
