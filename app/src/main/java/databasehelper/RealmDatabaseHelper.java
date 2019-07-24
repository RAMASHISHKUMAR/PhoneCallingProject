package databasehelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import modelclass.CallHistory;

public class RealmDatabaseHelper  {
        public  static void saveCallDetailInRealm(final  CallHistory callHistory) {
            Log.d("helper","Going to save call history in realm");

            Realm realm = Realm.getDefaultInstance();
            try {

                RealmResults<CallHistory> callHistory1 = realm.where(CallHistory.class).equalTo("Mobile_no", callHistory.getMobile_no()).findAll();

                if (callHistory != null && callHistory1.size() > 0) {
                    final CallHistory callHistoryOld = callHistory1.first();

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            callHistoryOld.setContacs_Name(callHistory.getContacs_Name());
                            Log.d("helper","data updated");

                        }
                    });
                } else {
                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(callHistory);
                    realm.commitTransaction();


                    Log.d("helper","data saved");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    public static  RealmResults<CallHistory>  getAllCallHistorey() {
            Realm realm = Realm.getDefaultInstance();
        RealmResults<CallHistory> callhistory = realm.where(CallHistory.class).findAll();
        return callhistory;
    }
}
