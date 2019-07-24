package modelclass;

import android.provider.MediaStore;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Contacts extends RealmObject {


    @PrimaryKey
    private String id;
    @Index
    private String name;

    @Index
    private String number;

    @Index
    private boolean isBeingSaved;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isBeingSaved() {
        return isBeingSaved;
    }

    public void setBeingSaved(boolean beingSaved) {
        isBeingSaved = beingSaved;
    }
    public void setIsBeingSaved(boolean b) {
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", isBeingSaved=" + isBeingSaved +
                '}';
    }

}
