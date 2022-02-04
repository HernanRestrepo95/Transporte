<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TipoIdentificacion Items</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TipoIdentificacion Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No TipoIdentificacion Items)<br />" rendered="#{tipoIdentificacion.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{tipoIdentificacion.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{tipoIdentificacion.pagingInfo.firstItem + 1}..#{tipoIdentificacion.pagingInfo.lastItem} of #{tipoIdentificacion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tipoIdentificacion.prev}" value="Previous #{tipoIdentificacion.pagingInfo.batchSize}" rendered="#{tipoIdentificacion.pagingInfo.firstItem >= tipoIdentificacion.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{tipoIdentificacion.next}" value="Next #{tipoIdentificacion.pagingInfo.batchSize}" rendered="#{tipoIdentificacion.pagingInfo.lastItem + tipoIdentificacion.pagingInfo.batchSize <= tipoIdentificacion.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{tipoIdentificacion.next}" value="Remaining #{tipoIdentificacion.pagingInfo.itemCount - tipoIdentificacion.pagingInfo.lastItem}"
                                   rendered="#{tipoIdentificacion.pagingInfo.lastItem < tipoIdentificacion.pagingInfo.itemCount && tipoIdentificacion.pagingInfo.lastItem + tipoIdentificacion.pagingInfo.batchSize > tipoIdentificacion.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{tipoIdentificacion.tipoIdentificacionItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nombre"/>
                            </f:facet>
                            <h:outputText value="#{item.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Mostrar" action="#{tipoIdentificacion.detailSetup}">
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{tipoIdentificacion.editSetup}">
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{tipoIdentificacion.remove}">
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{tipoIdentificacion.createSetup}" value="Nuev@ TipoIdentificacion"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
