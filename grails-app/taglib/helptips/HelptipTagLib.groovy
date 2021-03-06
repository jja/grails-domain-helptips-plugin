package helptips

/**
 * Domain helptips tags
 * 
 * @author John Allison
 */
class HelptipTagLib {

  def pluginManager

  /**     
   * Include necessary resource modules or libraries for domain helptips.
   * This tag might not work with resources plugin, just do the r:require instead:
   *   <code>&lt;r:require module=&quot;domain-helptips&quot; /&gt;</code>
   *      
   * @attr domain Optional domain class to check for helptips. If none are found,
   *   then the helptips setup code is not included.
   */
  def setupHelptips = { attrs ->
    def doIt = true
    if (attrs.domain) {
      def count = Helptip.countByPublishedAndDomainName(true, attrs.domain)
      if (count == 0) doIt = false
    }
    if (!doIt) return

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
  }

  /**     
   * Create the helptips for given domain. Writes Javascript tag.
   * Should be used in the document HEAD.
   *
   * @attr domain The domain class for which helptips are created.
   */
  def helptips = { attrs ->
    if (attrs.domain) {
      def helptips = Helptip.findAllByPublishedAndDomainName(true, attrs.domain)
      if (helptips?.size()) {
        out << "<script type=\"text/javascript\">\n"

        out << """
window.helptips = window.helptips || {};
var helptips = window.helptips;
if (typeof helptips.updateDomainProperty === 'undefined') {
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
}
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

  /**     
   * Add a button that toggles display of all inline helptips div elements.
   *
   * @attr domain Optional domain class to check for helptips. If none are found,
   *   then the toggle button is not included.
   */
  def allHelptipsToggler = { attrs ->
    def doIt = true
    if (attrs.domain) {
      def count = Helptip.countByPublishedAndDomainName(true, attrs.domain)
      if (count == 0) doIt = false
    }
    if (!doIt) return

    out << '<a id="all_allHelptipsToggler" title="Toggle display of all help tips" class="empty helptips_icon helptips_icon_all helptips_all_off'
    if (attrs.domain) out << "helptips_domain_${attrs.domain}"
    out << '" onclick="helptips.toggleAll()"></a>'
  }

}
