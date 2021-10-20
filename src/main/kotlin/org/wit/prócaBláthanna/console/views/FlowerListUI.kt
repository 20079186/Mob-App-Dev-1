package org.wit.prócaBláthanna.console.views

import org.wit.prócaBláthanna.console.controllers.UIController
import org.wit.prócaBláthanna.console.models.FlowerModel
import tornadofx.*


    class FlowerListUI : View("List Flowers") {

        val UIController: UIController by inject()
        val tableContent = UIController.flowers.findAll()
        val data = tableContent.observable()


        override val root = vbox {
            setPrefSize(600.0, 200.0)
            tableview(data) {
                readonlyColumn("ID", FlowerModel::id)
                readonlyColumn("NAME", FlowerModel::name)
                readonlyColumn("DESCRIPTION", FlowerModel::description)
                readonlyColumn("FAMILY", FlowerModel::family)
                readonlyColumn("CARE", FlowerModel::care)
                readonlyColumn("SEASON", FlowerModel::season)
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        UIController.closeList()
                    }
                }
            }
        }

    }
