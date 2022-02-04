<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>EditarEmpresa</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>EditarEmpresa</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{empresa.empresa.id}" title="Id" />
                    <h:outputText value="Ciudad:"/>
                    <h:inputText id="ciudad" value="#{empresa.empresa.ciudad}" title="Ciudad" />
                    <h:outputText value="Departamento:"/>
                    <h:inputText id="departamento" value="#{empresa.empresa.departamento}" title="Departamento" />
                    <h:outputText value="Direccion:"/>
                    <h:inputText id="direccion" value="#{empresa.empresa.direccion}" title="Direccion" />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{empresa.empresa.nombre}" title="Nombre" />
                    <h:outputText value="NumeroDocumento:"/>
                    <h:inputText id="numeroDocumento" value="#{empresa.empresa.numeroDocumento}" title="NumeroDocumento" />
                    <h:outputText value="Pais:"/>
                    <h:inputText id="pais" value="#{empresa.empresa.pais}" title="Pais" />
                    <h:outputText value="Telefono:"/>
                    <h:inputText id="telefono" value="#{empresa.empresa.telefono}" title="Telefono" />
                    <h:outputText value="lstVehiculo:"/>
                    <h:selectManyListbox id="lstVehiculo" value="#{empresa.empresa.jsfcrud_transform[jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.arrayToList].lstVehiculo}" title="lstVehiculo" size="6" converter="#{vehiculo.converter}" >
                        <f:selectItems value="#{vehiculo.vehiculoItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="representanteLegal:"/>
                    <h:selectOneMenu id="representanteLegal" value="#{empresa.empresa.representanteLegal}" title="representanteLegal" >
                        <f:selectItems value="#{representanteLegal.representanteLegalItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="tipoIdentificacion:"/>
                    <h:selectOneMenu id="tipoIdentificacion" value="#{empresa.empresa.tipoIdentificacion}" title="tipoIdentificacion" required="true" requiredMessage="The tipoIdentificacion field is required." >
                        <f:selectItems value="#{tipoIdentificacion.tipoIdentificacionItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{empresa.edit}" value="Save">
                    <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{empresa.detailSetup}" value="Mostrar" immediate="true">
                    <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][empresa.empresa][empresa.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{empresa.listSetup}" value="Mostrar Empresa Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
