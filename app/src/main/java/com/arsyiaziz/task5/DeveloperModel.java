package com.arsyiaziz.task5;

import android.os.Parcel;
import android.os.Parcelable;

public class DeveloperModel implements Parcelable{
    private String name;
    private String summary;
    private String HQ;
    private int logo;

    public DeveloperModel() {}

    protected DeveloperModel(Parcel in) {
        name = in.readString();
        summary = in.readString();
        HQ = in.readString();
        logo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(summary);
        dest.writeString(HQ);
        dest.writeInt(logo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<DeveloperModel> CREATOR = new Parcelable.Creator<DeveloperModel>() {
        @Override
        public DeveloperModel createFromParcel(Parcel in) {
            return new DeveloperModel(in);
        }

        @Override
        public DeveloperModel[] newArray(int size) {
            return new DeveloperModel[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHQ() {
        return HQ;
    }

    public void setHQ(String HQ) {
        this.HQ = HQ;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
