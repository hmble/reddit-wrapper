package com.github.redd.model.reddit;

public enum Kind {
    COMMENT("t1"),
    ACCOUNT("t2"),
    LINK("t3"),
    MESSAGE("t4"),
    SUBREDDIT("t5"),
    AWARD("t6"),
    PROMO_CAMPAIGN("t8"),
    MORE("more"),
    LISTING("listing");

    private String value;

    Kind(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

//    public static String match(String t) {
//
//        for(Kind k : Kind.values()) {
//            if(k.getValue().equals(t)) return t;
//        }
//        return null;
//    }

}
