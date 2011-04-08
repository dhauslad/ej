package com.cgi.ej.ch2;

public class Tests {

    private Tests() {
        // prevent instantiation
    }

    public static void collectAllGarbage() {
        try {
            for (int i = 0; i < 2; i++) {
                System.gc();
                System.runFinalization();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new Error(e);
        }
    }
}
