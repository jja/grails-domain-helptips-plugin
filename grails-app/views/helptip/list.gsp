
<%@ page import="helptips.Helptip" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'helptip.label', default: 'Helptip')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'helptip.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="domainName" title="${message(code: 'helptip.domainName.label', default: 'Domain Name')}" />
                        
                            <g:sortableColumn property="domainProperty" title="${message(code: 'helptip.domainProperty.label', default: 'Domain Property')}" />
                        
                            <g:sortableColumn property="title" title="${message(code: 'helptip.title.label', default: 'Title')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'helptip.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="published" title="${message(code: 'helptip.published.label', default: 'Published')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${helptipInstanceList}" status="i" var="helptipInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${helptipInstance.id}">${fieldValue(bean: helptipInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: helptipInstance, field: "domainName")}</td>
                        
                            <td>${fieldValue(bean: helptipInstance, field: "domainProperty")}</td>
                        
                            <td>${fieldValue(bean: helptipInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: helptipInstance, field: "description")}</td>
                        
                            <td><g:formatBoolean boolean="${helptipInstance.published}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${helptipInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
