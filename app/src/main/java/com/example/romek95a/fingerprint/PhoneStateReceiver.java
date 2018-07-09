package com.example.romek95a.fingerprint;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import java.util.Date;

/**
 * Created by romek95a on 09.07.2018.
 */

public class PhoneStateReceiver extends BroadcastReceiver {
    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static Date callStartTime;
    private static boolean isIncoming;
    private static String savedNumber;
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
