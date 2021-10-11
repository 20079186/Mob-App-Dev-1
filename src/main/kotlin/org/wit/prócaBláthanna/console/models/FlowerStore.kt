package org.wit.prócaBláthanna.console.models

interface FlowerStore {
    fun findAll(): List<FlowerModel>
    fun findOne(id: Long): FlowerModel?
    fun create(flower: FlowerModel )
    fun update(flower: FlowerModel )
}