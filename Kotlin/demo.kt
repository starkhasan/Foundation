/*var firstDate = "08/08/2019"
var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
var date = formatter.parse(firstDate)
var desiredFormat = DateTimeFormatter.ofPattern("dd, MMM yyyy").format(date)
println(desiredFormat)
*/
fun main(args:Array<String>){
    var firstDate = "08/08/2019"
    var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date = formatter.parse(firstDate)
    var desiredFormat = DateTimeFormatter.ofPattern("dd, MMM yyyy").format(date)
    println(desiredFormat)
}

