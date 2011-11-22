

<%@ page import="helptips.Helptip" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'helptip.label', default: 'Helptip')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${helptipInstance}">
            <div class="errors">
                <g:renderErrors bean="${helptipInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${helptipInstance?.id}" />
                <g:hiddenField name="version" value="${helptipInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="domainName"><g:message code="helptip.domainName.label" default="Domain Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'domainName', 'errors')}">
                                    <g:textField name="domainName" value="${helptipInstance?.domainName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="domainProperty"><g:message code="helptip.domainProperty.label" default="Domain Property" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'domainProperty', 'errors')}">
                                    <g:textField name="domainProperty" value="${helptipInstance?.domainProperty}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="title"><g:message code="helptip.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'title', 'errors')}">
                                    <g:textArea name="title" cols="40" rows="5" value="${helptipInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="helptip.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${helptipInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="published"><g:message code="helptip.published.label" default="Published" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'published', 'errors')}">
                                    <g:checkBox name="published" value="${helptipInstance?.published}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
