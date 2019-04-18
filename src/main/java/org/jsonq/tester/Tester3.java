package org.jsonq.tester;

import org.jsonq.core.jsonvalue.JSONObject;

public class Tester3 {

    public static void main(String[] args) {


        JSONObject obj = new JSONObject("{\n" +
                "\"obj\" : {\n" +
                "\"nama\" : []\n" +
                "},\n" +
                "\"nama\" : \"Budiman\"\n" +
                "}");
        System.out.println(obj.getValue());

    }
}
