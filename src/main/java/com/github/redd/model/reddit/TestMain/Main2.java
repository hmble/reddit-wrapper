package com.github.redd.model.reddit.TestMain;

import com.github.redd.model.reddit.Comment;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main2 {

    List<Comment> children;

    public static class DMain2 implements JsonDeserializer<Main2> {
        @Override
        public Main2 deserialize(JsonElement jsonElement, Type typeOfT,
                                 JsonDeserializationContext context) throws JsonParseException {
            Gson gson = new Gson();

//            typeOfT = new TypeToken<ArrayList<Comment>>() {
//            }.getType();

            JsonElement jo = jsonElement.getAsJsonArray().get(1)
                    .getAsJsonObject()
                    .get("data")
                    .getAsJsonObject().get("children").getAsJsonArray();
//            JsonObject jo2 = ((JsonObject) jo).get("data").getAsJsonObject();


            Main2 main2 = gson.fromJson(jo, Main2.class);


            return main2;
        }
    }

    public static void doing() throws FileNotFoundException {

        final String RELATIVE_PATH = "/home/hmble/Documents/Github/reddit-wrapper/src/main/java/com/github/redd/model/reddit/json/";
        final String PATH = RELATIVE_PATH + "test.json";

        BufferedReader br = new BufferedReader(new FileReader(PATH));

        Gson g = new GsonBuilder()
                .registerTypeAdapter(Main2.class,new Main2.DMain2())
                .create();

//        Type mainType = new TypeToken<ArrayList<Comment>>(){}.getType();
        Main2 m2 = g.fromJson(br,Main2.class);







    }




    public static void main(String[] args) throws FileNotFoundException {
        doing();
    }
}


/**
 *
 JsonParser parser = new JsonParser();

 JsonElement je = parser.parse(br);

 // Lets parse through parsers and get comments

 Type commentType = new TypeToken<List<Comment>>(){}.getType();

 //        System.out.println(je.isJsonNull());
 if(!je.isJsonNull() && je.isJsonArray()){
 JsonElement jo = je.getAsJsonArray().get(1)
 .getAsJsonObject()
 .get("data")
 .getAsJsonObject().get("children").getAsJsonArray().get(0).getAsJsonObject();
 JsonObject jo2 = ((JsonObject) jo).get("data").getAsJsonObject();

 //            String je2 = ;
 for(Map.Entry<String, JsonElement> entry : jo2.entrySet()) {
 System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue() );

 }
 */
