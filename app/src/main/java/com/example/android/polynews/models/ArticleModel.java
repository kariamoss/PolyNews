package com.example.android.polynews.models;

import java.text.SimpleDateFormat;

/**
 * Created by Jehan on 22/03/2017.
 */

public class ArticleModel {
    private int id;
    private String title;
    private String content;
    private String author;
    private SimpleDateFormat dateFormat;
    private String date;
    private Category category;
    private TypeMedia typeMedia;
    private String urlMedia;

    public ArticleModel(int id, String title, String content, String author, String date, int category, int typeMedia, String urlMedia) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.category = Category.getCategoryFromId(category);
        this.typeMedia = TypeMedia.getTypeMediaFromId(typeMedia);
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

    public String getDate() {
        return date;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public String getCategory() {
        return category.getName();
    }

    public TypeMedia getTypeMedia() {
        return typeMedia;
    }

    public String getUrlMedia() {
        return urlMedia;
    }

    public String getUrlImageForVideo(){
        if(typeMedia == TypeMedia.VIDEO){
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
