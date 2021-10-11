package org.wit.prócaBláthanna.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging

import org.wit.prócaBláthanna.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "flowers.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<FlowerModel>>(){}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class FlowerJSONStore : FlowerStore
{
    var flowers = mutableListOf<FlowerModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<FlowerModel> {
        return flowers
    }

    override fun findOne(id: Long) : FlowerModel? {
        var foundFlower: FlowerModel? = flowers.find { p -> p.id == id }
        return foundFlower
    }

    override fun create(flower: FlowerModel) {
        flower.id = generateRandomId()
        flowers.add(flower)
        serialize()
    }

    override fun update(flower: FlowerModel) {
        var foundFlower = findOne(flower.id!!)
        if (foundFlower != null) {
            foundFlower.name = flower.name
            foundFlower.description = flower.description
        }
        serialize()
    }

    internal fun logAll() {
        flowers.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(flowers, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        flowers = Gson().fromJson(jsonString, listType)
    }
}



