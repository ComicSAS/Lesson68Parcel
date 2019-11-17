package com.example.lesson68parcel;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    Parcel p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeParcel();
        readParcel();
    }

    private void writeParcel() {
        p = Parcel.obtain();
        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "qwerty";

        logWritenInfo("before writing");
        p.writeByte(b);
        logWritenInfo("byte");
        p.writeInt(i);
        logWritenInfo("int");
        p.writeLong(l);
        logWritenInfo("long");
        p.writeFloat(f);
        logWritenInfo("float");
        p.writeDouble(d);
        logWritenInfo("double");
        p.writeString(s);
        logWritenInfo("String");
    }

    void logWritenInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataSize = " + p.dataSize() + " dataPosition = " + p.dataPosition());
    }

    void readParcel() {
        logReadInfo("before reading");
        p.setDataPosition(0);
        logReadInfo("byte = " + p.readByte());
        logReadInfo("int = " + p.readInt());
        logReadInfo("long = " + p.readLong());
        logReadInfo("float = " + p.readFloat());
        logReadInfo("double = " + p.readDouble());
        logReadInfo("string = " + p.readString());
    }

    void logReadInfo(String txt) {
        Log.d(LOG_TAG, txt + ": dataPosition = " + p.dataPosition() + " "
                + Arrays.toString(p.marshall()));
    }

}
