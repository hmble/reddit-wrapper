package com.github.redd.model.reddit.TestMain;

import com.github.redd.model.reddit.Comment;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CommentTest {

    public static void doing() throws FileNotFoundException {

        final String RELATIVE_PATH = "/home/hmble/Documents/Github/reddit-wrapper/src/main/java/com/github/redd/model/reddit/json/";
        final String PATH = RELATIVE_PATH + "comments.json";

        BufferedReader br = new BufferedReader(new FileReader(PATH));


    }

    public static void main(String[] args) throws FileNotFoundException {
        doing();
    }
}
