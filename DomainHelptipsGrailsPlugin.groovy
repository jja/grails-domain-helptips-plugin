class DomainHelptipsGrailsPlugin {
    // the plugin version
    def version = "0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3.7 > *"

    // the other plugins this plugin depends on
    //def dependsOn = ['jquery-ui':'1.10.3 > *']
    // for now, we're just including the needed files inline
    def dependsOn = [:]

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

    // URL to the plugin's documentation
    //def documentation = "http://grails.org/plugin/domain-helptips"
    def documentation = "https://github.com/jja/domain-helptips/blob/master/README"

    def doWithWebDescriptor = { xml -> }

    def doWithSpring = { }

    def doWithDynamicMethods = { ctx -> }

    def doWithApplicationContext = { applicationContext -> }

    def onChange = { event -> }

    def onConfigChange = { event -> }
}
