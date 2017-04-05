package com.example.android.polynews.models;

/**
 * Created by Jehan on 04/04/2017.
 */

public enum Category {
    POLITIQUE(1, "Politique"),
    SOCIETE(2, "Société");

    private int id;
    private String name;

    Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static Category getCategoryFromId(int id){
        for(Category category: Category.values()){
            if (category.id == id){
                return category;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
