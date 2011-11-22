                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domainName"><g:message code="helptip.domainName.label" default="Domain Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'domainName', 'errors')}">
                                    <g:select onchange="helptips.updateDomainProperty('domainProperty','domainName');" optionKey="logicalPropertyName" optionValue="name" from="${grailsApplication.domainClasses.sort{it.name}}" id="domainName" name="domainName" value="${helptipInstance?.domainName}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="domainProperty"><g:message code="helptip.domainProperty.label" default="Domain Property" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'domainProperty', 'errors')}">
                                    <g:select id="domainProperty" name="domainProperty" value="${helptipInstance?.domainProperty}" />
                                    <script type="text/javascript">
                                        helptips.updateDomainProperty('domainProperty','domainName');
                                    </script>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="helptip.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: helptipInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" cols="40" value="${helptipInstance?.title}" />
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

