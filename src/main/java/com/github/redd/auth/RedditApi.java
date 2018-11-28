package com.github.redd.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.OAuth2AccessTokenExtractor;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Verb;

public class RedditApi extends DefaultApi20 {
    private RedditApi(){}

    private static class InstanceHolder {
        private static final RedditApi INSTANCE = new RedditApi();
    }

    public static RedditApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://www.reddit.com/api/v1/access_token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://www.reddit.com/api/v1/authorize?";
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return OAuth2AccessTokenExtractor.instance();
    }
}
