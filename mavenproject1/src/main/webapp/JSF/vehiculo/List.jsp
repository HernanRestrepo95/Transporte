<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Vehiculo Items</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Vehiculo Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Vehiculo Items)<br />" rendered="#{vehiculo.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{vehiculo.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{vehiculo.pagingInfo.firstItem + 1}..#{vehiculo.pagingInfo.lastItem} of #{vehiculo.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{vehiculo.prev}" value="Previous #{vehiculo.pagingInfo.batchSize}" rendered="#{vehiculo.pagingInfo.firstItem >= vehiculo.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{vehiculo.next}" value="Next #{vehiculo.pagingInfo.batchSize}" rendered="#{vehiculo.pagingInfo.lastItem + vehiculo.pagingInfo.batchSize <= vehiculo.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{vehiculo.next}" value="Remaining #{vehiculo.pagingInfo.itemCount - vehiculo.pagingInfo.lastItem}"
                                   rendered="#{vehiculo.pagingInfo.lastItem < vehiculo.pagingInfo.itemCount && vehiculo.pagingInfo.lastItem + vehiculo.pagingInfo.batchSize > vehiculo.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{vehiculo.vehiculoItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Chasis"/>
                            </f:facet>
                            <h:outputText value="#{item.chasis}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="FechaMatricula"/>
                            </f:facet>
                            <h:outputText value="#{item.fechaMatricula}">
                                <f:convertDateTime pattern="yyyy-MM-dd" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Linea"/>
                            </f:facet>
                            <h:outputText value="#{item.linea}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Marca"/>
                            </f:facet>
                            <h:outputText value="#{item.marca}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Modelo"/>
                            </f:facet>
                            <h:outputText value="#{item.modelo}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Motor"/>
                            </f:facet>
                            <h:outputText value="#{item.motor}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PasajerosPie"/>
                            </f:facet>
                            <h:outputText value="#{item.pasajerosPie}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PasajerosSentados"/>
                            </f:facet>
                            <h:outputText value="#{item.pasajerosSentados}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PesoBruto"/>
                            </f:facet>
                            <h:outputText value="#{item.pesoBruto}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="PesoSeco"/>
                            </f:facet>
                            <h:outputText value="#{item.pesoSeco}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Placa"/>
                            </f:facet>
                            <h:outputText value="#{item.placa}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Puertas"/>
                            </f:facet>
                            <h:outputText value="#{item.puertas}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Mostrar" action="#{vehiculo.detailSetup}">
                                <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{vehiculo.editSetup}">
                                <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{vehiculo.remove}">
                                <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{vehiculo.createSetup}" value="Nuev@ Vehiculo"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
