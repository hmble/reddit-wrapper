package com.github.redd.auth;

import com.github.redd.auth.app.App;
import com.github.redd.auth.param.Duration;
import com.github.redd.auth.param.ScopeBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

//Maybe rename this class to OauthClient
public class OauthAgent {
    /* Parameter keys */
    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_RESPONSE_TYPE = "response_type";
    private static final String PARAM_STATE = "state";
    private static final String PARAM_REDIRECT_URI = "redirect_uri";
    private static final String PARAM_DURATION = "duration";
    private static final String PARAM_SCOPE = "scope";
    private static final String PARAM_GRANT_TYPE = "grant_type";
    private static final String PARAM_CODE = "code";
    private static final String PARAM_DEVICE_ID = "device_id";
    //For other parameters we use generalized set method;

    public OauthAgent(App redditApp, String userAgent) {
        this.redditApp = redditApp;
        this.userAgent = userAgent;
    }

    private App redditApp;
    private String userAgent;


    public String generateCodeFlowURI(ScopeBuilder scopeBuilder, Duration duration) {
        Map<String,String> params = new HashMap<>();

        params.put(PARAM_CLIENT_ID, redditApp.getClientID());
        params.put(PARAM_RESPONSE_TYPE, "code");
        params.put(PARAM_STATE, UUID.randomUUID().toString());
        params.put(PARAM_REDIRECT_URI, redditApp.getRedirectURI());
        params.put(PARAM_DURATION, duration.getValue());
        params.put(PARAM_SCOPE, scopeBuilder.buildString());


        String out = params.entrySet()
                .stream()
                .map(e->e.getKey()+"="+e.getValue())
                .collect(Collectors.joining("&"));
        return out;
    }



}
