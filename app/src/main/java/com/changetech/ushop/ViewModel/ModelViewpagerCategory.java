package com.changetech.ushop.ViewModel;


import java.util.List;

public class ModelViewpagerCategory {
    int image;
    String title;
    Boolean expand=false;
    List<ModelViewpagerSubcategory> modelViewpagerSubcategories;

    public ModelViewpagerCategory(int image, String title, List<ModelViewpagerSubcategory> modelViewpagerSubcategories) {
        this.image = image;
        this.title = title;
        this.modelViewpagerSubcategories = modelViewpagerSubcategories;
    }

    public List<ModelViewpagerSubcategory> getModelViewpagerSubcategories() {
        return modelViewpagerSubcategories;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
