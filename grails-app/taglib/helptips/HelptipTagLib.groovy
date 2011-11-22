package helptips

class HelptipTagLib {

  def helptips = { attrs ->
    if (attrs.domain) {
      def helptips = Helptip.findAllByPublishedAndDomainName(true, attrs.domain)
      if (helptips) {
        out << "<r:require module=\"jquery-ui\"/>\n"
        out << "<script type=\"text/javascript\" src=\"" + resource(plugin: 'domain-helptips', dir: '/js/jquery', file: 'jquery.bt.custom.js' ) + "\"></script>\n"
        out << "<link rel='stylesheet' href=\"" + resource(plugin: 'domain-helptips', dir: '/css', file: 'helptips.css" ) + "\"/>\n"
        out << "<script type=\"text/javascript\" src=\"" + resource(plugin: 'domain-helptips', dir: '/js', file: 'helptips.js" ) + "\"></script>\n"
        out << "<script type=\"text/javascript\">\n"

        out << """
window.helptips = window.helptips || {};
var helptips = window.helptips;
helptips.updateDomainProperty = function(domainPropertyId,domainNameId) {
  $(function() {
    $('#'+domainPropertyId).html('');
    $.ajax({
        url: '${createLink(controller:"helptips", action:"properties")}' + '/' + $('#'+domainNameId).val(),
        success: function(data) {
            $('#'+domainPropertyId).html(data);
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

}
