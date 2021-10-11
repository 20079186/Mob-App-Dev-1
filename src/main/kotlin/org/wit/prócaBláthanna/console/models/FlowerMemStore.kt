package org.wit.prócaBláthanna.console.models

import mu.KotlinLogging


private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}
class FlowerMemStore : FlowerStore {

    val flowers = ArrayList<FlowerModel>()

    override fun findAll(): List<FlowerModel> {
        return flowers
    }

    override fun findOne(id: Long) : FlowerModel? {
        var foundFlower: FlowerModel? = flowers.find { p -> p.id == id }
        return foundFlower
    }

    override fun create(flower: FlowerModel) {
        flower.id = getId()
        flowers.add(flower)
        logAll()
    }

    override fun update(flower: FlowerModel) {
        var foundFlower = findOne(flower.id!!)
        if (foundFlower != null) {
            foundFlower.name = flower.name
            foundFlower.description = flower.description
        }
    }

    internal fun logAll() {
        flowers.forEach { logger.info("${it}") }
    }
}