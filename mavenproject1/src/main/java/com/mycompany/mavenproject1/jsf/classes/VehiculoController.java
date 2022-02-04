/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.entity.Vehiculo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import com.mycompany.mavenproject1.jsf.classes.util.JsfUtil;
import com.mycompany.mavenproject1.jsf.classes.util.PagingInfo;
import com.mycompany.mavenproject1.restClient.VehiculoClient;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hernan_Restrepo
 */
public class VehiculoController {

    private Vehiculo vehiculo = null;
    private List<Vehiculo> vehiculoItems = null;

    private VehiculoClient vehiculoClient;

    private VehiculoConverter converter = null;
    private PagingInfo pagingInfo = null;

    public VehiculoController() {
        pagingInfo = new PagingInfo();
        converter = new VehiculoConverter();

        vehiculoClient = new VehiculoClient();
    }

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(vehiculoClient.getVehiculos().size());
        }
        return pagingInfo;
    }

    public SelectItem[] getVehiculoItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(vehiculoClient.getVehiculos(), false);
    }

    public SelectItem[] getVehiculoItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(vehiculoClient.getVehiculos(), true);
    }

    public Vehiculo getVehiculo() {
        if (vehiculo == null) {
            vehiculo = (Vehiculo) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentVehiculo", converter, null);
        }
        if (vehiculo == null) {
            vehiculo = new Vehiculo();
        }
        return vehiculo;
    }

    public String listSetup() {
        reset(true);
        return "vehiculo_list";
    }

    public String createSetup() {
        reset(false);
        vehiculo = new Vehiculo();
        return "vehiculo_create";
    }

    public String create() {
        try {
            vehiculoClient.createVehiculo(vehiculo);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("vehiculo_detail");
    }

    public String editSetup() {
        return scalarSetup("vehiculo_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        vehiculo = (Vehiculo) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentVehiculo", converter, null);
        if (vehiculo == null) {
            String requestVehiculoString = JsfUtil.getRequestParameter("jsfcrud.currentVehiculo");
            JsfUtil.addErrorMessage("The vehiculo with id " + requestVehiculoString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String vehiculoString = converter.getAsString(FacesContext.getCurrentInstance(), null, vehiculo);
        String currentVehiculoString = JsfUtil.getRequestParameter("jsfcrud.currentVehiculo");
        if (vehiculoString == null || vehiculoString.length() == 0 || !vehiculoString.equals(currentVehiculoString)) {
            String outcome = editSetup();
            if ("vehiculo_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit vehiculo. Try again.");
            }
            return outcome;
        }

        try {
            vehiculoClient.updateVehiculo(vehiculo);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentVehiculo");
        Long id = Long.parseLong(idAsString);

        boolean error = false;

        try {
            vehiculoClient.deleteVehiculo(id);
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

    public List<Vehiculo> getVehiculoItems() {
        if (vehiculoItems == null) {
            getPagingInfo();

            List<Vehiculo> lst = vehiculoClient.getVehiculos();

            int index = pagingInfo.getFirstItem() + pagingInfo.getBatchSize();
            int indexFinal = index > lst.size() ? lst.size() : index;

            vehiculoItems = lst.subList(pagingInfo.getFirstItem(), indexFinal);
        }
        return vehiculoItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "vehiculo_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "vehiculo_list";
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
        vehiculo = null;
        vehiculoItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Vehiculo newVehiculo = new Vehiculo();
        String newVehiculoString = converter.getAsString(FacesContext.getCurrentInstance(), null, newVehiculo);
        String vehiculoString = converter.getAsString(FacesContext.getCurrentInstance(), null, vehiculo);
        if (!newVehiculoString.equals(vehiculoString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
