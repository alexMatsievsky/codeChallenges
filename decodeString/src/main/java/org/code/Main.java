package org.code;

public class Main {
    public static void main(String[] args) {

        // Decode string with brackets
        DecodeService decodeService = new DecodeService();
        String line = "a2[b3[klm]t]z";
        System.out.print(decodeService.decodeString(line));

        //
    }
}