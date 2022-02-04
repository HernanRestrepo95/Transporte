<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Empresa Items</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Empresa Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Empresa Items)<br />" rendered="#{empresa.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{empresa.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{empresa.pagingInfo.firstItem + 1}..#{empresa.pagingInfo.lastItem} of #{empresa.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{empresa.prev}" value="Previous #{empresa.pagingInfo.batchSize}" rendered="#{empresa.pagingInfo.firstItem >= empresa.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{empresa.next}" value="Next #{empresa.pagingInfo.batchSize}" rendered="#{empresa.pagingInfo.lastItem + empresa.pagingInfo.batchSize <= empresa.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{empresa.next}" value="Remaining #{empresa.pagingInfo.itemCount - empresa.pagingInfo.lastItem}"
                                   rendered="#{empresa.pagingInfo.lastItem < empresa.pagingInfo.itemCount && empresa.pagingInfo.lastItem + empresa.pagingInfo.batchSize > empresa.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{empresa.empresaItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Ciudad"/>
                            </f:facet>
                            <h:outputText value="#{item.ciudad}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Departamento"/>
                            </f:facet>
                            <h:outputText value="#{item.departamento}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Direccion"/>
                            </f:facet>
                            <h:outputText value="#{item.direccion}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nombre"/>
                            </f:facet>
                            <h:outputText value="#{item.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="NumeroDocumento"/>
                            </f:facet>
                            <h:outputText value="#{item.numeroDocumento}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Pais"/>
                            </f:facet>
                            <h:outputText value="#{item.pais}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Telefono"/>
                            </f:facet>
                            <h:outputText value="#{item.telefono}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="representanteLegal"/>
                            </f:facet>
                            <h:outputText value="#{item.representanteLegal.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="tipoIdentificacion"/>
                            </f:facet>
                            <h:outputText value="#{item.tipoIdentificacion.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Mostrar" action="#{empresa.detailSetup}">
                                <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{empresa.editSetup}">
                                <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{empresa.remove}">
                                <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{empresa.createSetup}" value="Nuev@ Empresa"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
