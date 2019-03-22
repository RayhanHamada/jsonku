package org.jsonq.core.jsonvalue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.json_plus.core.antlrgenerated.JSONLexer;
import org.json_plus.core.antlrgenerated.JSONParser;
import org.json_plus.core.exception.InvalidJSONValueTypeException;
import org.json_plus.core.exception.KeyNotFoundException;
import org.json_plus.core.listener.BaseListener;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class JSONObject extends JSONValue {

    private String value; // for string representation

    // for anything inside the object
    private Map<String, JSONValue> valueMap;

    //if duplicates exist in valueMap, then it would be swapped here
    private Map<String, JSONValue> duplicatesMap;

    public JSONObject()
    {
        this.value = "{}";
        this.valueMap = new HashMap<>();
        this.duplicatesMap = new HashMap<>();
    }

    public JSONObject(String value)
    {
        this.value = value;
        this.valueMap = new HashMap<>();
        this.duplicatesMap = new HashMap<>();

        CharStream input = CharStreams.fromString(value);
        JSONLexer lexer = new JSONLexer(input);
        JSONParser parser = new JSONParser(new CommonTokenStream(lexer));
        parser.addParseListener(new BaseListener(this));
        parser.root();

    }

    /*
    * getters for all JSON Value type
    * */

    public JSONObject getJSONObjectOf(String key) {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONObject) return (JSONObject) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONArray getJSONArrayOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONArray) return (JSONArray) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONString getJSONStringOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONString) return (JSONString) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONBoolean getJSONBooleanOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONBoolean) return (JSONBoolean) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONNumber getJSONNumberOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONNumber) return (JSONNumber) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }


    /*
    * if 1 or more duplicate of key is detected in valueMap, then the value get swapped into duplicatesMap, so
    * only the new pair in valueMap.
    * */
    public void swapToDuplicatesMap(String key)
    {

//        boolean duplicateStillExist = valueMap.containsKey(key);
        /*
        * the valueMap.get() method return Object type value. so i have to check if the value is also an instance of one of the subclass of JSONValue
        * */

        if (valueMap.get(key) instanceof JSONObject)
        {
            duplicatesMap.put(key, new JSONObject(((JSONObject)valueMap.get(key)).value));
        }
        else if (valueMap.get(key) instanceof JSONString)
        {
            duplicatesMap.put(key, new JSONString(((JSONString)valueMap.get(key)).getValue()));
        }
        else if (valueMap.get(key) instanceof JSONNumber)
        {
            duplicatesMap.put(key, new JSONNumber(((JSONNumber)valueMap.get(key)).getValue()));
        }
        else if (valueMap.get(key) instanceof JSONBoolean)
        {
            duplicatesMap.put(key, new JSONBoolean(((JSONBoolean)valueMap.get(key)).getValue()));
        }
        else if (valueMap.get(key) instanceof JSONArray)
        {
            duplicatesMap.put(key, new JSONArray(((JSONArray)valueMap.get(key)).getValue()));
        }

        valueMap.remove(key);
    }

    public String getValueTypeOf(String key)
    {
        if (valueMap.containsKey(key)) return ((JSONValue)valueMap.get(key)).getClass().toString().replaceAll("^.+\\.", "");

        throw new KeyNotFoundException();
    }

    /*
    * for put pair and create empty object and array
    * */

    public JSONObject createEmptyObject(String key)
    {
        if (valueMap.containsKey(key)) swapToDuplicatesMap(key);
        valueMap.put(key, new JSONObject());
        updateValueString();

        return (JSONObject) valueMap.get(key);
    }

    public JSONArray createEmptyArray(String key)
    {
        if (valueMap.containsKey(key)) swapToDuplicatesMap(key);
        valueMap.put(key, new JSONArray());
        updateValueString();

        return (JSONArray) valueMap.get(key);
    }

    public void putString(String key, String value)
    {
        if (valueMap.containsKey(key)) swapToDuplicatesMap(key);
        valueMap.put(key, new JSONString(value));
        updateValueString();
    }

    public void putNumber(String key, String value)
    {
        if (isNumeric(value))
        {
            if (valueMap.containsKey(key)) swapToDuplicatesMap(key);
            valueMap.put(key, new JSONNumber(value));
            updateValueString();
            return;
        }
        throw new NumberFormatException();
    }

    public void putBoolean(String key, boolean value)
    {
        if (valueMap.containsKey(key)) swapToDuplicatesMap(key);
        valueMap.put(key, new JSONBoolean(value));
        updateValueString();
    }

    public void modifyValueOf(String key, JSONValue newValue)
    {
        if (valueMap.containsKey(key)) valueMap.remove(key);
        valueMap.put(key, newValue);
        updateValueString();
    }

    public String getValue() {
        return value;
    }

    /*
    * updating string representation of value.
    * */
    public void updateValueString()
    {
        this.value = "";
    }

    public Map<String, JSONValue> getValueMap()
    {
        return valueMap;
    }

    public Map<String, JSONValue> getDuplicatesMap()
    {
        return duplicatesMap;
    }
}
