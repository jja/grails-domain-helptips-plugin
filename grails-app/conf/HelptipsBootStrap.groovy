import helptips.*

class HelptipsBootStrap {

    def init = { servletContext ->

        // bootstrap some tips for the Helptip domain itself
        if (!Helptip.findByPublishedAndDomainName(true,'helptip')) {

            new Helptip(domainName:'helptip', domainProperty:"domainName", published:true, title:"Domain",
                description: "<p>Select a domain from the drop down. Note that some of the domains may be ones you don't usually have access to, or are renamed in the application.</p>"
            ).save(flush:true)

            new Helptip(domainName:'helptip', domainProperty:"domainProperty", published:true, title:"Property",
                description: '<p>Select a domain property from the drop down. This corresponds to a column in the database table.</p>'
            ).save(flush:true)

            new Helptip(domainName:'helptip', domainProperty:"title", published:true, title:"Tip Title ",
                description: "<p>This will be shown as the tip title, in bold or different color.</p>"
            ).save(flush:true)

            new Helptip(domainName:'helptip', domainProperty:"description", published:true, title:"Tip Description ",
                description: "<p>The main tip text -- a longer description/explanation than the title.</p>"
            ).save(flush:true)

            }

    }

    def destroy = { }

} 
