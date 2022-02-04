/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.restClient.ConductorClient;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.mycompany.mavenproject1.entity.Conductor;

/**
 *
 * @author Hernan_Restrepo
 */
public class ConductorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(string);
        ConductorClient conductorClient = new ConductorClient();
        return conductorClient.getConductorById(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Conductor) {
            Conductor o = (Conductor) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: com.transportationweb.transportationweb.entity.Conductor");
        }
    }
    
}
