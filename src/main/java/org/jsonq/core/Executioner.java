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

            /*
            * read every line of the json file
            * */
            while ((temp = bufferedReader.readLine()) != null)
            {
                toParse += temp;
            }

            /*
            * if the json string starts with '{' or a "null", then it will be parsed as JSONObject, if it start with '['
            * then it would be parsed as JSONArray
            * */

            if (toParse.startsWith("{") || toParse.matches("null"))
            {
                JSONObject obj = new JSONObject(toParse);
                System.out.println(obj.getValue());

                System.out.println(obj.getJSONArrayOf("track").getArrayAt(0).getArrayAt(0).getArrayAt(0).getValue());
                System.out.println();
                ;

            }
            else if (toParse.startsWith("["))
            {
                JSONArray arr = new JSONArray(toParse);
            }

            //masalah sekarang : selalu error saat parsing array di dalam array


        }
        else
        {
            throw new IllegalArgumentException("the argument(s) is invalid");
        }
    }
}
