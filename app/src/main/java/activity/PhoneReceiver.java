package activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

import databasehelper.RealmDatabaseHelper;
import io.realm.Realm;
import io.realm.RealmResults;
import modelclass.CallHistory;

public  class PhoneReceiver extends BroadcastReceiver {

    String TAG = PhoneReceiver.class.getSimpleName();
    String incoming_number = "";

    boolean incomingFlag = false;
    boolean isReceived = false;
    private String phoneNumber;
    boolean isRinging = false;
    private Intent intent;
    private Context context;
    private long currentTimeStamp;
    private String number;

    @Override
    public void onReceive(Context context, Intent intent) {

        outGoingIncomingCallDetection();
        missedCallDetection();
    }

    // Incoming and Out going  call Detection

    public void outGoingIncomingCallDetection() {

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {

            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            Toast.makeText(context, "OutGoing Call" + phoneNumber, Toast.LENGTH_LONG).show();


            CallHistory callHistory = new CallHistory();
            callHistory.setMobile_no(phoneNumber);
            // callHistory.setCall_duration();
            RealmDatabaseHelper.saveCallDetailInRealm(callHistory);

        }

        else {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            switch (tm.getCallState()) {
                case TelephonyManager.CALL_STATE_RINGING:
                    isReceived = false;
                    incoming_number = intent.getStringExtra("incoming_number");

                    Toast.makeText(context, "Hi you are calling me from " + incoming_number, Toast.LENGTH_LONG).show();

                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:

                    isReceived = true;

                    break;

                case TelephonyManager.CALL_STATE_IDLE:

                    Toast.makeText(context, "Call Disconnected :" + incoming_number, Toast.LENGTH_LONG).show();

                    break;
            }
            CallHistory callHistory = new CallHistory();
            callHistory.setMobile_no(phoneNumber);
            callHistory.setReceived_image("" + isReceived);
            // callHistory.setCall_duration();
            RealmDatabaseHelper.saveCallDetailInRealm(callHistory);
        }
    }

   /* -------------------*/
    // missed call Detection
  public void missedCallDetection() {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state == null) {
            return;
        }

        Bundle bundle = new Bundle();
        bundle = intent.getExtras();

        Calendar calendar = Calendar.getInstance();
        currentTimeStamp = calendar.getTimeInMillis();

        // if Phone State is  " Ringing "

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            isRinging = true;
        }
        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            isReceived = true;
        }
         // phone is in Idle

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE))
        {
            // If phone was ringing(ring=true) and not received(callReceived=false) , then it is a missed call
            if(isRinging==true && isReceived ==false)
            {
                Toast.makeText(context, "missed call : "+number, Toast.LENGTH_LONG).show();
                //workingWithFunctions();
                isRinging = false;
            }
            isReceived=false;
        }

    }

}
