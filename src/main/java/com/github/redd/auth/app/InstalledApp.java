package com.github.redd.auth.app;

public class InstalledApp extends App {

    // No client secret is given.
    public InstalledApp(String clientID, String clientSecret, String redirectURI) {

        super(clientID, "", redirectURI);
    }
}
