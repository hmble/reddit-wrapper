package com.github.redd.auth.oauth2;

import com.github.redd.auth.app.App;
import com.github.redd.auth.param.Duration;
import com.github.redd.auth.param.ScopeBuilder;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

public class CodeRequestUrl extends RequestUrl{

    private ScopeBuilder scope;
    private Duration duration;

    //parameter keys

    private static final String PARAM_CLIENT_ID = "client_id";
    private static final String PARAM_RESPONSE_TYPE = "response_type";
    private static final String PARAM_STATE = "state";
    private static final String PARAM_REDIRECT_URI = "redirect_uri";
    private static final String PARAM_DURATION = "duration";
    private static final String PARAM_SCOPE = "scope";
    private static final String PARAM_GRANT_TYPE = "grant_type";
    private static final String PARAM_DEVICE_ID = "device_id";

    public CodeRequestUrl(ScopeBuilder scope, Duration duration) {
        this.scope = scope;
        this.duration = duration;
    }

    public String getCodeRequestUrl(App app, String authorizationUrl){
        HttpUrl httpUrl = HttpUrl.parse(authorizationUrl)
                .newBuilder()
                .addQueryParameter(PARAM_CLIENT_ID,app.getClientID())
                .addQueryParameter(PARAM_RESPONSE_TYPE,"code")
                .addQueryParameter(PARAM_REDIRECT_URI,app.getRedirectURI())
                .addQueryParameter(PARAM_STATE, UUID.randomUUID().toString())
                .addQueryParameter(PARAM_SCOPE,scope.buildString())
                .addQueryParameter(PARAM_DURATION,duration.getValue())
                .build();

        return httpUrl.toString();
    }

    public void runTokenRequest(App app, String code) throws Exception{

        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("grant_type","authorization_code")
                .add("code",code)
                .add(PARAM_REDIRECT_URI,app.getRedirectURI())
                .build();

        String credential = Credentials.basic(app.getClientID(),app.getClientSecret());

        Request request = new Request.Builder()
                .url("https://www.reddit.com/api/v1/access_token")
                .addHeader("Authorization",credential)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String tokenResopnse = response.body().string();



            System.out.println(tokenResopnse);
        }

    }

    public void runRefreshToken(App app, String refreshToken) throws Exception{

        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("grant_type","refresh_token")
                .add("refresh_token",refreshToken)
                .build();

        String credential = Credentials.basic(app.getClientID(),app.getClientSecret());

        Request request = new Request.Builder()
                .url("https://www.reddit.com/api/v1/access_token")
                .addHeader("Authorization",credential)
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String tokenResopnse = response.body().string();



            System.out.println(tokenResopnse);
        }

    }


}
