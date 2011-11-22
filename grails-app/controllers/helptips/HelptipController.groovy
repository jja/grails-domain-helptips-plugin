package helptips

class HelptipController {

   def scaffold = Helptip

   def propertyOptions = {
       grailsApplication.getArtefactByLogicalPropertyName('Domain',params.id)?.properties.each {
         render "<option value='${it.name}'>${it.naturalName}</option>\n"
         }
   }

}
