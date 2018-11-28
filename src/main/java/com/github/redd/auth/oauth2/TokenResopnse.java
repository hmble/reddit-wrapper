package com.github.redd.auth.oauth2;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;



public class TokenResopnse {

    /*
     * {"access_token": "31763629822-EOgAhkkoD6-OtiI3m3WpgmdC3Oc",
     * "token_type": "bearer",
     * "expires_in": 3600,
     * "refresh_token": "31763629822-tx-XPxWg-G9DkDQT-lSK1JPT4JQ",
     * "scope": "edit"}
     */

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("scope")
    private String scope;

    public TokenResopnse(String accessToken, String tokenType, int expiresIn, String refreshToken) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("=========== JSON RESPONSE =======\n");
        sb.append("Access Token : "+ getAccessToken() + "\n");
        sb.append("Token Type: "+ getTokenType() + "\n");
        sb.append("Expires In : "+ getExpiresIn() + "\n");
        sb.append("Refresh Token : "+ getRefreshToken() + "\n");
        sb.append("Scope : "+ getScope() + "\n");

        return sb.toString();
    }

//    public static void main(String[] args){
//        Gson gson = new Gson();
//
//
//        String json = "{\n" +
//                "  \"access_token\": \"31763629822-EOgAhkkoD6-OtiI3m3WpgmdC3Oc\",\n" +
//                "  \"token_type\": \"bearer\",\n" +
//                "  \"expires_in\": 3600,\n" +
//                "  \"refresh_token\": \"31763629822-tx-XPxWg-G9DkDQT-lSK1JPT4JQ\",\n" +
//                "  \"scope\": \"edit\"\n" +
//                "}\n";
//        TokenResopnse tokenResopnse = gson.fromJson(json, TokenResopnse.class);
//
//        System.out.println(tokenResopnse.toString());
//    }

}
