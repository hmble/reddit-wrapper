package com.github.redd.model.reddit;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

//import java.util.List;

public class Comment {
    // Implements votable and created
    @SerializedName("approved_by")
    private String approvedBy;
    private String author;
    @SerializedName("author_flair_css_class")
    private String aFlairCss;
    @SerializedName("author_flair_text")
    private String aFlairText;
    @SerializedName("banned_by")
    private String bannedBy;
    private String body;
    @SerializedName("body_html")
    private String bodyHtml;
    //It is special when true can be set to utc
//    private Boolean edited;
    private int gilded;
    // boolean liked it is used in votable
    @SerializedName("link_author")
    private String linkAuthor;
    @SerializedName("link_id")
    private String linkId;
    @SerializedName("link_title")
    private String linkTitle;
    @SerializedName("link_url")
    private String linkUrl;
    @SerializedName("num_reports")
    private int numReports;
    @SerializedName("parent_id")
    private String parentId;

    private Boolean saved;
    private int score;
    @SerializedName("score_hidden")
    private Boolean scoreHidden;
    private String subreddit;
    @SerializedName("subreddit_id")
    private String subredditId;
    @JsonAdapter(DReplies.class)
    private Comment replies;

    public void setReplies(Comment replies) {
        this.replies = replies;
    }

    public Comment getReplies() {
        return replies;
    }

    public Comment() {
    }



    public String getApprovedBy() {
        return approvedBy;
    }

    public String getAuthor() {
        return author;
    }

    public String getaFlairCss() {
        return aFlairCss;
    }

    public String getaFlairText() {
        return aFlairText;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public String getBody() {
        return body;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

//    public Boolean getEdited() {
//        return edited;
//    }

    public int getGilded() {
        return gilded;
    }

    public String getLinkAuthor() {
        return linkAuthor;
    }

    public String getLinkId() {
        return linkId;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public int getNumReports() {
        return numReports;
    }

    public String getParentId() {
        return parentId;
    }


    public Boolean getSaved() {
        return saved;
    }

    public int getScore() {
        return score;
    }

    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setaFlairCss(String aFlairCss) {
        this.aFlairCss = aFlairCss;
    }

    public void setaFlairText(String aFlairText) {
        this.aFlairText = aFlairText;
    }

    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

//    public void setEdited(Boolean edited) {
//        this.edited = edited;
//    }

    public void setGilded(int gilded) {
        this.gilded = gilded;
    }

    public void setLinkAuthor(String linkAuthor) {
        this.linkAuthor = linkAuthor;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }


    // TODO : Maybe move this method to parser class.
    public static List<Comment> parseData(BufferedReader br) {
        Type tc = new TypeToken<ArrayList<Comment>>() {
        }.getType();


        Gson g = new GsonBuilder()
                .registerTypeAdapter(tc, new DComment())
                .create();
        List<Comment> commentList = g.fromJson(br, tc);

        return commentList;
    }
    public static void rec(Comment c,List<String> innerTree){

        if(c.getReplies() !=null){
            innerTree.add(c.getAuthor());
            rec(c.getReplies(),innerTree);
        }
//        else{
//            String output = "replies is null and count is: " + count;
//
//        }

    }

    //    private String distinguished
    public static void doing() throws FileNotFoundException {
        final String RELATIVE_PATH = "/home/hmble/Documents/Github/reddit-wrapper/src/main/java/com/github/redd/model/reddit/json/";
        final String PATH = RELATIVE_PATH + "comments.json";

        BufferedReader br = new BufferedReader(new FileReader(PATH));

        List<Comment> c2 = parseData(br);

//        Comment outer = c2.get(0);
//        Comment inner = outer.getReplies();
//        System.out.println("Comments size: " + c2.size());
//        System.out.println("Author of Top Level: "+ outer.getAuthor());
//        System.out.println("Authod of next child: " + inner.getAuthor());
        System.out.println("Top level Comments: ");
        List<List<String>> authorTree = new ArrayList<>();
        for (Comment c: c2){
//            String padding = "";
            List<String> innerTree = new ArrayList<>();
            innerTree.add(c.getAuthor());
            rec(c,innerTree);
            authorTree.add(innerTree);
        }

        authorTree.forEach(e-> System.out.println(Arrays.toString(e.toArray())));

    }
    public static void main(String[] args) throws FileNotFoundException {
        doing();

    }
    public static class DComment implements JsonDeserializer<List<Comment>> {
        @Override
        public List<Comment> deserialize(JsonElement jsonElement, Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {


            //Here...
            //TODO: Try if it doesn't return List same as LinkFlair class.
            List<Comment> comments = new ArrayList<>();
            if (jsonElement.isJsonArray()) {
                JsonElement j = jsonElement.getAsJsonArray().get(1)
                        .getAsJsonObject()
                        .getAsJsonObject("data").getAsJsonArray("children");

                if(!j.isJsonNull() && j.isJsonArray()) {
                    for(JsonElement je : (JsonArray)j) {
                        JsonObject jsonObject = je.getAsJsonObject().getAsJsonObject("data");


                        Gson gsn = new Gson();
                        Comment comment = gsn.fromJson(jsonObject,Comment.class);
                        comments.add(comment);
                    }

                }

            }
            return comments;
        }
    }

    // Another deserialzer
    public static class DComment2 implements JsonDeserializer<Comment> {
        @Override
        public Comment deserialize(JsonElement jsonElement, Type typeOfT,
                                         JsonDeserializationContext context) throws JsonParseException {


            //Here...
            //TODO: Try if it doesn't return List same as LinkFlair class.

            Comment comment = null;


            return comment;
        }
    }

    public static class DReplies implements JsonDeserializer<Comment> {
        @Override
        public Comment deserialize(JsonElement jsonElement, Type typeOfT,
                                         JsonDeserializationContext context) throws JsonParseException {
//            JsonElement replies = jsonElement.getAsJsonObject().get("replies");
//            if (replies != null && replies.isJsonPrimitive()){
//                JsonPrimitive primitiv = replies.getAsJsonPrimitive();
//                if (primitiv.isString()) {
//                    jsonElement.getAsJsonObject().remove("replies");
//                }
//            }

            Gson gsn = new Gson();
            if(jsonElement.isJsonObject()){
                JsonElement j = jsonElement.getAsJsonObject().getAsJsonObject("data").getAsJsonArray("children").get(0);
                JsonObject jsonData = j.getAsJsonObject().getAsJsonObject("data");


                Comment comment = context.deserialize(jsonData,Comment.class);
                return comment;
            }
            return null;


        }
    }

}

/**
 JsonElement jo = jsonElement.getAsJsonArray().get(1)
 .getAsJsonObject()
 .get("data")
 .getAsJsonObject().get("children").getAsJsonArray().get(0);//I passed only one comment object
 JsonElement jo2 = jo.getAsJsonObject().get("data");
 */

