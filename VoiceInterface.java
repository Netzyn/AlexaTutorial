package com.netzyn.helloworld;

import android.content.Intent;
import android.util.Log;

import com.netzyn.api.SaApi;
import com.netzyn.api.SaApiInterface;

public class VoiceInterface implements SaApiInterface {
    private final String TAG = "VoiceInterface";
    private final String AppName = "helloworld";

    HelloWorldClientInterface client;
    private SaApi api = null;

    VoiceInterface(HelloWorldClientInterface client, Intent intent)
    {
        this.client = client;
        api = new SaApi(AppName, intent, this);
    }
    public void SaEventVoice(String user, String device, String app, final String sessionId, String intent,
                      final String parm1, final String parm2, final String parm3, final String parm4, final String parm5)
    {
        if (intent.compareToIgnoreCase("hello") == 0) {
            client.HelloWorld();
            api.SaVoiceResponse(sessionId, "ask", "Hi There");
        }
        else if (intent.compareToIgnoreCase("test") == 0) {
            api.SaVoiceResponse(sessionId, "ask", "Test Complete");
        }
    }

    public void SaEventLog(String var1)
    {
        Log.i(TAG, "Event Log: " + var1);
    }

    public void SaEventConnected()
    {
        Log.i(TAG, "Event Connected");
    }

    public void SaEventError(String var1)
    {
        Log.i(TAG, "Event Error: " + var1);
    }
}
