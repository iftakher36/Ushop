package com.changetech.ushop.ViewModel;

public class ModelCart {
int productImage,productQuantity,productPrice;
String productTitle;

    public ModelCart(int productImage, int productQuantity, int productPrice, String productTitle) {
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
    }

    public int getProductImage() {
        return productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }
}
