package com.arsyiaziz.task5;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ComputerModel implements Parcelable {
    private String name;
    private String summary;
    private String releaseDate;
    private int photo;
    private double introductoryPrice;
    private String developer;

    public ComputerModel() {}

    protected ComputerModel(Parcel in) {
        name = in.readString();
        summary = in.readString();
        releaseDate = in.readString();
        photo = in.readInt();
        introductoryPrice = in.readDouble();
        developer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(summary);
        dest.writeString(releaseDate);
        dest.writeInt(photo);
        dest.writeDouble(introductoryPrice);
        dest.writeString(developer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ComputerModel> CREATOR = new Creator<ComputerModel>() {
        @Override
        public ComputerModel createFromParcel(Parcel in) {
            return new ComputerModel(in);
        }

        @Override
        public ComputerModel[] newArray(int size) {
            return new ComputerModel[size];
        }
    };

    public String getIntroductoryPrice() {
        return String.format("US$%,.2f", introductoryPrice);
    }

    public void setIntroductoryPrice(double introductoryPrice) {
        this.introductoryPrice = introductoryPrice;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
