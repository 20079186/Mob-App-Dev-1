package org.wit.prócaBláthanna.console.main


import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerMemStore
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.views.FlowerView


private val logger = KotlinLogging.logger {}


val flowers = FlowerMemStore()
val flowerView = FlowerView()

fun main(args: Array<String>) {
    logger.info { "Launching PrócaBláthanna Console App" }


    var input: Int

    do {
        input = flowerView.menu()
        when (input) {
            1 -> addFlower()
            2 -> updateFLower()
            3 -> flowerView.listFlowers(flowers)
            4 -> searchFlower()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down PrócaBláthanna Console App" }
}


fun addFlower(){
    var aFlower = FlowerModel()

    if (flowerView.addFlowerData(aFlower))
        flowers.create(aFlower)
    else
        logger.info("Flower Not Added")
}


fun updateFLower() {
    flowerView.listFlowers(flowers)
    var searchId = flowerView.getId()
    val aFlower = search(searchId)

    if(aFlower != null) {
        if(flowerView.updateFlowerData(aFlower)) {
            flowers.update(aFlower)
            flowerView.showFlower(aFlower)
            logger.info("Flower Updated : [ $aFlower ]")
        }
        else
            logger.info("Flower Not Updated")
    }
    else
        println("Flower Not Updated...")
}

    fun searchFlower() {
        val aFlower = search(flowerView.getId())!!
        flowerView.showFlower(aFlower)
    }

    fun search(id: Long): FlowerModel? {
        var foundFlower: FlowerModel? = flowers.findOne(id)
        return foundFlower

    }
