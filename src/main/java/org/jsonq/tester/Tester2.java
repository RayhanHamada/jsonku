package org.jsonq.tester;

import org.jsonq.core.extras.JSONFile;
import org.jsonq.core.jsonvalue.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester2 {

    public static void main(String[] args) throws Exception {

        JSONFile file = new JSONFile("D:\\RayhanHamada\\CodingStuff\\Exercise\\Java\\jsonq\\src\\main\\resources\\j2.json");
        System.out.println(file.getJSONObject().getValue());




    }
}
