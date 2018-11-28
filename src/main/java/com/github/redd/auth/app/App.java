package com.github.redd.auth.app;

public abstract class App {
    private String clientID;
    private String clientSecret;
    private String redirectURI;

    App(String clientID, String clientSecret, String redirectURI) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.redirectURI = redirectURI;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectURI() {
        return redirectURI;
    }
}
