package com.google.android.gcm.demo.app.networking;

/**
 * Wrapper of registration ID to send as JSON body of {@link PostRegistrationIdRequest}.
 * 
 * @author Lucas Nobile
 */
public class RegistrationIdWrapper {

    private String regId;

    public String getRegistrationId() {
        return regId;
    }

    public void setRegistrationId(String registrationId) {
        regId = registrationId;
    }
}