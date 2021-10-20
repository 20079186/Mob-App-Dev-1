package org.wit.procaBlathanna.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.scene.Parent
import javafx.scene.layout.VBox
import org.wit.prócaBláthanna.console.main.flowers
import org.wit.prócaBláthanna.console.models.FlowerModel
import org.wit.prócaBláthanna.console.controllers.FlowerController
import org.wit.prócaBláthanna.console.controllers.UIController
import tornadofx.*

class DeleteFlowerUI: View("Delete Flower") {

  //  val FlowerController: FlowerController by inject()
    val UIController: UIController by inject()
    val model = ViewModel()



    override val root = form {
        setPrefSize(400.0, 100.0)
        fieldset(labelPosition = Orientation.VERTICAL) {

        }
        button("Are you sure you want to Delete") {
            enableWhen(model.valid)
            isDefaultButton = true
            useMaxWidth = true
            action {
                runAsyncWithProgress {
//                    UIController.delete()

                }
            }
        }
        button("Cancel") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    UIController.closeDelete()
                }
            }
        }

    }


}
