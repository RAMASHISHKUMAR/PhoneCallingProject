package activity;

import android.app.Application;

import io.realm.BuildConfig;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("phonecalling.realm")
                .schemaVersion(BuildConfig.VERSION_CODE)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
