/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.jsf.classes;

import com.mycompany.mavenproject1.entity.Empresa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.faces.FacesException;
import com.mycompany.mavenproject1.jsf.classes.util.JsfUtil;
import com.mycompany.mavenproject1.jsf.classes.util.PagingInfo;
import com.mycompany.mavenproject1.restClient.EmpresaClient;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Hernan_Restrepo
 */
public class EmpresaController {

    private Empresa empresa = null;
    private List<Empresa> empresaItems = null;

    private EmpresaClient empresaClient;

    private EmpresaConverter converter = null;
    private PagingInfo pagingInfo = null;

    public EmpresaController() {
        pagingInfo = new PagingInfo();
        converter = new EmpresaConverter();

        empresaClient = new EmpresaClient();
    }

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(empresaClient.getEmpresas().size());
        }
        return pagingInfo;
    }

    public SelectItem[] getEmpresaItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(empresaClient.getEmpresas(), false);
    }

    public SelectItem[] getEmpresaItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(empresaClient.getEmpresas(), true);
    }

    public Empresa getEmpresa() {
        if (empresa == null) {
            empresa = (Empresa) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEmpresa", converter, null);
        }
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    public String listSetup() {
        reset(true);
        return "empresa_list";
    }

    public String createSetup() {
        reset(false);
        empresa = new Empresa();
        return "empresa_create";
    }

    public String create() {
        try {
            empresaClient.createEmpresa(empresa);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("empresa_detail");
    }

    public String editSetup() {
        return scalarSetup("empresa_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        empresa = (Empresa) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEmpresa", converter, null);
        if (empresa == null) {
            String requestEmpresaString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
            JsfUtil.addErrorMessage("The empresa with id " + requestEmpresaString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String empresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, empresa);
        String currentEmpresaString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
        if (empresaString == null || empresaString.length() == 0 || !empresaString.equals(currentEmpresaString)) {
            String outcome = editSetup();
            if ("empresa_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit empresa. Try again.");
            }
            return outcome;
        }

        try {
            empresaClient.updateEmpresa(empresa);
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
        Long id = Long.parseLong(idAsString);

        boolean error = false;

        try {
            empresaClient.deleteEmpresa(id);
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

    public List<Empresa> getEmpresaItems() {
        if (empresaItems == null) {
            getPagingInfo();

            List<Empresa> lst = empresaClient.getEmpresas();

            int index = pagingInfo.getFirstItem() + pagingInfo.getBatchSize();
            int indexFinal = index > lst.size() ? lst.size() : index;

            empresaItems = lst.subList(pagingInfo.getFirstItem(), indexFinal);
        }
        return empresaItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "empresa_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "empresa_list";
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
        empresa = null;
        empresaItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Empresa newEmpresa = new Empresa();
        String newEmpresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, newEmpresa);
        String empresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, empresa);
        if (!newEmpresaString.equals(empresaString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
