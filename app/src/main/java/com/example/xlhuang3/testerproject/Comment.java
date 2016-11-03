package com.example.xlhuang3.testerproject;

import java.io.Serializable;

/**
 * Created by xlhuang3 on 11/3/2016.
 */
public class Comment implements Serializable {
    public String getCommentPosterId() {
        return CommentPosterId;
    }

    public void setCommentPosterId(String commentPosterId) {
        CommentPosterId = commentPosterId;
    }

    public String getCommentDesc() {
        return CommentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        CommentDesc = commentDesc;
    }

    private String CommentPosterId;
    private String CommentDesc;

    public Comment() {

    }

    public Comment(String commentPosterId, String commentDesc) {
        CommentPosterId = commentPosterId;
        CommentDesc = commentDesc;
    }
}
