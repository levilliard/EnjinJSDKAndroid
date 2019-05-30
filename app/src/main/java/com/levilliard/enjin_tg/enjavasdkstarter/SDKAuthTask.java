package com.levilliard.enjin_tg.enjavasdkstarter;

import android.os.AsyncTask;

import com.enjin.enjincoin.sdk.Client;
import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;

import java.io.IOException;

public class SDKAuthTask extends AsyncTask<String, Void, Boolean> {

    private Client client;

    public SDKAuthTask(Client client) {
        this.client = client;
    }

    @Override
    protected Boolean doInBackground(String... args) {
        String secret = args[0];

        try {
            HttpResponse<AuthResult> result = client.auth(secret);
            return result.isSuccess();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
