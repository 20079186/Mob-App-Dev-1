package org.wit.prócaBláthanna.console.views


import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.prócaBláthanna.console.controllers.FlowerController

import org.wit.prócaBláthanna.console.controllers.UIController
import tornadofx.*
import kotlin.reflect.KClass

class AddFlowerUI : View("Add Flower") {

    val model = ViewModel()
    val _family = model.bind { SimpleStringProperty() }
    val _name = model.bind { SimpleStringProperty() }
    val _description = model.bind { SimpleStringProperty() }
    val _care = model.bind { SimpleStringProperty() }
    val _season = model.bind { SimpleStringProperty() }

    val UIController: UIController by inject()
    //val FlowerController: FlowerController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Family") {
                textarea(_family).required()
            }
            field("Name") {
                textfield(_name).required()
            }
            field("Description") {
                textarea(_description).required()
            }
            field("Care") {
                textarea(_care).required()
            }
            field("Season") {
                textarea(_season).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        UIController.add(_family.toString(), _name.toString(), _description.toString(), _care.toString(), _season.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        UIController.closeAdd()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _family.value = ""
        _name.value = ""
        _description.value = ""
        _care.value = ""
        _season.value = ""
        model.clearDecorators()
    }
}