package helptips

class Helptip {

     String domainName
     String domainProperty
     String title
     String description
     boolean published = true

     static constraints = {
        domainName blank:false, nullable: false
        domainProperty blank:false, nullable: false, unique:'domainName'
        title blank:false, nullable: false, maxSize: 255
        description blank:true, nullable: true, maxSize:8192, widget:'textarea'
        }

    static mapping = {
        description sqlType:'text'
        }

}
