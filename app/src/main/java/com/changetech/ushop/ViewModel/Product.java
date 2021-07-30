package com.changetech.ushop.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product{
    @Expose
    @SerializedName("thumbnail")
    private String thumbnail;

    @Expose
    @SerializedName("photo")
    private String photo;

    @Expose
    @SerializedName("price")
    private float price;

    @Expose
    @SerializedName("previous_price")
    private float previous_price;

    @Expose
    @SerializedName("vendor_price")
    private float vendor_price;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("company")
    private String company;

    @Expose
    @SerializedName("union")
    private String union;

    @Expose
    @SerializedName("upazila")
    private String upazila;

    @Expose
    @SerializedName("district")
    private String district;

    @Expose
    @SerializedName("details")
    private String details;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("shop_id")
    private int shop_id;

    @Expose
    @SerializedName("shop_name")
    private String shop_name;

    @Expose
    @SerializedName("views")
    private String views;

    @Expose
    @SerializedName("stock")
    private String stock;

    @Expose
    @SerializedName("rating")
    private String rating;

    @Expose
    @SerializedName("measurement_unit")
    private String measurement_unit;

    @Expose
    @SerializedName("permit_review")
    private boolean permit_review;


    @Expose
    @SerializedName("is_grocery")
    private boolean is_grocery;

    @Expose
    @SerializedName("is_medicine")
    private boolean is_medicine;

    public int getDiscount(){
        int previous_price = getPrevious_price();
        int price = getPrice();

        if(previous_price>0 && previous_price>price){
            return (int)((previous_price-price)*100/previous_price);
        }
        else{
            return 0;
        }
    }

    public String getThumbnail() {
        return "https:"+thumbnail;
    }

    public String getPhoto() {
        return "https:"+photo;
    }

    public int getPrice() {
        return (int) price;
    }

    public int getPrevious_price() {
        try {
            if(previous_price>price){
                return (int) previous_price;
            }
            return -1;
        }
        catch (Exception e){
            return -1;
        }
    }

    public float getVendor_price() {
        try {
            return vendor_price;
        }
        catch (Exception e){
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        if(details != null && !details.equals("null") && !details.isEmpty()){
            return details;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getStock() {
        return stock;
    }

    public String getViews() {
        return views;
    }

    public int getShop_id() {
        return shop_id;
    }

    public float getRating() {
        try{
            return Float.valueOf(rating);
        }
        catch (Exception e){
            return 0.0f;
        }

    }

    public String getMeasurement_unit() {
        return measurement_unit;
    }

    public boolean is_grocery() {
        return is_grocery;
    }

    public String getShop_name() {
        if(shop_name != null && !shop_name.equals("null")){
            return shop_name;
        }
        return "";
    }

    public Product(int id, String name, String photo, float price, float previous_price) {
        this.photo = photo;
        this.price = price;
        this.name = name;
        this.id = id;
        this.previous_price = previous_price;
    }

    public String getCompany() {
        return company;
    }

    public String getUnion() {
        return union;
    }

    public String getUpazila() {
        return upazila;
    }

    public String getDistrict() {
        return district;
    }

    public boolean is_medicine() {
        return is_medicine;
    }

    public boolean isPermit_review() {
        return permit_review;
    }
}
