package com.github.redd.model.reddit;

import com.google.gson.annotations.SerializedName;

public class LinkFlair {
    @SerializedName("text")
    private String text;
    @SerializedName("css_class")
    private String cssClass;

    public LinkFlair() {
    }

    public String getText() {
        return text;
    }

    public String getCssClass() {
        return cssClass;
    }
}
