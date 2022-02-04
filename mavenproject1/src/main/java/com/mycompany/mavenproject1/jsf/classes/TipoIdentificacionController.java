/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.entity.TipoIdentificacion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import com.mycompany.mavenproject1.jsf.classes.util.JsfUtil;
import com.mycompany.mavenproject1.jsf.classes.util.PagingInfo;
import com.mycompany.mavenproject1.restClient.TipoIdentificacionClient;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hernan_Restrepo
 */
public class TipoIdentificacionController {

    private TipoIdentificacion tipoIdentificacion = null;
    private List<TipoIdentificacion> tipoIdentificacionItems = null;
    
    private TipoIdentificacionClient tipoIdentificacionClient;  
        
    private TipoIdentificacionConverter converter = null;
    private PagingInfo pagingInfo = null;
    
        public TipoIdentificacionController() {
        pagingInfo = new PagingInfo();
        converter = new TipoIdentificacionConverter();
        
        tipoIdentificacionClient = new TipoIdentificacionClient();
    }

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(tipoIdentificacionClient.getTipoIdentificacions().size());
        }
        return pagingInfo;
    }


    public SelectItem[] getTipoIdentificacionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(tipoIdentificacionClient.getTipoIdentificacions(), false);
    }

    public SelectItem[] getTipoIdentificacionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(tipoIdentificacionClient.getTipoIdentificacions(), true);
    }

    public TipoIdentificacion getTipoIdentificacion() {
        if (tipoIdentificacion == null) {
            tipoIdentificacion = (TipoIdentificacion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTipoIdentificacion", converter, null);
        }
        if (tipoIdentificacion == null) {
            tipoIdentificacion = new TipoIdentificacion();
        }
        return tipoIdentificacion;
    }

    public String listSetup() {
        reset(true);
        return "tipoIdentificacion_list";
    }

    public String createSetup() {
        reset(false);
        tipoIdentificacion = new TipoIdentificacion();
        return "tipoIdentificacion_create";
    }

    public String create() {
        try {
            tipoIdentificacionClient.createTipoIdentificacion(tipoIdentificacion);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("tipoIdentificacion_detail");
    }

    public String editSetup() {
        return scalarSetup("tipoIdentificacion_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        tipoIdentificacion = (TipoIdentificacion) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentTipoIdentificacion", converter, null);
        if (tipoIdentificacion == null) {
            String requestTipoIdentificacionString = JsfUtil.getRequestParameter("jsfcrud.currentTipoIdentificacion");
            JsfUtil.addErrorMessage("The tipoIdentificacion with id " + requestTipoIdentificacionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String tipoIdentificacionString = converter.getAsString(FacesContext.getCurrentInstance(), null, tipoIdentificacion);
        String currentTipoIdentificacionString = JsfUtil.getRequestParameter("jsfcrud.currentTipoIdentificacion");
        if (tipoIdentificacionString == null || tipoIdentificacionString.length() == 0 || !tipoIdentificacionString.equals(currentTipoIdentificacionString)) {
            String outcome = editSetup();
            if ("tipoIdentificacion_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit tipoIdentificacion. Try again.");
            }
            return outcome;
        }

        try {
            tipoIdentificacionClient.updateTipoIdentificacion(tipoIdentificacion);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentTipoIdentificacion");
        Long id = Long.parseLong(idAsString);

        try {            
            tipoIdentificacionClient.deleteTipoIdentificacion(id);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        
        //revisar
        if (false) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<TipoIdentificacion> getTipoIdentificacionItems() {
        if (tipoIdentificacionItems == null) {
            getPagingInfo();
            
            List<TipoIdentificacion> lst = tipoIdentificacionClient.getTipoIdentificacions();
            
            int index = pagingInfo.getFirstItem() + pagingInfo.getBatchSize();
            int indexFinal = index > lst.size() ? lst.size() : index;
            
            tipoIdentificacionItems = lst.subList(pagingInfo.getFirstItem(), indexFinal);
        }
        return tipoIdentificacionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "tipoIdentificacion_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "tipoIdentificacion_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method DetalleSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) DetalleSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        tipoIdentificacion = null;
        tipoIdentificacionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        TipoIdentificacion newTipoIdentificacion = new TipoIdentificacion();
        String newTipoIdentificacionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newTipoIdentificacion);
        String tipoIdentificacionString = converter.getAsString(FacesContext.getCurrentInstance(), null, tipoIdentificacion);
        if (!newTipoIdentificacionString.equals(tipoIdentificacionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
