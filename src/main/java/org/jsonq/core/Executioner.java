package org.jsonq.core;

import org.jsonq.core.jsonvalue.JSONArray;
import org.jsonq.core.jsonvalue.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Executioner {

    public static void main(String... args) throws Exception {

        if (args.length == 1) {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(args[0])));
            String temp, toParse = "";

            while ((temp = bufferedReader.readLine()) != null)
            {
                toParse += temp;
            }


            if (toParse.startsWith("{"))
            {
                JSONObject obj = new JSONObject(toParse);
                System.out.println(obj.getValue());
                System.out.println(obj.getJSONArrayOf("array").getValue());
                System.out.println(obj.getJSONArrayOf("array").getStringAt(8).getValue());
            }
            else if (toParse.startsWith("["))
            {
                JSONArray arr = new JSONArray(toParse);
            }

            //pro


        }
        else
        {
            throw new IllegalArgumentException("the argument(s) is invalid");
        }
    }
}
