package com.guerzonica.app.picodom.components;


import com.guerzonica.app.picodom.components.Graph;

import com.guerzonica.app.storage.models.ProductPrices;


import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;

import javafx.scene.control.ListCell;


public class CellGraph extends ListCell<ProductPrices> {

  @Override
  public void updateItem(ProductPrices item, boolean empty) {

    if(!empty) {
      super.updateItem(item, empty);

      final Graph chart = new Graph(
        new CategoryAxis(),
        new NumberAxis(),
        item
      );
      
      chart.setPrefHeight(200);
      setGraphic(chart);
     
    }

    setPrefHeight(200);

  }

}