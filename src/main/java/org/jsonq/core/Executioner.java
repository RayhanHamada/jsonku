package org.jsonq.core;

import org.jsonq.core.jsonvalue.JSONObject;

public class Executioner {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject("{\n" +
                "  \"orang\" : {\n" +
                "    \"angka\" : [1,2,3,4,5,6],\n" +
                "    \"nama\"  : [\"Rayhan\", \"Hamada\", \"Budiman\"]\n" +
                "  }\n" +
                "}");

        System.out.println(obj.getValue());
        System.out.println(obj.getJSONObjectOf("orang").getJSONArrayOf("nama").getValue());



    }
}
