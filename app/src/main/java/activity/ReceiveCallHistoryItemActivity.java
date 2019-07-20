package activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.phonecallingproject.R;

import databasehelper.RealmDatabaseHelper;
import io.realm.Realm;
import modelclass.CallHistory;

public class ReceiveCallHistoryItemActivity extends AppCompatActivity {
   Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_call_history_item);

        realm = Realm.getDefaultInstance();

       saveReceiveCallHistoryInRealm();
    }

   public void saveReceiveCallHistoryInRealm(){
        final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            // String incomingNum= intent.getStringExtra("incoming_number");
                realm.beginTransaction();
                CallHistory callHistory = new CallHistory();
                callHistory.setContacs_Name();





            }
        }
   }
}
