<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            </title>RepresentanteLegal</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Nuev@ RepresentanteLegal</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{representanteLegal.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Ciudad:"/>
                    <h:inputText id="ciudad" value="#{representanteLegal.representanteLegal.ciudad}" title="Ciudad" />
                    <h:outputText value="Departamento:"/>
                    <h:inputText id="departamento" value="#{representanteLegal.representanteLegal.departamento}" title="Departamento" />
                    <h:outputText value="Direccion:"/>
                    <h:inputText id="direccion" value="#{representanteLegal.representanteLegal.direccion}" title="Direccion" />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{representanteLegal.representanteLegal.nombre}" title="Nombre" />
                    <h:outputText value="NumeroDocumento:"/>
                    <h:inputText id="numeroDocumento" value="#{representanteLegal.representanteLegal.numeroDocumento}" title="NumeroDocumento" />
                    <h:outputText value="Pais:"/>
                    <h:inputText id="pais" value="#{representanteLegal.representanteLegal.pais}" title="Pais" />
                    <h:outputText value="Telefono:"/>
                    <h:inputText id="telefono" value="#{representanteLegal.representanteLegal.telefono}" title="Telefono" />
                    <h:outputText value="tipoIdentificacion:"/>
                    <h:selectOneMenu id="tipoIdentificacion" value="#{representanteLegal.representanteLegal.tipoIdentificacion}" title="tipoIdentificacion" required="true" requiredMessage="The tipoIdentificacion field is required." >
                        <f:selectItems value="#{tipoIdentificacion.tipoIdentificacionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{representanteLegal.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{representanteLegal.listSetup}" value="Mostrar RepresentanteLegal Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
