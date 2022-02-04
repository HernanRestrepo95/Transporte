/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.entity.RepresentanteLegal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import com.mycompany.mavenproject1.jsf.classes.util.JsfUtil;
import com.mycompany.mavenproject1.jsf.classes.util.PagingInfo;
import com.mycompany.mavenproject1.restClient.RepresentanteLegalClient;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hernan_Restrepo
 */
public class RepresentanteLegalController {

    private RepresentanteLegal representanteLegal = null;
    private List<RepresentanteLegal> representanteLegalItems = null;
    
    private RepresentanteLegalClient representanteLegalClient;  
        
    private RepresentanteLegalConverter converter = null;
    private PagingInfo pagingInfo = null;
    
        public RepresentanteLegalController() {
        pagingInfo = new PagingInfo();
        converter = new RepresentanteLegalConverter();
        
        representanteLegalClient = new RepresentanteLegalClient();
    }

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(representanteLegalClient.getRepresentanteLegals().size());
        }
        return pagingInfo;
    }


    public SelectItem[] getRepresentanteLegalItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(representanteLegalClient.getRepresentanteLegals(), false);
    }

    public SelectItem[] getRepresentanteLegalItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(representanteLegalClient.getRepresentanteLegals(), true);
    }

    public RepresentanteLegal getRepresentanteLegal() {
        if (representanteLegal == null) {
            representanteLegal = (RepresentanteLegal) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentRepresentanteLegal", converter, null);
        }
        if (representanteLegal == null) {
            representanteLegal = new RepresentanteLegal();
        }
        return representanteLegal;
    }

    public String listSetup() {
        reset(true);
        return "representanteLegal_list";
    }

    public String createSetup() {
        reset(false);
        representanteLegal = new RepresentanteLegal();
        return "representanteLegal_create";
    }

    public String create() {
        try {
            representanteLegalClient.createRepresentanteLegal(representanteLegal);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("representanteLegal_detail");
    }

    public String editSetup() {
        return scalarSetup("representanteLegal_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        representanteLegal = (RepresentanteLegal) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentRepresentanteLegal", converter, null);
        if (representanteLegal == null) {
            String requestRepresentanteLegalString = JsfUtil.getRequestParameter("jsfcrud.currentRepresentanteLegal");
            JsfUtil.addErrorMessage("The representanteLegal with id " + requestRepresentanteLegalString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String representanteLegalString = converter.getAsString(FacesContext.getCurrentInstance(), null, representanteLegal);
        String currentRepresentanteLegalString = JsfUtil.getRequestParameter("jsfcrud.currentRepresentanteLegal");
        if (representanteLegalString == null || representanteLegalString.length() == 0 || !representanteLegalString.equals(currentRepresentanteLegalString)) {
            String outcome = editSetup();
            if ("representanteLegal_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit representanteLegal. Try again.");
            }
            return outcome;
        }

        try {
            representanteLegalClient.updateRepresentanteLegal(representanteLegal);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentRepresentanteLegal");
        Long id = Long.parseLong(idAsString);
        
        boolean error = false;

        try {            
            representanteLegalClient.deleteRepresentanteLegal(id);
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

    public List<RepresentanteLegal> getRepresentanteLegalItems() {
        if (representanteLegalItems == null) {
            getPagingInfo();
            
            List<RepresentanteLegal> lst = representanteLegalClient.getRepresentanteLegals();

            int index = pagingInfo.getFirstItem() + pagingInfo.getBatchSize();
            int indexFinal = index > lst.size() ? lst.size() : index;

            representanteLegalItems = lst.subList(pagingInfo.getFirstItem(), indexFinal);                       
        }
        return representanteLegalItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "representanteLegal_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "representanteLegal_list";
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
        representanteLegal = null;
        representanteLegalItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        RepresentanteLegal newRepresentanteLegal = new RepresentanteLegal();
        String newRepresentanteLegalString = converter.getAsString(FacesContext.getCurrentInstance(), null, newRepresentanteLegal);
        String representanteLegalString = converter.getAsString(FacesContext.getCurrentInstance(), null, representanteLegal);
        if (!newRepresentanteLegalString.equals(representanteLegalString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
