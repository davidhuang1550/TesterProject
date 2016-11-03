package com.example.xlhuang3.testerproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xlhuang3 on 11/3/2016.
 */
public class Post implements Serializable{

    private int No;
    private int Yes;
    private String PosterId;
    private String Title;
    private String key;
    private String Description;
    private ArrayList<Comment> comments;
    Post(){

    }

    Post(String key, int no, int yes, String posterId, String title, ArrayList<Comment> comments, String description){

        this.key = key;
        No = no;
        Yes = yes;
        PosterId = posterId;
        Title = title;
        this.comments = comments;
        Description = description;
    }
    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getYes() {
        return Yes;
    }

    public void setYes(int yes) {
        Yes = yes;
    }

    public String getPosterId() {
        return PosterId;
    }

    public void setPosterId(String posterId) {
        PosterId = posterId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
