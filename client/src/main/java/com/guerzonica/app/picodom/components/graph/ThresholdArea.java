package com.guerzonica.app.picodom.components.graph;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
* Handles the ThresholdArea on the Graph. It show in a graphich pane, the values provided.
* @author  Matteo Guerzoni
*/
public class ThresholdArea extends StackPane {

    public ThresholdArea(String name, String key, Number value) {
        super();
        final Label label = new Label(key + ": " + value + "$");

            label.getStyleClass().addAll("default0", "chart-line-symbol", "chart-series-line");
            label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getChildren().setAll(label);
                toFront();
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getChildren().clear();
                toBack();

            }
        });

    }

}
