// IMyAidlInterface.aidl
package com.example.serverside;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void getColor(int red,int green,int blue);
}