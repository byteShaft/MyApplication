package com.example.khalid.myapplication2;

/**
 * Created by 1772 on 10/6/2016.
 */

public class Note {
    private String title;
    private Category category;
    public enum Category {HEALTHCARE, CARDIAC, DENTAL, RESPIRATORY, PHARMA}

    public Note(String title, Category category){
        this.title = title;
        this.category = category;

    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }



    public String toString(){
        return " Title: " + title + " IconID: " + category.name();
    }

    public int getAssDrable (){
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable (Category noteCategory){

        switch (noteCategory){
            case HEALTHCARE:
                return R.drawable.healthcare_final;
            case CARDIAC:
                return R.drawable.cardiac_final;
            case PHARMA:
                return R.drawable.pharma_final;
            case RESPIRATORY:
                return R.drawable.respiratory_final;
            case DENTAL:
                return R.drawable.dental_final;
        }
        return R.drawable.cate_default;
    }
}
