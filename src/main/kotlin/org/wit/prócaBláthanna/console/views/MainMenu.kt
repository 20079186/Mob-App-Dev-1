package org.wit.prócaBláthanna.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.prócaBláthanna.console.controllers.UIController
import tornadofx.*

class MainMenu : View("PrócaBláthanna Main Menu") {

    init {
        reloadViewsOnFocus()
    }

    val UIController: UIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Flower") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    openInternalWindow<AddFlowerUI>()
                   // runAsyncWithProgress {
                  //      UIController.loadAddScreen()
                  //  }
                }
            }
            text("")
            button("List Flowers") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        UIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }


}