package com.liker.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resend implements Parcelable {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;

    protected Resend(Parcel in) {
        status = in.readInt();
        message = in.readString();
    }

    public static final Creator<Resend> CREATOR = new Creator<Resend>() {
        @Override
        public Resend createFromParcel(Parcel in) {
            return new Resend(in);
        }

        @Override
        public Resend[] newArray(int size) {
            return new Resend[size];
        }
    };

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(message);
    }
}
