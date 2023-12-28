// RECTANGLE_Service.aidl
package com.example.rectangle_aidl_service;

// Declare any non-default types here with import statements
import com.example.rectangle_aidl_service.RectangleData;
interface RECTANGLE_Service {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    RectangleData getRectangleAllInfo(int length,int breadth);
}