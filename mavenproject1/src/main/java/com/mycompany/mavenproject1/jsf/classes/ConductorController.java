/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.entity.Conductor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import com.mycompany.mavenproject1.restClient.ConductorClient;
import com.mycompany.mavenproject1.jsf.classes.util.JsfUtil;
import com.mycompany.mavenproject1.jsf.classes.util.PagingInfo;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hernan_Restrepo
 */
public class ConductorController {

    private Conductor conductor = null;
    private List<Conductor> conductorItems = null;

    private final ConductorClient conductorClient;

    private ConductorConverter converter = null;
    private PagingInfo pagingInfo = null;

    public ConductorController() {
        pagingInfo = new PagingInfo();
        converter = new ConductorConverter();

        conductorClient = new ConductorClient();
    }

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(conductorClient.getConductors().size());
        }
        return pagingInfo;
    }

    public SelectItem[] getConductorItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(conductorClient.getConductors(), false);
    }

    public SelectItem[] getConductorItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(conductorClient.getConductors(), true);
    }

    public Conductor getConductor() {
        if (conductor == null) {
            conductor = (Conductor) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentConductor", converter, null);
        }
        if (conductor == null) {
            conductor = new Conductor();
        }
        return conductor;
    }

    public String listSetup() {
        reset(true);
        return "conductor_list";
    }

    public String createSetup() {
        reset(false);
        conductor = new Conductor();
        return "conductor_create";
    }

    public String create() {
        try {
            conductorClient.createConductor(conductor);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("conductor_detail");
    }

    public String editSetup() {
        return scalarSetup("conductor_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        conductor = (Conductor) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentConductor", converter, null);
        if (conductor == null) {
            String requestConductorString = JsfUtil.getRequestParameter("jsfcrud.currentConductor");
            JsfUtil.addErrorMessage("The conductor with id " + requestConductorString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String conductorString = converter.getAsString(FacesContext.getCurrentInstance(), null, conductor);
        String currentConductorString = JsfUtil.getRequestParameter("jsfcrud.currentConductor");
        if (conductorString == null || conductorString.length() == 0 || !conductorString.equals(currentConductorString)) {
            String outcome = editSetup();
            if ("conductor_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit conductor. Try again.");
            }
            return outcome;
        }

        try {
            conductorClient.updateConductor(conductor);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentConductor");
        Long id = Long.parseLong(idAsString);

        boolean error = false;

        try {
            conductorClient.deleteConductor(id);
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

    public List<Conductor> getConductorItems() {
        if (conductorItems == null) {
            getPagingInfo();

            List<Conductor> lst = conductorClient.getConductors();

            int index = pagingInfo.getFirstItem() + pagingInfo.getBatchSize();
            int indexFinal = index > lst.size() ? lst.size() : index;

            conductorItems = lst.subList(pagingInfo.getFirstItem(), indexFinal);
        }
        return conductorItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "conductor_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "conductor_list";
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
        conductor = null;
        conductorItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Conductor newConductor = new Conductor();
        String newConductorString = converter.getAsString(FacesContext.getCurrentInstance(), null, newConductor);
        String conductorString = converter.getAsString(FacesContext.getCurrentInstance(), null, conductor);
        if (!newConductorString.equals(conductorString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
