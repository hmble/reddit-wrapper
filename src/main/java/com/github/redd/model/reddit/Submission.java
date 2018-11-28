package com.github.redd.model.reddit;

import com.google.gson.annotations.SerializedName;

public class Submission {
    // Implements votable and created
    @SerializedName("author")
    private String author;
    @SerializedName("author_flarir_css_class")
    private String authorFlarirCssClass;
    @SerializedName("author_flair_text")
    private String authorFlairText;
    @SerializedName("clicked")
    private Boolean clicked;
    @SerializedName("domain")
    private String domain;
    @SerializedName("hidden")
    private Boolean hidden;
    @SerializedName("is_self")
    private Boolean isSelf;
    @SerializedName("likes")
    private Boolean likes;
    @SerializedName("link_flair_css_class")
    private String linkFlairCssClass;
    @SerializedName("link_flair_text")
    private String linkFlairText;
    @SerializedName("locked")
    private Boolean locked;
    @SerializedName("media")
    private Object media;
    @SerializedName("media_embed")
    private Object mediaEmbed;
    @SerializedName("num_comments")
    private int numComments;
    @SerializedName("over_18")
    private Boolean over18;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("saved")
    private Boolean saved;
    @SerializedName("score")
    private int score;
    @SerializedName("selftext")
    private String selftext;
    @SerializedName("selftext_html")
    private String selftextHtml;
    @SerializedName("subreddit")
    private String subreddit;
    @SerializedName("subreddit_id")
    private String subredditId;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
//    @SerializedName("edited")
//    private long edited;
    @SerializedName("distinguished")
    private String distinguished;
    @SerializedName("stickied")
    private Boolean stickied;

    public Submission() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorFlarirCssClass() {
        return authorFlarirCssClass;
    }

    public void setAuthorFlarirCssClass(String authorFlarirCssClass) {
        this.authorFlarirCssClass = authorFlarirCssClass;
    }

    public String getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(String authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Boolean getClicked() {
        return clicked;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getSelf() {
        return isSelf;
    }

    public void setSelf(Boolean self) {
        isSelf = self;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public String getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(String linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public String getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(String linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public Object getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(Object mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public long getEdited() {
//        return edited;
//    }

//    public void setEdited(long edited) {
//        this.edited = edited;
//    }

    public String getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(String distinguished) {
        this.distinguished = distinguished;
    }

    public Boolean getStickied() {
        return stickied;
    }

    public void setStickied(Boolean stickied) {
        this.stickied = stickied;
    }


}
