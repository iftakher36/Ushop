package com.changetech.ushop.ViewModel;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("photo")
    private String photo;

    @SerializedName("image")
    private String image;

    @SerializedName("has_subcategory")
    private boolean has_subcategory;

    @SerializedName("has_childcategory")
    private boolean has_childcategory;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return "https:"+photo;
    }

    public String getImage() {
        return image;
    }

    public Boolean getHas_subcategory() {
        return has_subcategory;
    }

    public Boolean getHas_childcategory() {
        return has_childcategory;
    }

    public Category(int id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }
}
