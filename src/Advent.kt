import java.io.File

fun main(args: Array<String>){
    //println(readFile("src/Day1Problem1.txt"))
    //println(day1Problem1())
    //println(day1Problem2())
    //println(day2Problem1())
    //println(day2Problem2())
    println(day3Problem1())

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
    val dataset = readFile("src/Day1Problem2.txt").toList()
    var convertedToNumList = mutableListOf<Int>()
    for(str in dataset){
        convertedToNumList.add(str.toInt())
    }
    val newDataset = convertedToNumList.windowed(size = 3, step = 1)
    var increased = 0
    var currentSum = 0
    for(n in newDataset){
        if(n == newDataset[0]){
            currentSum = n.sum()
        }
        else if(n.sum() > currentSum){
            increased++
        }
        currentSum = n.sum()
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

fun day2Problem1() : Int{
    val dataset = readFile("src/Day2Problem2.txt").toList()
    var horizontal = 0
    var increase = 0
    var direction: String
    var num: Int
    var i = 0
    var j: Int

    var mappedSplitNums = dataset.map {
            entry -> entry.split(" ")
    }
    repeat(mappedSplitNums.size){
        j = 0
        direction = mappedSplitNums[i][j]
        j++
        num = mappedSplitNums[i][j].toInt()
        if (direction.contains("forward")) {
            horizontal += num
        } else if (direction.contains("down")) {
            increase += num
        } else if(direction.contains("up")){
            increase -= num
        }
        i++
    }
    return horizontal * increase
}

fun day2Problem2() : Int{
    val dataset = readFile("src/Day2Problem2.txt").toList()
    var horizontal = 0
    var increase = 0
    var depth = 0
    var direction: String
    var num: Int
    var i = 0
    var j: Int

    var mappedSplitNums = dataset.map {
            entry -> entry.split(" ")
    }
    repeat(mappedSplitNums.size){
        j = 0
        direction = mappedSplitNums[i][j]
        j++
        num = mappedSplitNums[i][j].toInt()
        if (direction.contains("forward")) {
            horizontal += num
            depth += increase * num
        } else if (direction.contains("down")) {
            increase += num
        } else if(direction.contains("up")){
            increase -= num
        }
        i++
    }
    return horizontal * depth
}

fun day3Problem1() : Int{
    val dataset = readFile("src/Day3Problem1Example.txt").toList()
    // find new binary numbers (gamma rate and epsilon rate)
    // power is gamma rate * epsilon rate
    // gamma rate can be determined by finding the most common bit
    // in the corresponding position of all numbers in the diagnostic report
    var gammaRate = ""
    var epsilonRate = ""
    var zeros: Int
    var ones: Int
    var i: Int
    for(n in dataset) {
        zeros = 0
        ones = 0
        i = 0
        for (n in dataset) {
            if(i < n.length) {
                if(n.substring(i, i + 1) == "1")
                    ones++
                else
                    zeros++
                i++
            }
        }
        if(ones > zeros){
            gammaRate += 1
            epsilonRate += 0
        }
        else{
            gammaRate += 0
            epsilonRate += 1
        }
    }
    println(gammaRate)
    println(epsilonRate)

    return 0
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

val dataset = readFile("src/Day1Problem2Example.txt").toList()
    println(dataset.windowed(size = 3, step = 3))

    val list = listOf(2, 4, 3, 10, 8, 7, 9)
    val newList = list.windowed(2, 2, true)
    println(newList[0].sum())
 */

