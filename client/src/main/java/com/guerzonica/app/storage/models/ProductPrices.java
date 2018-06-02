package com.guerzonica.app.storage.models;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

// prices nested in products?
public class ProductPrices {
    public Product product = new Product();
    public ObservableList<Offer> prices = FXCollections.observableArrayList();
}