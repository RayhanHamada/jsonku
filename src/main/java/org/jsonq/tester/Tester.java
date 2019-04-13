package org.jsonq.tester;

import org.jsonq.core.jsonvalue.JSONArray;
import org.jsonq.core.jsonvalue.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tester {

    public static void main(String... args) throws Exception {

        if (args.length == 1) {

            /*
            *  reader for the json file
            * */
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


            }
            else if (toParse.startsWith("["))
            {
                JSONArray arr = new JSONArray(toParse);
                System.out.println(arr.getStringAt(0).getValue());
            }
        }
        else
        {
            throw new IllegalArgumentException("the argument(s) is invalid");
        }
    }
}
