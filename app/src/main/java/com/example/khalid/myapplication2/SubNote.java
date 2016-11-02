package com.example.khalid.myapplication2;

import java.math.BigDecimal;

/**
 * Created by 1772 on 10/6/2016.
 */

public class SubNote {
    private String title, briefDescription, fullDescription;
    private long productId, dateCreatedMilli;
    BigDecimal price;
    private int [] productImages;
    private Category category;
    public enum Category {HEALTHCARE, CARDIAC, DENTAL, RESPIRATORY, PHARMA}

    public SubNote(String title, String briefDescription, String fullDescription, BigDecimal price, int [] productImages){
        this.title = title;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.productId = 0;
        this.dateCreatedMilli = 0;
        this.price = price;
        this.category = category;
        this.productImages = productImages;

    }

    public SubNote(String title, String briefDescription, String fullDescription, Category category, BigDecimal price, long productId, long dateCreatedMilli, int [] productImages){
        this.title = title;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.productId = productId;
        this.dateCreatedMilli = dateCreatedMilli;
        this.price = price;
        this.category = category;
        this.productImages = productImages;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public long getProductId() {
        return productId;
    }

    public long getDateCreatedMilli() {
        return dateCreatedMilli;
    }

    public int[] getProductImages() {
        return productImages;
    }

    public String toString(){
        return "Product ID:  " + productId + "Created on:  " + dateCreatedMilli + " Title: " + title + " IconID: " + category.name() + "Price: " + price;
    }

    /*
       public int getAssDrable (){
       return categoryToDrawable(category);
       }
       */

    /*public static int categoryToDrawable (Category noteCategory){

        switch (noteCategory){
            case HEALTHCARE:
                return R.drawable.defualt_img;
            case CARDIAC:
                return R.drawable.defualt_img;
            case PHARMA:
                return R.drawable.defualt_img;
            case RESPIRATORY:
                return R.drawable.defualt_img;
            case DENTAL:
                return R.drawable.defualt_img;
        }
        return R.drawable.defualt_img;
    }*/
}
