import java.io.File

fun main(args: Array<String>){
    //println(readFile("src/Day1Problem1.txt"))
    //println(day1Problem1())
    //println(day1Problem2())
    //println(day2Problem2())
    val dataset = readFile("src/Day1Problem2Example.txt").toList()
    println(dataset.windowed(size = 3, step = 3))

    val list = listOf(2, 4, 3, 10, 8, 7, 9)
    val newList = list.windowed(2, 2, true)
    println(newList[0].sum())
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

fun day1Problem2() : Int {
    val dataset = readFile("src/Day1Problem2Example.txt").toList()
    var convertedToNumList = mutableListOf<Int>()
    for(str in dataset){
        convertedToNumList.add(str.toInt())
    }
    val newDataset = convertedToNumList.windowed(size = 3, step = 3)
    var increased = 0
    var firstSum = 0

    while(i <newDataset.size - 1){

        if(newDataset[0] == newDataset[0]){
            firstSum = newDataset[0].toInt
        }

    }

    return increased
}
/*
var convertedToNumList = mutableListOf<Int>()
for(str in stringList){
    convertedToNumList.add(str.toInt())
}

var mappedStringToNumList = stringList.map {
    stringNum -> stringNum.toIn()
    println("mapped one: $mappedStringNumList
}

something

 */


fun day2Problem2() : Int{
    val dataset = readFile("src/Day2Problem2.txt").toList()
    var horizontal = 0
    var increase = 0
    var decrease = 0

    var mappedSplit = dataset.map {
        entry -> entry.split("")[1].toInt()
    }
    for(d in dataset) {
        if (d.contains("forward")) {
            val result = d.drop(d.length-1)
            horizontal += result.toInt()
        } else if (d.contains("down")) {
            val result = d.drop(d.length-1)
            increase += result.toInt()
        } else {
            val result = d.drop(d.length-1)
            decrease += result.toInt()
        }
    }
    return horizontal * (increase - decrease)
}




/*
for(i in 0)
    repeat(x)
for(i in 0 until x)


 */















// try solve with loops first then...
// kotlin lambdas

// zipNext
// map

/*
val dataset = readFile("src/Day1Problem1.txt").toList()
val pairs = dataset.zipWithNext()

return 0
*/
