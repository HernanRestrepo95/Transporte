/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.restClient.EmpresaClient;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.mycompany.mavenproject1.entity.Empresa;

/**
 *
 * @author Hernan_Restrepo
 */
public class EmpresaConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(string);
        EmpresaClient empresaClient = new EmpresaClient();
        return empresaClient.getEmpresaById(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Empresa) {
            Empresa o = (Empresa) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.transportationweb.transportationweb.entity.Empresa");
        }
    }
    
}
