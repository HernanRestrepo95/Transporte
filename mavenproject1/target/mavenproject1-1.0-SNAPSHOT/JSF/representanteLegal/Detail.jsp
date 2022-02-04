<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>RepresentanteLegal Detalle</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>RepresentanteLegal Detalle</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.id}" title="Id" />
                    <h:outputText value="Ciudad:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.ciudad}" title="Ciudad" />
                    <h:outputText value="Departamento:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.departamento}" title="Departamento" />
                    <h:outputText value="Direccion:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.direccion}" title="Direccion" />
                    <h:outputText value="Nombre:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.nombre}" title="Nombre" />
                    <h:outputText value="NumeroDocumento:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.numeroDocumento}" title="NumeroDocumento" />
                    <h:outputText value="Pais:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.pais}" title="Pais" />
                    <h:outputText value="Telefono:"/>
                    <h:outputText value="#{representanteLegal.representanteLegal.telefono}" title="Telefono" />
                    <h:outputText value="tipoIdentificacion:"/>
                    <h:panelGroup>
                        <h:outputText value="#{representanteLegal.representanteLegal.tipoIdentificacion.nombre}"/>
                        <h:panelGroup rendered="#{representanteLegal.representanteLegal.tipoIdentificacion != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Mostrar" action="#{tipoIdentificacion.detailSetup}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="representanteLegal"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{tipoIdentificacion.editSetup}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="representanteLegal"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{tipoIdentificacion.destroy}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="representanteLegal"/>
                                <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>

                    <h:outputText value="EmpresaCollection:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty representanteLegal.representanteLegal.empresaCollection}" value="(No Items)"/>
                        <h:dataTable value="#{representanteLegal.representanteLegal.empresaCollection}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty representanteLegal.representanteLegal.empresaCollection}">
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
                                <h:outputText value="#{item.representanteLegal}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="tipoIdentificacion"/>
                                </f:facet>
                                <h:outputText value="#{item.tipoIdentificacion}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Mostrar" action="#{empresa.detailSetup}">
                                    <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="representanteLegal" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Editar" action="#{empresa.editSetup}">
                                    <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="representanteLegal" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Eliminar" action="#{empresa.destroy}">
                                    <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEmpresa" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][empresa.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="representanteLegal" />
                                    <f:param name="jsfcrud.relatedControllerType" value="com.mycompany.mavenproject1.jsf.classes.RepresentanteLegalController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{representanteLegal.remove}" value="Eliminar">
                    <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{representanteLegal.editSetup}" value="Editar">
                    <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][representanteLegal.representanteLegal][representanteLegal.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{representanteLegal.createSetup}" value="Nuev@ RepresentanteLegal" />
                <br />
                <h:commandLink action="#{representanteLegal.listSetup}" value="Mostrar RepresentanteLegal Items"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
