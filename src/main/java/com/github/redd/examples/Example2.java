package com.github.redd.examples;

import com.github.redd.auth.app.App;
import com.github.redd.auth.app.ScriptApp;
import com.github.redd.auth.oauth2.CodeRequestUrl;
import com.github.redd.auth.param.Duration;
import com.github.redd.auth.param.ScopeBuilder;

public class Example2 {
    public static final String CLIENT_ID = "zlb-dVqDeuODaA";
    public static final String CLIENT_SECRET = "6wadwLltr9WVQ_Ow46PNrywF-Pw";
    public static final String REDIRECTED_URI = "https://example.com/oauth";

    //Refresh Token
    public static final String REFRESH_TOKEN = "31763629822-aRVYmfxTAW4Sx5mihFB89sqwQno";

    public static void main(String[] args) throws Exception {
        App app = new ScriptApp(Example.CLIENT_ID, Example.CLIENT_SECRET,
                Example.REDIRECTED_URI);

        /*
         * {"access_token": "31763629822-EOgAhkkoD6-OtiI3m3WpgmdC3Oc",
         * "token_type": "bearer",
         * "expires_in": 3600,
         * "refresh_token": "31763629822-tx-XPxWg-G9DkDQT-lSK1JPT4JQ",
         * "scope": "edit"}
         */

        ScopeBuilder scope = new ScopeBuilder()
                .completeScope();
        CodeRequestUrl cru = new CodeRequestUrl(scope, Duration.PERMANENT);

        cru.runRefreshToken(app, REFRESH_TOKEN);

        //YES got the token using refresh token

//        {
//            "access_token": "31763629822-MG8by93GrVTnW5igLhs6b3DuXA8",
//                "token_type": "bearer",
//                "expires_in": 3600,
//                "scope": "edit flair history identity modconfig modflair modlog modposts modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread"
//        }
    }
}
