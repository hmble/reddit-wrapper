package com.github.redd.model.reddit;

import com.google.gson.JsonElement;

import java.util.HashMap;

public class Thing {
    // All thing have this attributes

    /**
     * Item's identifier
     */
    private String id;
    /**
     * Fullname
     */
    private String name;
    // String identier that denotes the Object's type.
    private String kind;
    // A custom data structure used to hold valuable information
    private HashMap<String, JsonElement> data;
    public Thing() {
    }

    public HashMap<String, JsonElement> getData() {
        return data;
    }

    public void setData(HashMap<String, JsonElement> data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



}
