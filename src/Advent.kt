import java.io.File

fun main(args: Array<String>){
    println(readFile("src/Day1Problem1.txt"))
    //println(day1Problem1())

}

fun readFile(fileName: String) : List<String> {
    return File(fileName).readLines()
}

fun day1Problem1() : Int {
    val dataset = readFile("src/Day1Problem1.txt").toList()
    val pairs = dataset.zipWithNext()
    var increased = 0
    for(p in pairs){
        if(p.first.toInt() < p.second.toInt()){
            increased++
        }
    }
    return increased
}

fun day2Problem2() : Int{
    return 0
}






// try solve with loops first then...
// kotlin lambdas

// zipNext
// map

/*
val dataset = readFile("src/Day1Problem1.txt").toList()
val pairs = dataset.zipWithNext()

return 0
*/
