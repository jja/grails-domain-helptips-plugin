package helptips

class HelptipTagLib {

  def pluginManager

  def helptips = { attrs ->
    if (attrs.domain) {
      def helptips = Helptip.findAllByPublishedAndDomainName(true, attrs.domain)
      if (helptips) {

        // include necessary resource modules or libraries
        if ( pluginManager.getGrailsPlugin('resources') ) {
          out << '<r:require module="domain-helptips" />'
        } else {
          if (attrs.includeJQ==null || attrs.includeJQ==true) {
            out << "<script type=\"text/javascript\" src=\"" + g.resource(plugin: 'domain-helptips', dir: '/js/ext', file: 'jquery-1.7.min.js' ) + "\"></script>\n"
            out << "<link rel='stylesheet' href=\"" + g.resource(plugin: 'domain-helptips', dir: '/css/ext', file: 'jquery-ui-1.8.15.custom.css' ) + "\"/>\n"
            out << "<script type=\"text/javascript\" src=\"" + g.resource(plugin: 'domain-helptips', dir: '/js/ext', file: 'jquery-ui-1.8.15.custom.min.js' ) + "\"></script>\n"
          }
          if (attrs.includeHI==null || attrs.includeHI==true) {
            out << "<script type=\"text/javascript\" src=\"" + g.resource(plugin: 'domain-helptips', dir: '/js/ext', file: 'jquery.hoverIntent.minified.js' ) + "\"></script>\n"
          }
        out << "<script type=\"text/javascript\" src=\"" + g.resource(plugin: 'domain-helptips', dir: '/js', file: 'jquery.bt.custom.js' ) + "\"></script>\n"
        out << "<link rel='stylesheet' href=\"" + g.resource(plugin: 'domain-helptips', dir: '/css', file: 'helptips.css' ) + "\"/>\n"
        out << "<script type=\"text/javascript\" src=\"" + g.resource(plugin: 'domain-helptips', dir: '/js', file: 'helptips.js' ) + "\"></script>\n"
        }

        // now write the js to create the helptips for this domain
        out << "<script type=\"text/javascript\">\n"

        out << """
window.helptips = window.helptips || {};
var helptips = window.helptips;
helptips.updateDomainProperty = function(domainPropertyId,domainNameId) {
  \$(function() {
    \$('#'+domainPropertyId).html('');
    \$.ajax({
        url: '${createLink(controller:"helptip", action:"propertyOptions")}' + '/' + \$('#'+domainNameId).val(),
        success: function(data) {
            \$('#'+domainPropertyId).html(data);
            }
        });
  });
};
        """

        helptips.each {
          out << "helptips.createTip(\"${it.id}\", \"${it.domainName}\", \"${it.domainProperty}\", \"${it.title?.encodeAsJavaScript()}\", \"${it.description?.encodeAsJavaScript()}\");\n"
          }

        out << "</script>\n"

      } else  {
        out << "<!-- No helptips for domain ${attrs.domain} -->\n"
      }
    } else {
      throw new Exception("Parameter domain not set for helptips tag")
    }
  }

  def allHelptipsToggler = { attrs ->
    out << '<a id="all_allHelptipsToggler" title="Toggle display of all help tips" class="empty helptips_icon helptips_icon_all helptips_all_off" onclick="helptips.toggleAll()"></a>'
  }

}
