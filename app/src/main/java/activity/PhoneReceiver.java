package activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        outGoingIncomingCallDetection(intent);
    }

    // Incoming and Out going  call Detection

    public void outGoingIncomingCallDetection(Intent intent) {

            String phoneNumber = intent.getStringExtra("incoming_number");
            CallHistory callHistory = new CallHistory();
            callHistory.setMobile_no(phoneNumber);
            callHistory.setContacs_Name(getNameFromContact(phoneNumber));
            // callHistory.setCall_duration();
            RealmDatabaseHelper.saveCallDetailInRealm(callHistory);
    }

    private String getNameFromContact(String phoneNumber) {
        String contactName ="Not Found";
        Uri uri=Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,Uri.encode(phoneNumber));

        String[] projection = new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME};

        Cursor cursor=context.getContentResolver().query(uri,projection,null,null,null);

        if (cursor != null) {
            if(cursor.moveToFirst()) {
                contactName=cursor.getString(0);
            }
            cursor.close();
        }

       return contactName;
    }

    /* -------------------*/
    // missed call Detection

}
