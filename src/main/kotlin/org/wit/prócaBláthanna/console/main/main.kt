package org.wit.prócaBláthanna.console.main


import mu.KotlinLogging
import org.wit.prócaBláthanna.console.controllers.FlowerController
import org.wit.prócaBláthanna.console.models.FlowerJSONStore
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.views.FlowerView


private val logger = KotlinLogging.logger {}


val flowers = FlowerJSONStore()
val flowerView = FlowerView()

fun main(args: Array<String>) {
  FlowerController().start()
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
