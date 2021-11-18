package search

fun main() {
    println("Enter the number of people:")
    val inputLinesQuantity = readLine()!!.toInt()
    search(inputLinesQuantity)
}

fun search (inputLinesQuantity: Int) {
    var temp = mutableListOf<String>()
    var inputLines = mutableListOf<String>()
    var menu = "\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit"
    println("Enter all people:")
    repeat (inputLinesQuantity) {
        inputLines.add(readLine()!!.toString())
    }
    println(menu)
    var menuSearchNum = readLine()!!.toInt()
    while (menuSearchNum != 0) {
        when (menuSearchNum) {
            1 -> {
                println("\nEnter a name or email to search all suitable people.")
                val searchData = readLine()!!.toString()
                for (element in 0 until inputLines.size){
                    if (inputLines[element].contains(searchData) ||
                        inputLines[element].toLowerCase().contains(searchData.toLowerCase()) ||
                        inputLines[element].toUpperCase().contains(searchData.toUpperCase())) {
                        temp.add(inputLines[element])
                    }
                }
                if (temp.size != 0) {
                    println("\nPeople found:")
                    for(element in 0 until temp.size){
                        println(temp[element])
                    }
                    temp.clear()
                } else {
                    println("No matching people found.")
                }
                println(menu)
                menuSearchNum = readLine()!!.toInt()   
            }
            2 -> {
                println("\n=== List of people ===")
                for (element in 0 until inputLines.size) {
                    println("${inputLines[element]}")
                }
                println(menu)
                menuSearchNum = readLine()!!.toInt()
            }
            0 -> break
            else -> {
                println("\nIncorrect option! Try again.")
                println(menu)
                menuSearchNum = readLine()!!.toInt()
            }
        }   
    }
    println("\nBye!")     
}
