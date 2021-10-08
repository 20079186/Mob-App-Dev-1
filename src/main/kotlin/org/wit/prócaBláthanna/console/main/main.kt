package org.wit.prócaBláthanna.console.main


import mu.KotlinLogging


private val logger = KotlinLogging.logger{}

fun main(args: Array<String>) {
    logger.info {"Launching Próca Bláthanna App"}
    println("Próca Bláthanna App, for Mobile App Development")

    fun menu() : Int {

        var option : Int
        var input: String? = null

        println("Main Menu")
        println(" 1. Add Flower")
        println("-1. Exit")
        println()
        print("Enter a option")
        input = readLine()!!
        option = input.toInt()

        return option




    }

}
