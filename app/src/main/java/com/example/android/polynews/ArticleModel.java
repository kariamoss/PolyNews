package com.example.android.polynews;

import android.provider.MediaStore;

import java.util.Date;

/**
 * Created by Jehan on 22/03/2017.
 */

public class ArticleModel {
    private int id;
    private String title;
    private String content;
    private String author;
    private Date date;
    private String category;
    private TypeMedia typeMedia;
    private String urlMedia;

    public ArticleModel(int id, String title, String content, String author, Date date, String category, TypeMedia typeMedia, String urlMedia) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category = category;
        this.typeMedia = typeMedia;
        this.urlMedia = urlMedia;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public TypeMedia getTypeMedia() {
        return typeMedia;
    }

    public String getUrlMedia() {
        return urlMedia;
    }

    public String getUrlImageForVideo(){
        if(typeMedia == TypeMedia.VIDEO){
            String op = getIdVideo();
            return "http://img.youtube.com/vi/" + getIdVideo() + "/default.jpg";
        }
        return null;
    }

    public String getIdVideo(){
        if(typeMedia == TypeMedia.VIDEO){
            return  urlMedia.substring(urlMedia.indexOf('=')+1);
        }
        return null;
    }

    @Override
    public String toString(){
        return title;
    }
}
