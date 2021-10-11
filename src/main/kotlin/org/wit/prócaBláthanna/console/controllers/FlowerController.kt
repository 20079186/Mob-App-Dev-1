package org.wit.prócaBláthanna.console.controllers

import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerJSONStore
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.views.FlowerView

class FlowerController {

    val flowers = FlowerJSONStore()
    val flowerView = FlowerView()
    val logger = KotlinLogging.logger{}

    init {
        logger.info { "Launching Próca Bláthanna Console App" }
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()

                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Próca Bláthanna Console App" }
    }


    fun menu() :Int { return flowerView.menu()}

    fun add(){
        var aFlower = FlowerModel()

        if (flowerView.addFlowerData(aFlower))
            flowers.create(aFlower)
        else
            logger.info("Placemark Not Added")
    }

    fun list() {
        flowerView.listFlowers(flowers)
    }

    fun update() {

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

    fun search() {
        val aFlower = search(flowerView.getId())!!
        flowerView.showFlower(aFlower)
    }


    fun search(id: Long) : FlowerModel? {
        var foundFlower = flowers.findOne(id)
        return foundFlower
    }


}