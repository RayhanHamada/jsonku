package org.jsonku.core.extras;

import org.jsonku.core.jsonvalue.JSONArray;
import org.jsonku.core.jsonvalue.JSONObject;

import java.io.*;

public class JSONFile extends File {

    private String stringRepr;
    private JSONObject jsonObject = null;
    private JSONArray jsonArray = null;
    private boolean isObject; // true if this file's first scope is object scope or null, false if it's an array

    public JSONFile(String path) throws Exception {
        super(path);

        BufferedReader r = new BufferedReader(new FileReader(this));
        String temp;

        while ((temp = r.readLine()) != null)
        {
            this.stringRepr += temp;
        }

        if (stringRepr.startsWith("null") && stringRepr.length() > 4)
        {
            stringRepr = stringRepr.substring(4, stringRepr.length());
        }

        // check if string repr is a string of json
        if (!stringRepr.matches("^\\{.*\\}$|^\\[.*\\]$|^null$"))
        {
            throw new Exception("the content of the file has no json text structure(it should be a json object, a json array, or a null");
        }

        //decide if stringRepr is an object or array
        if (stringRepr.startsWith("{"))
        {
            jsonObject = new JSONObject(stringRepr);
            isObject = true;
        }
        else if (stringRepr.startsWith("["))
        {
            jsonArray = new JSONArray(stringRepr);
            isObject = false;
        }
    }

    public String getContent()
    {
        if (isObject)
        {
            stringRepr = jsonObject.toString();
        }
        else
        {
            stringRepr = jsonArray.toString();
        }

        return stringRepr;
    }


    public JSONObject getJSONObject() throws Exception
    {
        if (stringRepr.startsWith("{"))
        {
            return jsonObject;
        }
        else if (stringRepr.equals("null") || stringRepr == null)
        {
            return jsonObject;
        }

        throw new Exception("the " + stringRepr + " file is not an object");
    }

    public JSONArray getJSONArray() throws Exception
    {
        if (stringRepr.startsWith("["))
        {
            return jsonArray;
        }
        else if (stringRepr.equals("null") || stringRepr == null)
        {
            return jsonArray;
        }

        throw new Exception("the " + this.getName() + " file is not an array");
    }

    public void update(JSONObject o)
    {
        this.stringRepr = o.toString();
        this.jsonObject = o;
        this.jsonArray = null;
        this.isObject = true;
    }

    public void update(JSONArray a)
    {
        this.stringRepr = a.toString();
        this.jsonArray = a;
        this.jsonObject = null;
        this.isObject = false;
    }

    public void dump() throws Exception
    {
        if (isObject) stringRepr = jsonObject.toString();
        else stringRepr = jsonArray.toString();

        try{
            FileWriter fileWriter = new FileWriter(this);
            fileWriter.write(stringRepr);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }



}
