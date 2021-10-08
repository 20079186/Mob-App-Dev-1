package org.wit.prócaBláthanna.console.main


import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerModel
import java.awt.SystemColor.menu


private val logger = KotlinLogging.logger{}

var flower = FlowerModel()

fun main(args: Array<String>) {
    logger.info { "Launching PrócaBláthanna Console App" }


    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addFLower()
            2 -> updateFLower()
            3 -> listFlowers()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down PrócaBláthanna Console App" }
}

    fun menu() : Int {

        var option : Int
        var input: String? = null

        println("Main Menu")
        println(" 1. Add FLower")
        println(" 2. Update FLower")
        println(" 3. List All FLowers")
        println("-1. Exit")
        println()
        print("Enter an option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

fun addFLower(){


    println("Add Flower")
    println()
    print("Enter a Name : ")
    flower.name = readLine()!!
    print("Enter a description : ")
    flower.description = readLine()!!
    println("You entered $flower.name for name and [ $flower.description ] for description")

}

fun updateFLower(){
    println("Update FLower")
    println()
    print("Enter a new name for [ $flower.name } : ")
    flower.name = readLine()!!
    print("Enter a new Description for [ $flower.description : ] ")
    flower.description = readLine()!!
    println("You updated [ $flower.name ] for name and [ $flower.description ] for description")


}

fun listFlowers(){


}
