import java.io.File
import kotlin.math.pow

fun main(args: Array<String>){
    //println(readFile("src/Day1Problem1.txt"))
    //println(day1Problem1())
    //println(day1Problem2())
    //println(day2Problem1())
    //println(day2Problem2())
    //println(day3Problem1())
    println(day3Problem2())
    println(Integer.parseInt("101", 2))
    /*
    val list = listOf("a", "b", "c")
    val mutableList = list.toMutableList()
    for (i in list.indices) {
        println(i)
        println(list[i])
        mutableList.removeAt(0)
        println(mutableList)
    }

     */


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
    val dataset = readFile("src/Day3Problem1.txt").toList()
    // find new binary numbers (gamma rate and epsilon rate)
    // power is gamma rate * epsilon rate
    // gamma rate can be determined by finding the most common bit
    // in the corresponding position of all numbers in the diagnostic report
    var gammaRate = ""
    var epsilonRate = ""
    var zeros: Int
    var ones: Int
    for(i in 0 until dataset[0].length) {
        zeros = 0
        ones = 0
        for (n in dataset) {
            if(n.substring(i, i + 1) == "1")
                ones++
            else if(n.substring(i, i + 1) == "0")
                zeros++
        }
        if(ones > zeros){
            gammaRate += 1
            epsilonRate += 0
        }
        else if(zeros > ones){
            gammaRate += 0
            epsilonRate += 1
        }
    }

    var gnum = gammaRate.toLong()
    var decimalGammaRate = 0
    var i = 0
    var gremainder: Long

    while (gnum.toInt() != 0) {
        gremainder = gnum % 10
        gnum /= 10
        decimalGammaRate += (gremainder * 2.0.pow(i.toDouble())).toInt()
        ++i
    }
    var enum = epsilonRate.toLong()
    var decimalEpsilonRate = 0
    var m = 0
    var eremainder: Long

    while (enum.toInt() != 0) {
        eremainder = enum % 10
        enum /= 10
        decimalEpsilonRate += (eremainder * 2.0.pow(m.toDouble())).toInt()
        ++m
    }

    return decimalGammaRate * decimalEpsilonRate
}

fun day3Problem2() : Int {
    val dataset = readFile("src/Day3Problem2Example.txt").toList()
    var zeros: Int
    var ones: Int
    val oGenList = mutableListOf<String>()
    oGenList.addAll(dataset)
    println(oGenList)
    val co2GenList = mutableListOf(dataset.toString())
    //dataset.joinToString("")

    for(i in 0 until oGenList[0].length) {
        zeros = 0
        ones = 0
        for (n in oGenList) {
            if(n.substring(i, i + 1) == "1")
                ones++
            else if(n.substring(i, i + 1) == "0")
                zeros++
        }
        if(ones >= zeros){
            for (r in oGenList.size-1 downTo  0) {
                if(oGenList[r].substring(i,i+1) == "0") {
                    oGenList.removeAt(r)
                }
            }
        }
        if(ones >= zeros){
            for (r in oGenList.size-1 downTo  0) {
                if(oGenList[r].substring(i,i+1) == "1") {
                    oGenList.removeAt(r)
                }
            }
        }
        println(oGenList)
    }
/*
    for(i in 0 until dataset[0].length) {
        zeros = 0
        ones = 0
        for (n in dataset) {
            if(n.substring(i, i + 1) == "1")
                ones++
            else if(n.substring(i, i + 1) == "0")
                zeros++
        }
        println("one: $ones")
        println("zero: $zeros")

        if(ones >= zeros){
            oxygenGeneratorRating += 1
            co2ScrubberRating += 0
        }
        else if(zeros > ones){
            oxygenGeneratorRating += 0
            co2ScrubberRating += 1
        }

    }
    println(oGenList)
    println(co2GenList)

    var onum = oxygenGeneratorRating.toLong()
    var decimalOxygenGeneratorRating = 0
    var j = 0
    var oremainder: Long

    while (onum.toInt() != 0) {
        oremainder = onum % 10
        onum /= 10
        decimalOxygenGeneratorRating += (oremainder * 2.0.pow(j.toDouble())).toInt()
        ++j
    }
    var cnum = co2ScrubberRating.toLong()
    var decimalCo2ScrubberRating = 0
    var m = 0
    var cremainder: Long

    while (cnum.toInt() != 0) {
        cremainder = cnum % 10
        cnum /= 10
        decimalCo2ScrubberRating += (cremainder * 2.0.pow(m.toDouble())).toInt()
        ++m
    }

 */
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

    var totalGammaRate = 0
    for(i in 4 downTo 0){
        when (i) {
            4 -> totalGammaRate += gammaRate.drop(i).toInt()
            3 -> totalGammaRate += gammaRate.drop(i).toInt() * 2
            2 -> totalGammaRate += gammaRate.drop(i).toInt() * 4
            1 -> totalGammaRate += gammaRate.drop(i).toInt() * 8
            0 -> totalGammaRate += gammaRate.drop(i).toInt() * 16
        }
        println(totalGammaRate)
        println(gammaRate)
    }

    var totalEpsilonRate = 0
    for(i in 4 downTo 0){
        println(gammaRate.substring(i,i).toInt())
        when (i) {
            4 -> totalEpsilonRate += gammaRate.substring(i,gammaRate.length).toInt()
            3 -> totalEpsilonRate += gammaRate.substring(4,gammaRate.length).toInt() * 2
            2 -> totalEpsilonRate += gammaRate.substring(4,gammaRate.length).toInt() * 4
            1 -> totalEpsilonRate += gammaRate.substring(4,gammaRate.length).toInt() * 8
            0 -> totalEpsilonRate += gammaRate.substring(4,gammaRate.length).toInt() * 16
        }
    }
 */

