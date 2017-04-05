package com.example.android.polynews.models;

/**
 * Created by Jehan on 04/04/2017.
 */

public enum TypeMedia {
    VIDEO(1),
    IMAGE(0);

    private int id;

    TypeMedia(int id){
        this.id = id;
    }

    public static TypeMedia getTypeMediaFromId(int id){
        for(TypeMedia typeMedia: TypeMedia.values()){
            if (typeMedia.id == id){
                return typeMedia;
            }
        }
        return null;
    }
}
