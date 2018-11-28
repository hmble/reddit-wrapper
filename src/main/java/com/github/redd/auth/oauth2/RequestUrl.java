package com.github.redd.auth.oauth2;

import okhttp3.HttpUrl;

public class RequestUrl {

    private String clientID;
    private String responseType;
    private String state;
    private String redirectedUri;
    private String scope;



//    private static final HttpUrl AUTHORIZATION_URL = HttpUrl.parse("https://www.reddit.com/api/v1/authorize");
    // As duration is not in standard RFC rule. We will set this explicitly
//    private String duration;


    public RequestUrl() {
    }

    public final String getClientID() {
        return clientID;
    }

    public RequestUrl setClientID(String clientID) {
        this.clientID = clientID;
        return this;
    }

    public final String getResponseType() {
        return responseType;
    }
    public RequestUrl setResponseType(String responseType) {
        this.responseType = responseType;
        return this;
    }

    public final String getState() {
        return state;
    }

    public RequestUrl setState(String state) {
        this.state = state;
        return this;
    }

    public final String getRedirectedUri() {
        return redirectedUri;
    }

    public RequestUrl setRedirectedUri(String redirectedUri) {
        this.redirectedUri = redirectedUri;
        return this;
    }

    public final String getScope() {
        return scope;
    }

    public RequestUrl setScope(String scope) {
        this.scope = scope;
        return this;
    }



}
