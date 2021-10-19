package org.wit.prócaBláthanna.console.controllers

import mu.KotlinLogging
import org.wit.prócaBláthanna.console.models.FlowerJSONStore
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.views.AddFlowerUI
import org.wit.prócaBláthanna.console.views.DeleteFlowerUI
import org.wit.prócaBláthanna.console.views.FlowerListUI
import org.wit.prócaBláthanna.console.views.MainMenu
import tornadofx.*

    class UIController: Controller() {

        val flowers = FlowerJSONStore()
        val logger = KotlinLogging.logger {}

        init {
            logger.info { "Launching Flower TornadoFX UI App" }
        }
        fun add( _family : String , _name : String , _description : String ,_care : String, _season : String){

            var aFlower = FlowerModel(family = _family, name = _name, description =  _description, care = _care, season = _season)
            flowers.create(aFlower)
            logger.info("Flower Added")
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

        fun loadDeleteScreen(){
            runLater {
                find(FlowerListUI::class).replaceWith(DeleteFlowerUI::class, sizeToScene = true, centerOnScreen = true)

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
