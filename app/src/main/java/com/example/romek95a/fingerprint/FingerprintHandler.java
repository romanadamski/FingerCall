package com.example.romek95a.fingerprint;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by romek95a on 08/07/2018.
 */

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private Context context;
    private TelephonyManager telephonyManager;
    public FingerprintHandler(Context context, TelephonyManager telephonyManager) {
        this.context = context;
        this.telephonyManager=telephonyManager;
    }

    public void startAuthentication(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject) {
        CancellationSignal cenCancellationSignal = new CancellationSignal();
        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED)
            return;
        fingerprintManager.authenticate(cryptoObject,cenCancellationSignal,0,this,null);

    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Toast.makeText(context, "Fingerprint Authentication failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        //odbieranie
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        TelecomManager tm = (TelecomManager) context
                .getSystemService(Context.TELECOM_SERVICE);

        if (tm == null) {
            // whether you want to handle this is up to you really
            throw new NullPointerException("tm == null");
        }
        //tm.acceptRingingCall();
    }
}