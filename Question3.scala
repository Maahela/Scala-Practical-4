object NameFormatter{
    def toUpper(name: String): String = {
        name.toUpperCase
    }

    def toLower(name: String): String = {
        name.toLowerCase
    }

    def formatNames(name: String)(format: String => String): String = {
        format(name)
    }

    def main(args: Array[String]): Unit = {
        val names = List("Benny", "Niroshan", "Saman", "Kumara")

        val formattedNames = names.map {
            case "Benny" => formatNames("Benny")(toUpper)
            case "Niroshan" => formatNames("Niroshan") {name => name.substring(0,2).toUpperCase + name.substring(2).toLowerCase}
            case "Saman" => formatNames("Saman")(toLower)
            case "Kumara" => formatNames("Kumara") {name => name.substring(0,1).toUpperCase + name.substring(1,name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase}
            case name => name
        }
    
        formattedNames.foreach(println)
    }
}