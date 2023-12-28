package com.example.rectangle_aidl_service;

import android.os.Parcel;
import android.os.Parcelable;

public class RectangleData implements Parcelable {
    private int length;
    private int breadth;
    private int area;
    private  int perimeter;
    private double diagonal;

    public RectangleData(int length,int breadth,int area,int perimeter,double diagonal){
        this.length = length;
        this.breadth = breadth;
        this.area = area;
        this.perimeter = perimeter;
        this.diagonal = diagonal;
    }

    protected RectangleData(Parcel in) {
        this.length = in.readInt();
        this.breadth = in.readInt();
        this.area = in.readInt();
        this.perimeter = in.readInt();
        this.diagonal = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(length);
        dest.writeInt(breadth);
        dest.writeInt(area);
        dest.writeInt(perimeter);
        dest.writeDouble(diagonal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RectangleData> CREATOR = new Creator<RectangleData>() {
        @Override
        public RectangleData createFromParcel(Parcel in) {
            return new RectangleData(in);
        }

        @Override
        public RectangleData[] newArray(int size) {
            return new RectangleData[size];
        }
    };
    public int getArea() {
        return area;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getPerimeter() {
        return perimeter;
    }
}
