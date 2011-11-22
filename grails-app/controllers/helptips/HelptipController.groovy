package helptips

class HelptipController {

   def scaffold = Helptip

   def properties = {
       grailsApplication.getArtefactByLogicalPropertyName('Domain',params.id)?.properties.each {
         render "<option>${it.name}</option>\n"
         }
   }

}
