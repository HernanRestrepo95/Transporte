<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>RepresentanteLegal Items</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>RepresentanteLegal Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No RepresentanteLegal Items)<br />" rendered="#{representanteLegal.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{representanteLegal.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{representanteLegal.pagingInfo.firstItem + 1}..#{representanteLegal.pagingInfo.lastItem} of #{representanteLegal.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{representanteLegal.prev}" value="Previous #{representanteLegal.pagingInfo.batchSize}" rendered="#{representanteLegal.pagingInfo.firstItem >= representanteLegal.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{representanteLegal.next}" value="Next #{representanteLegal.pagingInfo.batchSize}" rendered="#{representanteLegal.pagingInfo.lastItem + representanteLegal.pagingInfo.batchSize <= representanteLegal.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{representanteLegal.next}" value="Remaining #{representanteLegal.pagingInfo.itemCount - representanteLegal.pagingInfo.lastItem}"
                                   rendered="#{representanteLegal.pagingInfo.lastItem < representanteLegal.pagingInfo.itemCount && representanteLegal.pagingInfo.lastItem + representanteLegal.pagingInfo.batchSize > representanteLegal.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{representanteLegal.representanteLegalItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <h:outputText value="tipoIdentificacion"/>
                            </f:facet>
                            <h:outputText value="#{item.tipoIdentificacion.nombre}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Mostrar" action="#{representanteLegal.detailSetup}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][representanteLegal.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Editar" action="#{representanteLegal.editSetup}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][representanteLegal.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Eliminar" action="#{representanteLegal.remove}">
                                <f:param name="jsfcrud.currentRepresentanteLegal" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][representanteLegal.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{representanteLegal.createSetup}" value="Nuev@ RepresentanteLegal"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
