package org.jsonq.core;

import org.jsonq.core.jsonvalue.JSONObject;

public class Executioner {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject("{\n" +
                "\n" +
                "  \"nama\" : \"Rayhan\",\n" +
                "  \"angka\" : [1,2,3,4,5,6]\n" +
                "}");



        System.out.println(obj.getJSONArrayOf("angka").getNumberAt(0));


    }
}
