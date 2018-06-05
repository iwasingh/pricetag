package com.guerzonica.app.picodom.components.field;

import com.guerzonica.app.http.interfaces.RequestHandler;
import com.guerzonica.app.http.models.AmazonResponse;
import com.guerzonica.app.picodom.components.field.SearchField;
import com.guerzonica.app.storage.ProductsProvider;
import com.guerzonica.app.storage.models.Offer;
import com.guerzonica.app.storage.models.Product;

import io.reactivex.functions.Consumer;

public class AmazonSearchField extends SearchField {

  public AmazonSearchField() {

    super("ASIN Prodotto");
    this.getActionButton().setOnAction(action -> {
      String content = getContent();
      clear();
      try {
        ProductsProvider provider = ProductsProvider.getProvider();

          provider.fetchAmazonHttp(content, new RequestHandler () {

            @Override
            public void handle(String data) {
              try {
                Offer item = AmazonResponse.parse(data);

                provider.addProduct(item.getProduct(), true)
                  .subscribe(
                    new Consumer<Product>() {

                      @Override
                      public void accept(Product t) throws Exception {
                        if(t.getId() != null)
                          provider.addPrice(item, true).subscribe();
                      }

                    }
                  );

              } catch (Exception e) { e.printStackTrace(); }
            }

          });

      } catch (Exception e) { e.printStackTrace(); }

    });

  }

}