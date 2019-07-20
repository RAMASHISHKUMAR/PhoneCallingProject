package databasehelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import io.realm.Realm;
import io.realm.RealmResults;
import modelclass.CallHistory;

public class RealmDatabaseHelper{
        private void saveCallDetailInRealm(final  CallHistory callHistory) {
            Realm realm = Realm.getDefaultInstance();
            RealmResults<CallHistory> callHistory1 = realm.where(CallHistory.class).equalTo("Mobile_no",callHistory.getMobile_no()).findAll();
            if (callHistory!=null && callHistory1.size()>0){
                final CallHistory callHistoryOld = callHistory1.first();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        callHistoryOld.setContacs_Name( callHistory.getContacs_Name());
                    }
                });
            }else{
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(callHistory);
                realm.commitTransaction();
            }


        }



}
