package com.github.redd.model.reddit;

public class Votable {

    // All Thing that implement votable have these attr
    //Number of upvotes
    private int ups;
    //Number of downvotes
    private int downs;
    // True if thing is liked by user and false is disliked
    // Null if user has not votes.
    // In java we need to use boolean wrapper to support null assignment

    private Boolean likes;

}
