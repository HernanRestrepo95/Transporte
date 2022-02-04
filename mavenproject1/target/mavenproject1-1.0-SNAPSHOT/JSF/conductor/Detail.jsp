<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Conductor Detalle</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Conductor Detalle</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{conductor.conductor.id}" title="Id" />
                    <h:outputText value="Ciudad:"/>
                    <h:outputText value="#{conductor.conductor.ciudad}" title="Ciudad" />
                    <h:outputText value="Departamento:"/>
                    <h:outputText value="#{conductor.conductor.departamento}" title="Departamento" />
                    <h:outputText value="Direccion:"/>
                    <h:outputText value="#{conductor.conductor.direccion}" title="Direccion" />
                    <h:outputText value="Nombre:"/>
                    <h:outputText value="#{conductor.conductor.nombre}" title="Nombre" />
                    <h:outputText value="NumeroDocumento:"/>
                    <h:outputText value="#{conductor.conductor.numeroDocumento}" title="NumeroDocumento" />
                    <h:outputText value="Pais:"/>
                    <h:outputText value="#{conductor.conductor.pais}" title="Pais" />
                    <h:outputText value="Telefono:"/>
                    <h:outputText value="#{conductor.conductor.telefono}" title="Telefono" />
                    <h:outputText value="tipoIdentificacion:"/>
                    <h:panelGroup>
                        <h:outputText value="#{conductor.conductor.tipoIdentificacion.nombre}"/>
                        <h:panelGroup rendered="#{conductor.conductor.tipoIdentificacion != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Mostrar" action="#{tipoIdentificacion.detailSetup}">
                                <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="conductor"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{tipoIdentificacion.editSetup}">
                                <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="conductor"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{tipoIdentificacion.destroy}">
                                <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="conductor"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="lstVehiculo:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty conductor.conductor.lstVehiculo}" value="(No Items)"/>
                        <h:dataTable value="#{conductor.conductor.lstVehiculo}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty conductor.conductor.lstVehiculo}">
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
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
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
                                    <h:outputText value="empresa"/>
                                </f:facet>
                                <h:outputText value="#{item.empresa}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Mostrar" action="#{vehiculo.detailSetup}">
                                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="conductor" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Editar" action="#{vehiculo.editSetup}">
                                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="conductor" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Eliminar" action="#{vehiculo.destroy}">
                                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentVehiculo" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][vehiculo.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="conductor" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.ConductorController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{conductor.remove}" value="Eliminar">
                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{conductor.editSetup}" value="Editar">
                    <f:param name="jsfcrud.currentConductor" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][conductor.conductor][conductor.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{conductor.createSetup}" value="Nuev@ Conductor" />
                <br />
                <h:commandLink action="#{conductor.listSetup}" value="Mostrar Conductor Items"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
