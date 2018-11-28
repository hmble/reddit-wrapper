package com.github.redd.model.reddit;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {
    
    // Implements created

    @SerializedName("created")
    private String created;
    @SerializedName("created_utc")
    private String createdUtc;


    @SerializedName("comment_karma")
    private int commentKarma;

    @SerializedName("has_mail")
    private Boolean hasMail;

    @SerializedName("has_mod_mail")
    private Boolean hasModMail;

    @SerializedName("has_verified_email")
    private Boolean hasVerifiedEmail;

    @SerializedName("id")
    private String id;

    @SerializedName("inbox_count")
    private int inboxCount;

    @SerializedName("is_friend")
    private Boolean isFriend;

    @SerializedName("is_gold")
    private Boolean isGold;

    @SerializedName("link_karma")
    private int linkKarma;

    // Will not get if not your account
    @SerializedName("modhash")
    private String modhash;

    @SerializedName("name")
    private String name;

    @SerializedName("over_18")
    private Boolean over18;

    //TODO: Need to add more fields by looking at json
    //has_subscribed

    public int getCommentKarma() {
        return commentKarma;
    }

    public Boolean getHasMail() {
        return hasMail;
    }

    public Boolean getHasModMail() {
        return hasModMail;
    }

    public Boolean getHasVerifiedEmail() {
        return hasVerifiedEmail;
    }

    public String getId() {
        return id;
    }

    public int getInboxCount() {
        return inboxCount;
    }

    public Boolean getFriend() {
        return isFriend;
    }

    public Boolean getGold() {
        return isGold;
    }

    public int getLinkKarma() {
        return linkKarma;
    }

    public String getModhash() {
        return modhash;
    }

    public String getName() {
        return name;
    }

    public Boolean getOver18() {
        return over18;
    }

    public Account() {
    // left empty becuase I don't know what to do here

    }



    public static void main(String[] args) throws FileNotFoundException {
//        BufferedReader br
        final String RELATIVE_PATH = "/home/hmble/Documents/Github/reddit-wrapper/src/main/java/com/github/redd/model/reddit/json/";
        final String PATH = RELATIVE_PATH + "api_v1_me.json";

        BufferedReader br = new BufferedReader(new FileReader(PATH));

        Account account = new Gson().fromJson(br,Account.class);
        System.out.println(account.getName());

        System.out.println("Total Karma of " + account.getName() + " is : " + (account.getCommentKarma() + account.getLinkKarma()) );
    }

}
