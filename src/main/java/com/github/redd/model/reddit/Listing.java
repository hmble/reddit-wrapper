
package com.github.redd.model.reddit;

import java.util.List;

public abstract class Listing<T> {
    /**
     * Used to paginate content that is too long to display in
     * one go. Query argument like before and after are used to
     * paginate. This is usually used in conjunction with count
     * argument.
     *
     * Exception: It is not a subclass of Thing.  Although it
     * does have data and kind as parameters. It does not
     * have id and name.
     */

    // The fullname of listing that follows before page.
    private String before;
    // The fullname of the listing that follows after this page.
   private String after;
   // You can use modhash given upon login.
    private String modhash;
    //List of thing that this Listing wraps
    private List<Thing> children;

    public Listing() {
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }

    public String getModhash() {
        return modhash;
    }

    public List<Thing> getChildren() {
        return children;
    }

}
