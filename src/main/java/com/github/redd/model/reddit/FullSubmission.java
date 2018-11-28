package com.github.redd.model.reddit;

import com.github.redd.model.reddit.TestMain.Main2;
import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FullSubmission {

    Submission submission;
//    @JsonAdapter(Comment.DComment.class)
    List<Comment> comments;

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public FullSubmission() {
    }

    public static void doing() throws FileNotFoundException {

        final String RELATIVE_PATH = "/home/hmble/Documents/Github/reddit-wrapper/src/main/java/com/github/redd/model/reddit/json/";
        final String PATH = RELATIVE_PATH + "comments.json";

        BufferedReader br = new BufferedReader(new FileReader(PATH));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(FullSubmission.class, new FullSubmission.DFullSubmission())
                .create();

        FullSubmission fs = gson.fromJson(br,FullSubmission.class);

        Submission submission = fs.getSubmission();
        List<Comment> comments = fs.getComments();

    }


    public static void main(String[] args) throws FileNotFoundException {
        doing();

    }

    public static class DFullSubmission implements JsonDeserializer<FullSubmission> {
        @Override
        public FullSubmission deserialize(JsonElement jsonElement, Type typeOfT,
                                          JsonDeserializationContext context) throws JsonParseException {

            FullSubmission fullSubmission = new FullSubmission();
            List<Comment> commentList =  new ArrayList<>();
            if(!jsonElement.isJsonNull() && jsonElement.isJsonArray()) {

                for(JsonElement j : jsonElement.getAsJsonArray()) {
                    JsonArray array = j.getAsJsonObject().getAsJsonObject("data")
                            .getAsJsonArray("children");
                    for(JsonElement j2: array){
                        JsonObject data = j2.getAsJsonObject().getAsJsonObject("data");
                        String kind = j2.getAsJsonObject().
                                getAsJsonPrimitive("kind").getAsString();

                        if(kind.equals("t3")) {
                            Submission s = context.deserialize(data, Submission.class);
                            fullSubmission.setSubmission(s);
                        }
                        // we should check size of children array
                        if(kind.equals("t1")) {
                            Comment comment = context.deserialize(data, Comment.class);
                            commentList.add(comment);
                        }
                    }
                }
                fullSubmission.setComments(commentList);
            }
            return fullSubmission;
        }
    }
}
