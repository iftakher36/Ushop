package com.changetech.ushop.ViewModel;

public class ProfileGiftItem {
    int regularRate,specialRate,productImage;

    public ProfileGiftItem(int regularRate, int specialRate, int productImage) {
        this.regularRate = regularRate;
        this.specialRate = specialRate;
        this.productImage = productImage;
    }

    public int getRegularRate() {
        return regularRate;
    }

    public int getSpecialRate() {
        return specialRate;
    }

    public int getProductImage() {
        return productImage;
    }
}
