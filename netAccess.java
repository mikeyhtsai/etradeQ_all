package com.sctech.etradeq;

import com.etrade.etws.oauth.sdk.client.IOAuthClient;
import com.etrade.etws.oauth.sdk.client.OAuthClientImpl;
import com.etrade.etws.oauth.sdk.common.Token;
import com.etrade.etws.sdk.client.ClientRequest;
import com.etrade.etws.sdk.client.Environment;

import java.io.IOException;

public class netAccess  {
// Variables

    private static String oauth_consumer_key = "xxx"; // Your consumer key
    private static String oauth_consumer_secret = "xxx"; // Your consumer secret
    private static String oauth_request_token = null; // Request token
    private static String oauth_request_token_secret = null; // Request token secret
    private static Token token = null;

    public static void etradeReqToken() throws com.etrade.etws.sdk.common.ETWSException {
        IOAuthClient client = OAuthClientImpl.getInstance(); // Instantiate IOAUthClient
        ClientRequest request = new ClientRequest(); // Instantiate ClientRequest
        request.setEnv(Environment.SANDBOX); // Use sandbox environment

        request.setConsumerKey(oauth_consumer_key); //Set consumer key
        request.setConsumerSecret(oauth_consumer_secret); // Set consumer secret

        try {
             token = client.getRequestToken(request); // Get request-token object
        }catch(IOException ie){
            ie.printStackTrace();
        }
        oauth_request_token = token.getToken(); // Get token string
        oauth_request_token_secret = token.getSecret(); // Get token secret

    }

    /*
    public static void getRecipeFromNetwork(String url, Context context) {

        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        oauth_request_token = token.getToken(); // Get token string
                        oauth_request_token_secret = token.getSecret(); // Get token secret
                    }
                }, new Response.ErrorListener() {
            @Override

            public void onErrorResponse(VolleyError error) {
                Log.e("BakingApps", "That didn't work!" + error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    */
}
