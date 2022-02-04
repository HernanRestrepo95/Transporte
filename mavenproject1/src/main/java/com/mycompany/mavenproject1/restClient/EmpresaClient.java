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

import com.mycompany.mavenproject1.entity.Empresa;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hernan_Restrepo
 */
public class EmpresaClient {

    private static final String GET_EMPRESAS_URL = "http://localhost:8081/empresa";
    private static final String GET_EMPRESA_URL = "http://localhost:8081/empresa";
    private static final String CREATE_EMPRESA = "http://localhost:8081/empresa";
    private static final String UPDATE_EMPRESA = "http://localhost:8081/empresa";
    private static final String DELETE_EMPRESA = "http://localhost:8081/empresa";
    private static final Util util = new Util();

    public List<Empresa> getEmpresas() {
        try {
            String result = util.get(GET_EMPRESAS_URL, null);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type tipoLista = new TypeToken<List<Empresa>>() {
            }.getType();
            
            List<Empresa> lstEmpresa = gson.fromJson(result, tipoLista);
            
            return lstEmpresa;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }

    public Empresa getEmpresaById(Long id) {

        try {
            String result = util.get(GET_EMPRESA_URL, id);
            
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            
            Empresa empresa = gson.fromJson(result, Empresa.class);
            
            return empresa;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Empresa createEmpresa(Empresa newEmpresa) {

        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(newEmpresa);
            
            String result = util.post(CREATE_EMPRESA, json);
            
            Empresa empresa = gson.fromJson(result, Empresa.class);
            
            return empresa;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Empresa updateEmpresa(Empresa updatedEmpresa) {
        try {
            Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String json = gson.toJson(updatedEmpresa);
            
            String result = util.put(UPDATE_EMPRESA, json, updatedEmpresa.getId());
            
            Empresa empresa = gson.fromJson(result, Empresa.class);
            
            return empresa;
        } catch (Exception ex) {
            Logger.getLogger(EmpresaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void deleteEmpresa(Long id) {
        try {
            util.delete(DELETE_EMPRESA, id);
        } catch (Exception ex) {
            Logger.getLogger(EmpresaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
