package com.github.redd.auth.param;

public enum Scope {
    IDENTITY("identity"),
    EDIT("edit"),
    FLAIR("flair"),
    HISTORY("history"),
    MODCONFIG("modconfig"),
    MODFLAIR("modflair"),
    MODLOG("modlog"),
    MODPOSTS("modposts"),
    MODWIKI("modwiki"),
    MYSUBREDDITS("mysubreddits"),
    PRIVATEMESSAGE("privatemessages"),
    READ("read"),
    REPORT("report"),
    SAVE("save"),
    SUBMIT("submit"),
    SUBSCRIBE("subscribe"),
    VOTE("vote"),
    WIKIEDIT("wikiedit"),
    WIKIREAD("wikiread");

    private final String value;

    Scope(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
