package com.github.redd.model.reddit;

import com.google.gson.annotations.SerializedName;

public class Subreddit {
    //data about sureddit
    @SerializedName("accounts_active")
    private int accountsActive;
    @SerializedName("comment_score_hide_mins")
    private int commentScoreHideMins;
    @SerializedName("description")
    private String description;
    @SerializedName("description_html")
    private String descriptionHtml;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("header_img")
    private String headerImg;
    //    @SerializedName("header_size")
//    private int[] headerSize;
    @SerializedName("header_title")
    private String headerTitle;
    @SerializedName("over18")
    private Boolean over18;
    @SerializedName("public_description")
    private String publicDescription;
    @SerializedName("public_traffic")
    private Boolean publicTraffic;
    @SerializedName("subscribers")
    private long subscribers;
    @SerializedName("submission_type")
    private String submissionType;
    @SerializedName("submit_link_label")
    private String submitLinkLabel;
    @SerializedName("submit_text_label")
    private String submitTextLabel;
    @SerializedName("subreddit_type")
    private String subredditType;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("user_is_banned")
    private Boolean userIsBanned;
    @SerializedName("user_is_contributor")
    private Boolean userIsContributor;
    @SerializedName("user_is_moderator")
    private Boolean userIsModerator;
    @SerializedName("user_is_subscriber")
    private Boolean userIsSubscriber;
    
}
