<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>EditarConductor</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>EditarConductor</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{conductor.conductor.id}" title="Id" />
                    <h:outputText value="Ciudad:"/>
                    <h:inputText id="ciudad" value="#{conductor.conductor.ciudad}" title="Ciudad" />
                    <h:outputText value="Departamento:"/>
                    <h:inputText id="departamento" value="#{conductor.conductor.departamento}" title="Departamento" />
                    <h:outputText value="Direccion:"/>
                    <h:inputText id="direccion" value="#{conductor.conductor.direccion}" title="Direccion" />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{conductor.conductor.nombre}" title="Nombre" />
                    <h:outputText value="NumeroDocumento:"/>
                    <h:inputText id="numeroDocumento" value="#{conductor.conductor.numeroDocumento}" title="NumeroDocumento" />
                    <h:outputText value="Pais:"/>
                    <h:inputText id="pais" value="#{conductor.conductor.pais}" title="Pais" />
                    <h:outputText value="Telefono:"/>
                    <h:inputText id="telefono" value="#{conductor.conductor.telefono}" title="Telefono" />
                    <h:outputText value="lstVehiculo:"/>
                    <h:selectManyListbox id="lstVehiculo" value="#{conductor.conductor.jsfcrud_transform[jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.arrayToList].lstVehiculo}" title="lstVehiculo" size="6" converter="#{vehiculo.converter}" >
                        <f:selectItems value="#{vehiculo.vehiculoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="tipoIdentificacion:"/>
                    <h:selectOneMenu id="tipoIdentificacion" value="#{conductor.conductor.tipoIdentificacion}" title="tipoIdentificacion" required="true" requiredMessage="The tipoIdentificacion field is required." >
                        <f:selectItems value="#{tipoIdentificacion.tipoIdentificacionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{conductor.edit}" value="Save">
                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{conductor.detailSetup}" value="Mostrar" immediate="true">
                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{conductor.listSetup}" value="Mostrar Conductor Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
