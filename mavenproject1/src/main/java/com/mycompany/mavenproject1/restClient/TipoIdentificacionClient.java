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

import com.mycompany.mavenproject1.entity.TipoIdentificacion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hernan_Restrepo
 */
public class TipoIdentificacionClient {

    private static final String GET_TIPO_IDENTIFICACIONS_URL = "http://localhost:8081/tipoidentificacion";
    private static final String GET_TIPO_IDENTIFICACION_URL = "http://localhost:8081/tipoidentificacion";
    private static final String CREATE_TIPO_IDENTIFICACION = "http://localhost:8081/tipoidentificacion";
    private static final String UPDATE_TIPO_IDENTIFICACION = "http://localhost:8081/tipoidentificacion";
    private static final String DELETE_TIPO_IDENTIFICACION = "http://localhost:8081/tipoidentificacion";
    private static final Util util = new Util();

    public List<TipoIdentificacion> getTipoIdentificacions() {
        try {
            String result = util.get(GET_TIPO_IDENTIFICACIONS_URL, null);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type tipoLista = new TypeToken<List<TipoIdentificacion>>() {
            }.getType();
            
            List<TipoIdentificacion> lstTipoIdentificacion = gson.fromJson(result, tipoLista);
            
            return lstTipoIdentificacion;
        } catch (Exception ex) {
            Logger.getLogger(TipoIdentificacionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    public TipoIdentificacion getTipoIdentificacionById(Long id) {

        try {
            String result = util.get(GET_TIPO_IDENTIFICACION_URL, id);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            TipoIdentificacion tipoIdentificacion = gson.fromJson(result, TipoIdentificacion.class);
            
            return tipoIdentificacion;
        } catch (Exception ex) {
            Logger.getLogger(TipoIdentificacionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public TipoIdentificacion createTipoIdentificacion(TipoIdentificacion newTipoIdentificacion) {

        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(newTipoIdentificacion);
            
            String result = util.post(CREATE_TIPO_IDENTIFICACION, json);
            
            TipoIdentificacion tipoIdentificacion = gson.fromJson(result, TipoIdentificacion.class);
            
            return tipoIdentificacion;
        } catch (Exception ex) {
            Logger.getLogger(TipoIdentificacionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public TipoIdentificacion updateTipoIdentificacion(TipoIdentificacion updatedTipoIdentificacion) {
        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(updatedTipoIdentificacion);
            
            String result = util.put(UPDATE_TIPO_IDENTIFICACION, json, updatedTipoIdentificacion.getId());
            
            TipoIdentificacion tipoIdentificacion = gson.fromJson(result, TipoIdentificacion.class);
            
            return tipoIdentificacion;
        } catch (Exception ex) {
            Logger.getLogger(TipoIdentificacionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void deleteTipoIdentificacion(Long id) {
        try {
            util.delete(DELETE_TIPO_IDENTIFICACION, id);
        } catch (Exception ex) {
            Logger.getLogger(TipoIdentificacionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
