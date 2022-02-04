<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            </title>TipoIdentificacion</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Nuev@ TipoIdentificacion</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{tipoIdentificacion.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{tipoIdentificacion.tipoIdentificacion.nombre}" title="Nombre" />
                </h:panelGrid>
                <br />
                <h:commandLink action="#{tipoIdentificacion.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{tipoIdentificacion.listSetup}" value="Mostrar TipoIdentificacion Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
