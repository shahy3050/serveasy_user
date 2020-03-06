package com.example.new_serveasy.models;


import android.os.Parcel;
import android.os.Parcelable;

public class Garage implements Parcelable {
    String gId;
    String gName;
    String gOwner;
    String gCity;
    String gArea;
    String gFullAddress;
    String gContact;

    public Garage(String gId, String gName, String gOwner, String gCity, String gArea, String gFullAddress, String gContact) {
        this.gId = gId;
        this.gName = gName;
        this.gOwner = gOwner;
        this.gCity = gCity;
        this.gArea = gArea;
        this.gFullAddress = gFullAddress;
        this.gContact = gContact;
    }

    public Garage() {
    }

    public static final Creator<Garage> CREATOR = new Creator<Garage>() {
        @Override
        public Garage createFromParcel(Parcel in) {
            return new Garage(in);
        }

        @Override
        public Garage[] newArray(int size) {
            return new Garage[size];
        }
    };

    public String getgOwner() {
        return gOwner;
    }

    public void setgOwner(String gOwner) {
        this.gOwner = gOwner;
    }

    public String getgFullAddress() {
        return gFullAddress;
    }

    public void setgFullAddress(String gFullAddress) {
        this.gFullAddress = gFullAddress;
    }



    protected Garage(Parcel in) {
        gId = in.readString();
        gName = in.readString();
        gOwner = in.readString();
        gCity = in.readString();
        gArea = in.readString();
        gFullAddress = in.readString();
        gContact = in.readString();
    }


    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgCity() {
        return gCity;
    }

    public void setgCity(String gCity) {
        this.gCity = gCity;
    }

    public String getgArea() {
        return gArea;
    }

    public void setgArea(String gArea) {
        this.gArea = gArea;
    }

    public String getgContact() {
        return gContact;
    }

    public void setgContact(String gContact) {
        this.gContact = gContact;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gId);
        dest.writeString(gName);
        dest.writeString(gOwner);
        dest.writeString(gCity);
        dest.writeString(gArea);
        dest.writeString(gFullAddress);
        dest.writeString(gContact);
    }
}
