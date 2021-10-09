package org.wit.prócaBláthanna.console.models

interface FlowersMemStore {
    fun findAll(): List<FlowerModel>
    fun fineOne(id: String): FlowerModel?
    fun create(flower: FlowerModel )
    fun update(flower: FlowerModel )
}