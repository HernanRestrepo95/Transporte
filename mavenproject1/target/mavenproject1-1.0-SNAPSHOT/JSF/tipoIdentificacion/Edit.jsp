<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>EditarTipoIdentificacion</title>
            <link rel="stylesheet" type="text/css" href="/mavenproject1/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>EditarTipoIdentificacion</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{tipoIdentificacion.tipoIdentificacion.id}" title="Id" />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{tipoIdentificacion.tipoIdentificacion.nombre}" title="Nombre" />
                    <h:outputText value="RepresentanteLegalCollection:"/>
                    <h:selectManyListbox id="representanteLegalCollection" value="#{tipoIdentificacion.tipoIdentificacion.jsfcrud_transform[jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.arrayToList].representanteLegalCollection}" title="RepresentanteLegalCollection" size="6" converter="#{representanteLegal.converter}" >
                        <f:selectItems value="#{representanteLegal.representanteLegalItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="EmpresaCollection:"/>
                    <h:selectManyListbox id="empresaCollection" value="#{tipoIdentificacion.tipoIdentificacion.jsfcrud_transform[jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.arrayToList].empresaCollection}" title="EmpresaCollection" size="6" converter="#{empresa.converter}" >
                        <f:selectItems value="#{empresa.empresaItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="ConductorCollection:"/>
                    <h:selectManyListbox id="conductorCollection" value="#{tipoIdentificacion.tipoIdentificacion.jsfcrud_transform[jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method.arrayToList].conductorCollection}" title="ConductorCollection" size="6" converter="#{conductor.converter}" >
                        <f:selectItems value="#{conductor.conductorItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{tipoIdentificacion.edit}" value="Save">
                    <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tipoIdentificacion.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{tipoIdentificacion.detailSetup}" value="Mostrar" immediate="true">
                    <f:param name="jsfcrud.currentTipoIdentificacion" value="#{jsfcrud_class['com.mycompany.mavenproject1.jsf.classes.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][tipoIdentificacion.tipoIdentificacion][tipoIdentificacion.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{tipoIdentificacion.listSetup}" value="Mostrar TipoIdentificacion Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Inicio" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
