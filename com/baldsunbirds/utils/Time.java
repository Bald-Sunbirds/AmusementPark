package com.baldsunbirds.utils;

public class Time {

    public static double timeStarted = System.nanoTime();

    public static double getTime() {
        // in sec
        return (System.nanoTime() - timeStarted) * 10E-10;
    }
}
