package org.wit.prócaBláthanna.console.main


import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerModel


private val logger = KotlinLogging.logger {}

var flower = FlowerModel()
var flowers = ArrayList<FlowerModel>()

fun main(args: Array<String>) {
    logger.info { "Launching PrócaBláthanna Console App" }


    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> addFLower()
            2 -> updateFLower()
            3 -> listFlowers()
            4 -> searchFlower()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down PrócaBláthanna Console App" }
}

fun menu(): Int {

    var option: Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add FLower")
    println(" 2. Update FLower")
    println(" 3. List All FLowers")
    println(" 4. Search All FLowers")
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

fun addFLower() {
    var aFlower = FlowerModel()
    println("Add Flower")
    println()
    print("Enter a Name : ")
    flower.name = readLine()!!
    print("Enter a description : ")
    flower.description = readLine()!!

    if (aFlower.name.isNotEmpty() && aFlower.description.isNotEmpty()) {
        aFlower.id = flowers.size.toString()
        flowers.add(flower.copy())
        logger.info("Flower added : [ $flower ] ")
    } else
        logger.info("Flower not added!")

}

fun updateFLower() {
    println("Update FLower")
    println()
    listFlowers()
    var searchFamily = getfamily()
    var aFlower = FlowerModel()
    var tempName : String?
    var tempDescription : String?

    if (aFlower != null) {
        print("Enter a new name for [ " + aFlower.name  + " : ")
        tempName = readLine()!!
    print("Enter a new Description for [ " + aFlower.description + " : ] ")
        tempDescription = readLine()!!
    if (!tempName.isNullOrEmpty() && !tempDescription.isNullOrEmpty()){
        aFlower.name = tempName
        aFlower.description = tempDescription
        println("You updated [ " + aFlower.name + " ] for name and [" + aFlower.description + "] for description")
        logger.info("FLower updated : [ $aFlower ]")
    }
else
    logger.info("Placemark not updated")
} else
    println("Flower not updated..")

}

    fun listFlowers() {
        println("List all Flowers")
        println()
        flowers.forEach { logger.info("${it}") }


    }

    fun searchFlower() {
        var searchFamily = getfamily()
    }

    fun getfamily(): String {
        var familyId: String?
        var searchFamily: String
        print("Enter family name to find flowers : ")
        familyId = readLine()!!
        searchFamily = if (familyId.toLongOrNull() != null && !familyId.isEmpty())
            familyId.toString()
        else
            println("Family not found.. ").toString()
        return searchFamily
    }

    fun search(id: String): FlowerModel? {
        var foundFLower: FlowerModel? = flowers.find { p -> p.id == id }
        return foundFLower

    }
