package org.wit.prócaBláthanna.console.controllers

import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerJSONStore
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.views.AddFlowerUI
import org.wit.prócaBláthanna.console.views.FlowerListUI
import org.wit.prócaBláthanna.console.views.MainMenu
import tornadofx.*

    class UIController: Controller() {

        val flowers = FlowerJSONStore()
        val logger = KotlinLogging.logger {}

        init {
            logger.info { "Launching Flower TornadoFX UI App" }
        }
        fun addFlower(){

            var aFlower = FlowerModel()
            flowers.create(aFlower)
            logger.info("Placemark Added")
        }

        fun loadListScreen() {
            runLater {
                find(MainMenu::class).replaceWith(FlowerListUI::class, sizeToScene = true, centerOnScreen = true)
            }
            flowers.logAll()
        }

        fun loadAddScreen() {
            runLater {
                find(MainMenu::class).replaceWith(AddFlowerUI::class, sizeToScene = true, centerOnScreen = true)
            }
        }

        fun closeAdd() {
            runLater {
                find(AddFlowerUI::class).replaceWith(MainMenu::class, sizeToScene = true, centerOnScreen = true)
            }
        }

        fun closeList() {
            runLater {
                find(FlowerListUI::class).replaceWith(MainMenu::class, sizeToScene = true, centerOnScreen = true)
            }
        }



    }
