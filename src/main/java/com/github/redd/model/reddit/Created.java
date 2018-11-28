package com.github.redd.model.reddit;

import com.google.gson.annotations.SerializedName;

public class Created {
//    All thing that implement created have these attributes
    private long created;
    @SerializedName("created_utc")
    private long createdUtc;
}
