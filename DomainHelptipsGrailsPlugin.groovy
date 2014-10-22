class DomainHelptipsGrailsPlugin {
    def version = "2.1"
    def grailsVersion = "2.3.7 > *"

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "John J. Allison"
    def authorEmail = "jja@sinequanon.net"
    def title = "Domain-oriented dynamic helptips"
    def description = '''\\
Dynamically add helptips to Grails views based on domain properties.
Tips are user-editable.
Inspired by/based on Grails plugin dynamic-help
'''

    //def documentation = "http://grails.org/plugin/domain-helptips"
    def documentation = "https://github.com/jja/domain-helptips/blob/master/README"

}
