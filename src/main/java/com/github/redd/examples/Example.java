package com.github.redd.examples;

import com.github.redd.auth.app.App;
import com.github.redd.auth.app.ScriptApp;
import com.github.redd.auth.oauth2.CodeRequestUrl;
import com.github.redd.auth.param.Duration;
import com.github.redd.auth.param.ScopeBuilder;

import java.util.Scanner;

public class Example {

    public static final String CLIENT_ID = "client-id";
    public static final String CLIENT_SECRET = "client-secret";
    public static final String REDIRECTED_URI = "https://example.com/oauth";

    public static final String AUTHORIZATION_URL = "https://www.reddit.com/api/v1/authorize";

    public static void main(String[] args) throws Exception {
        App app = new ScriptApp(Example.CLIENT_ID,Example.CLIENT_SECRET,
                Example.REDIRECTED_URI);

        ScopeBuilder scope = new ScopeBuilder()
                .completeScope();
        CodeRequestUrl cru =  new CodeRequestUrl(scope, Duration.PERMANENT);

       String out = cru.getCodeRequestUrl(app,Example.AUTHORIZATION_URL);

        System.out.println(out);

//        // Got code = code
//
        final Scanner in = new Scanner(System.in,"UTF-8");
        System.out.println("==============================");
        System.out.println("Get Access Token Response Body");

        System.out.println("And paste the authorization code here");
        System.out.print(">>");
        final String code = in.nextLine();

        cru.runTokenRequest(app,code);

        // YES I GOT RESPONSE FROM SERVER

        
         */


    }
}
