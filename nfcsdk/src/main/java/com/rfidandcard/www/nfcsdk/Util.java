package com.rfidandcard.www.nfcsdk;

public class Util {
    public static String bytesToHex(byte[] data){
        String s = "";
        for (byte a: data) {
            s += String.format("%02X",a);
        }
        return s;
    }
}
