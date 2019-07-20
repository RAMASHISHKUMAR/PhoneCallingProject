package modelclass;

import android.media.Image;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CallHistory extends RealmObject {

    private String Contacs_Name;
    @PrimaryKey
    private String Mobile_no;
    private String Call_duration;
    private String Call_date;

    private Image Favorite_Image;
    private Image Calling_image;
    private Image Outgoing_image;
    private Image Received_image;
    private Image Missedcall_image;
    private Image Caller_profile_image;

    public String getContacs_Name() {
        return Contacs_Name;
    }

    public void setContacs_Name(String contacs_Name) {
        Contacs_Name = contacs_Name;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
    }

    public String getCall_duration() {
        return Call_duration;
    }

    public void setCall_duration(String call_duration) {
        Call_duration = call_duration;
    }

    public String getCall_date() {
        return Call_date;
    }

    public void setCall_date(String call_date) {
        Call_date = call_date;
    }

    public Image getFavorite_Image() {
        return Favorite_Image;
    }

    public void setFavorite_Image(Image favorite_Image) {
        Favorite_Image = favorite_Image;
    }

    public Image getCalling_image() {
        return Calling_image;
    }

    public void setCalling_image(Image calling_image) {
        Calling_image = calling_image;
    }

    public Image getOutgoing_image() {
        return Outgoing_image;
    }

    public void setOutgoing_image(Image outgoing_image) {
        Outgoing_image = outgoing_image;
    }

    public Image getReceived_image() {
        return Received_image;
    }

    public void setReceived_image(Image received_image) {
        Received_image = received_image;
    }

    public Image getMissedcall_image() {
        return Missedcall_image;
    }

    public void setMissedcall_image(Image missedcall_image) {
        Missedcall_image = missedcall_image;
    }

    public Image getCaller_profile_image() {
        return Caller_profile_image;
    }

    public void setCaller_profile_image(Image caller_profile_image) {
        Caller_profile_image = caller_profile_image;
    }



    @Override
    public String toString() {
        return "CallHistory{" +
                "Contacs_Name='" + Contacs_Name + '\'' +
                ", Mobile_no='" + Mobile_no + '\'' +
                ", Call_duration='" + Call_duration + '\'' +
                ", Call_date='" + Call_date + '\'' +
                ", Favorite_Image=" + Favorite_Image +
                ", Calling_image=" + Calling_image +
                ", Outgoing_image=" + Outgoing_image +
                ", Received_image=" + Received_image +
                ", Missedcall_image=" + Missedcall_image +
                ", Caller_profile_image=" + Caller_profile_image +
                '}';
    }






}
