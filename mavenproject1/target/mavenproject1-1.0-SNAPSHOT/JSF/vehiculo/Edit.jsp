<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>EditarVehiculo</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>EditarVehiculo</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{vehiculo.vehiculo.id}" title="Id" />
                    <h:outputText value="Chasis:"/>
                    <h:inputText id="chasis" value="#{vehiculo.vehiculo.chasis}" title="Chasis" />
                    <h:outputText value="FechaMatricula (yyyy-MM-dd):"/>
                    <h:inputText id="fechaMatricula" value="#{vehiculo.vehiculo.fechaMatricula}" title="FechaMatricula" >
                        <f:convertDateTime pattern="yyyy-MM-dd" />
                    </h:inputText>
                    <h:outputText value="Linea:"/>
                    <h:inputText id="linea" value="#{vehiculo.vehiculo.linea}" title="Linea" />
                    <h:outputText value="Marca:"/>
                    <h:inputText id="marca" value="#{vehiculo.vehiculo.marca}" title="Marca" />
                    <h:outputText value="Modelo:"/>
                    <h:inputText id="modelo" value="#{vehiculo.vehiculo.modelo}" title="Modelo" />
                    <h:outputText value="Motor:"/>
                    <h:inputText id="motor" value="#{vehiculo.vehiculo.motor}" title="Motor" />
                    <h:outputText value="PasajerosPie:"/>
                    <h:inputText id="pasajerosPie" value="#{vehiculo.vehiculo.pasajerosPie}" title="PasajerosPie" />
                    <h:outputText value="PasajerosSentados:"/>
                    <h:inputText id="pasajerosSentados" value="#{vehiculo.vehiculo.pasajerosSentados}" title="PasajerosSentados" />
                    <h:outputText value="PesoBruto:"/>
                    <h:inputText id="pesoBruto" value="#{vehiculo.vehiculo.pesoBruto}" title="PesoBruto" />
                    <h:outputText value="PesoSeco:"/>
                    <h:inputText id="pesoSeco" value="#{vehiculo.vehiculo.pesoSeco}" title="PesoSeco" />
                    <h:outputText value="Placa:"/>
                    <h:inputText id="placa" value="#{vehiculo.vehiculo.placa}" title="Placa" />
                    <h:outputText value="Puertas:"/>
                    <h:inputText id="puertas" value="#{vehiculo.vehiculo.puertas}" title="Puertas" />     

                </h:panelGrid>
                <br />
                <h:commandLink action="#{vehiculo.edit}" value="Save">
                    <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][vehiculo.vehiculo][vehiculo.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{vehiculo.detailSetup}" value="Mostrar" immediate="true">
                    <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][vehiculo.vehiculo][vehiculo.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{vehiculo.listSetup}" value="Mostrar Vehiculo Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
