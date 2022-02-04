<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>TipoIdentificacion Detalle</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>TipoIdentificacion Detalle</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{tipoIdentificacion.tipoIdentificacion.id}" title="Id" />
                    <h:outputText value="Nombre:"/>
                    <h:outputText value="#{tipoIdentificacion.tipoIdentificacion.nombre}" title="Nombre" />                    

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tipoIdentificacion.remove}" value="Eliminar">
                    <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tipoIdentificacion.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tipoIdentificacion.editSetup}" value="Editar">
                    <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tipoIdentificacion.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{tipoIdentificacion.createSetup}" value="Nuev@ TipoIdentificacion" />
                <br />
                <h:commandLink action="#{tipoIdentificacion.listSetup}" value="Mostrar TipoIdentificacion Items"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
