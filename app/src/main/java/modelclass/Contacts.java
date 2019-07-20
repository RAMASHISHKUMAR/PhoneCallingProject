package modelclass;

import android.provider.MediaStore;

import io.realm.RealmObject;

public class Contacts extends RealmObject {

    private String name,mob_no;
    private MediaStore.Images image,isfavorite;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public MediaStore.Images getImage() {
        return image;
    }

    public void setImage(MediaStore.Images image) {
        this.image = image;
    }

    public MediaStore.Images getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(MediaStore.Images isfavorite) {
        this.isfavorite = isfavorite;
    }



    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", mob_no='" + mob_no + '\'' +
                ", image=" + image +
                ", isfavorite=" + isfavorite +
                '}';
    }


}
