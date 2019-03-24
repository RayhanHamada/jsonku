package org.jsonq.core;

import org.jsonq.core.jsonvalue.JSONObject;

public class Executioner {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject("{\n" +
                "  \"alamat\" :\n" +
                "  {\n" +
                "    \"jalan\" : \"Amarta 3\",\n" +
                "    \"kota\" : \"Tangerang Selatan\",\n" +
                "    \"posisi\" :\n" +
                "    {\n" +
                "      \"x\" : 10,\n" +
                "      \"y\" : 20\n" +
                "    }\n" +
                "  }\n" +
                "}");


        obj.putString("Hobi", "Koding");
        System.out.println(obj.getValue());
//        System.out.println(obj.getDuplicates());

    }
}
