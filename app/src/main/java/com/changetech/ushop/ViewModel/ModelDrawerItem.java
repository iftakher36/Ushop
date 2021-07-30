package com.changetech.ushop.ViewModel;

public class ModelDrawerItem {
    int image;
    String drawerItem;

    public ModelDrawerItem(int image, String drawerItem) {
        this.image = image;
        this.drawerItem = drawerItem;
    }

    public int getImage() {
        return image;
    }

    public String getDrawerItem() {
        return drawerItem;
    }
}
