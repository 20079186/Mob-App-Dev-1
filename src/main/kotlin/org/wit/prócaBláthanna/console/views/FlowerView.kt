package org.wit.prócaBláthanna.console.views

import org.wit.prócaBláthanna.console.main.flowerView
import org.wit.prócaBláthanna.console.main.flowers
import org.wit.prócaBláthanna.console.models.FlowerJSONStore
import org.wit.prócaBláthanna.console.models.FlowerMemStore
import org.wit.prócaBláthanna.console.models.FlowerModel

class FlowerView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Flower")
        println(" 2. Update Flower")
        println(" 3. List All Flower")
        println(" 4. Search Flower")
        println(" 5. Delete Flower")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listFlowers(flowers: FlowerJSONStore) {
        println("List All Flowers")
        println()
        flowers.logAll()
        println()
    }

    fun showFlower(flower : FlowerModel) {
        if(flower != null)
            println("Flower Details [ $flower ]")
        else
            println("Flower Not Found...")
    }

    fun addFlowerData(flower : FlowerModel) : Boolean {

        println()
        print("Flower Family..")
        flower.family = readLine()!!
        print("Enter a Title : ")
        flower.name = readLine()!!
        print("Enter a Description : ")
        flower.description = readLine()!!
        print("How to care for...")
        flower.care = readLine()!!
        print("Flower's Season..")
        flower.season = readLine()!!

        return flower.family.isNotEmpty() && flower.name.isNotEmpty() && flower.description.isNotEmpty() && flower.care.isNotEmpty() && flower.season.isNotEmpty()
    }

    fun updateFlowerData(flower : FlowerModel) : Boolean {
        var tempFamily: String?
        var tempName: String?
        var tempDescription: String?
        var tempCare: String?
        var tempSeason: String?

        if (flower!= null) {
            print("Enter a new Family name [ " + flower.family + " ] : ")
            tempFamily = readLine()!!
            print("Enter a new Title for [ " + flower.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Description for [ " + flower.description + " ] : ")
            tempDescription = readLine()!!
            print("Enter nee details on how to care [ " + flower.care + " ] : ")
            tempCare = readLine()!!
            print("Enter the Flower's new season [ " + flower.season + " ] : ")
            tempSeason = readLine()!!

            print("")

            if (!tempFamily.isNullOrEmpty() && !tempName.isNullOrEmpty() && !tempDescription.isNullOrEmpty() && !tempCare.isNullOrEmpty() && !tempSeason.isNullOrEmpty()) {
                flower.family = tempFamily
                flower.name = tempName
                flower.description = tempDescription
                flower.care = tempCare
                flower.season = tempSeason
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update/ Delete: ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}