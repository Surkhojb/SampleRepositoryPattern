package com.example.surkhojb.samplerepositorypattern.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 24/9/18.
 */

public class Comment {

    @SerializedName("postId")
    @Expose
    private int postId;

    @SerializedName("id")
    @Expose
    private int commenId;

    @SerializedName("name")
    @Expose
    private String commentName;

    @SerializedName("email")
    @Expose
    private String commentEmail;

    @SerializedName("body")
    private String commentBody;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommenId() {
        return commenId;
    }

    public void setCommenId(int commenId) {
        this.commenId = commenId;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
