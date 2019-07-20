package activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmResults;
import modelclass.CallHistory;

public class PhoneReceiver extends BroadcastReceiver {

    String TAG = PhoneReceiver.class.getSimpleName();

    boolean incomingFlag = false;
    boolean isRecieved = false;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {

            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            Toast.makeText(context, "OutGoing Call" + phoneNumber, Toast.LENGTH_LONG).show();
            // saveCallDetailInRealm();

        } else {
            String incoming_number = "";
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            switch (tm.getCallState()) {
                case TelephonyManager.CALL_STATE_RINGING:

                    incoming_number = intent.getStringExtra("incoming_number");


                    Toast.makeText(context, "Hi you are calling me from " + incoming_number, Toast.LENGTH_LONG).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    isRecieved = true;
                    Toast.makeText(context, "incoming ACCEPT :" + incoming_number, Toast.LENGTH_LONG).show();
                    break;

                case TelephonyManager.CALL_STATE_IDLE:
                    Toast.makeText(context, "Call Disconnected :" + incoming_number, Toast.LENGTH_LONG).show();

                    break;
            }

        }

    }
  /*
    private void saveCallDetailInRealm(final CallHistory callHistory) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CallHistory> callHistory1 = realm.where(CallHistory.class).equalTo("Mobile_no",callHistory.getMobile_no()).findAll();
        if (callHistory!=null && callHistory1.size()>0){
            final CallHistory callHistoryOld = callHistory1.first();

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    callHistoryOld.setContacs_Name(callHistory.getContacs_Name());
                }
            });
        }else{
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(callHistory);
            realm.commitTransaction();
        }


    }*/


}
