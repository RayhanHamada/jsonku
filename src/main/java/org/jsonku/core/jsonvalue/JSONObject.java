package org.jsonku.core.jsonvalue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jsonku.core.antlrgenerated.JSONParser;
import org.jsonku.core.exception.InvalidJSONValueTypeException;
import org.jsonku.core.exception.KeyNotFoundException;
import org.jsonku.core.listener.BaseListener;
import org.jsonku.core.antlrgenerated.JSONLexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JSONObject extends JSONValue {

    private String value; // for string representation

    /*
    * save the duplicates as string of pairs, and added it into the top of value variable.
    * */
    private String duplicates = "";

    // for anything inside the object
    private Map<String, JSONValue> valueMap;

    /*
    * constructor for creating empty object
    * */
    public JSONObject()
    {
        this.value = "{}";
        this.valueMap = new HashMap<>();
    }

    /*
    * constructor for JSON object that has value
    * */
    public JSONObject(String value)
    {
        this.value = value;
        this.valueMap = new HashMap<>();

        /*
        * if the value is not null or not equal to the string "null" then parse it, if not, then don't parse
        * */
        if (this.value != null || this.value != "null")
        {
            CharStream input = CharStreams.fromString(value);
            JSONLexer lexer = new JSONLexer(input);
            JSONParser parser = new JSONParser(new CommonTokenStream(lexer));
            parser.addParseListener(new BaseListener(this));
            parser.objectRoot();
        }

        // if there's any error from BaseListener, then just exit.
        if (!BaseListener.canExecuteSomething) System.exit(1);
    }

    /*
    * getters with json pointer
    * */

    public JSONValue getValueWithPointer(String pointerString) throws Exception
    {

        String[] pNames = pointerString.split("(?<=[^\\\\])/");

        if (valueMap.containsKey(pNames[0])) {
            String nString = "";
            if (pNames.length != 1)
            {
                for (int i = 1; i < pNames.length; i++) {
                    nString += pNames[i] + "/";
                }
                nString = nString.substring(0, nString.length() - 1);
            }
            else
            {
                nString = pNames[0];
            }

            if (valueMap.get(pNames[0]) instanceof JSONObject)
            {
                return ((JSONObject) valueMap.get(pNames[0])).getValueWithPointer(nString);
            }
            else if (valueMap.get(pNames[0]) instanceof JSONArray)
            {
                return ((JSONArray) valueMap.get(pNames[0])).getValueWithPointer(nString);
            }
            else
            {
                return valueMap.get(nString);
            }
        }

        throw new KeyNotFoundException();
    }

    /*
    * getters for all JSON Value type
    * */

    public JSONObject getJSONObjectOf(String key) {

        if (valueMap.containsKey(key))
        {
            /* if the valueMap.get(key) is an instance of JSONNull, then just return new JSONObject with with null string argument.
            *
            * */
            if (valueMap.get(key) instanceof JSONNull)
                return new JSONObject(null);

            if (valueMap.get(key) instanceof JSONObject) return (JSONObject) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONArray getJSONArrayOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            /* if the valueMap.get(key) is an instance of JSONNull, then just return new JSONArray with with null string argument.
             * */

            if (valueMap.get(key) instanceof JSONNull)
                return new JSONArray(null);

            if (valueMap.get(key) instanceof JSONArray) return (JSONArray) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONString getJSONStringOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONNull)
                return new JSONString(null);

            if (valueMap.get(key) instanceof JSONString) return (JSONString) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONBoolean getJSONBooleanOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONNull)
                return new JSONBoolean(null);

            if (valueMap.get(key) instanceof JSONBoolean) return (JSONBoolean) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }

        throw new KeyNotFoundException();
    }

    public JSONNumber getJSONNumberOf(String key)
    {
        if (valueMap.containsKey(key))
        {
            if (valueMap.get(key) instanceof JSONNull)
                return new JSONNumber(null);

            if (valueMap.get(key) instanceof JSONNumber) return (JSONNumber) valueMap.get(key);
            throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
        }
        throw new KeyNotFoundException();
    }

    /*
    * for put pair and create empty object and array
    * */

    public JSONObject createEmptyObject(String key)
    {
        valueMap.put(key, new JSONObject());
        return (JSONObject) valueMap.get(key);
    }

    public JSONObject createObjectFrom(String key, JSONObject object)
    {
        valueMap.put(key, object);
        return (JSONObject) valueMap.get(key);
    }

    public JSONArray createEmptyArray(String key)
    {
        valueMap.put(key, new JSONArray());
        return (JSONArray) valueMap.get(key);
    }

    public JSONArray createArrayFrom(String key, JSONArray array)
    {
        valueMap.put(key, array);
        return (JSONArray) valueMap.get(key);
    }

    public void putString(String key, String value)
    {
        valueMap.put(key, new JSONString(value));
    }

    public void putNumber(String key, String value)
    {
        if (isNumeric(value))
        {
            valueMap.put(key, new JSONNumber(value));
            return;
        }
        throw new NumberFormatException();
    }

    public void putNumber(String key, int value)
    {
        valueMap.put(key, new JSONNumber(value));
    }

    public void putNumber(String key, float value)
    {
        valueMap.put(key, new JSONNumber(value));
    }

    public void putNumber(String key, long value)
    {
        valueMap.put(key, new JSONNumber(value));
    }

    public void putBoolean(String key, boolean value)
    {
        valueMap.put(key, new JSONBoolean(value));
    }

    public String getValueTypeOf(String key)
    {
        if (valueMap.containsKey(key)) return ((JSONValue)valueMap.get(key)).getClass().toString().replaceAll("^.+\\.", "");
        throw new KeyNotFoundException();
    }

    /*
     * updating string representation of value.
     * */
    public void updateValueString()
    {
        if (this.value == null || this.value.equals("null"))
            return;

        ArrayList<String> vmapString = new ArrayList<>(valueMap.keySet());
        value = "{" + duplicates;
        for (String k : vmapString)
        {

            /*
            * if the key belong to "nestable" value, then the "nestable" value should update the string value
            * before
            * */
            if (valueMap.get(k) instanceof JSONObject)
                ((JSONObject)valueMap.get(k)).updateValueString();
            else if (valueMap.get(k) instanceof JSONArray)
                ((JSONArray)valueMap.get(k)).updateValueString();

            if (valueMap.get(k) instanceof JSONString) value += "\"" + k + "\" : \"" + valueMap.get(k).toString() + "\"";
            else value += "\"" + k + "\" : " + valueMap.get(k).toString();

            if (vmapString.indexOf(k) != vmapString.size()-1)
            {
                value += ", ";
            }

        }
        value += "}";
    }

    /*
     * if 1 or more duplicate of key is detected in valueMap, then the value get swapped into duplicates, so
     * valueMap only contains latest pair.
     * */
    public void swapToDuplicates(String key)
    {

        if (valueMap.get(key) instanceof JSONObject)
        {
            duplicates += "\"" + key + "\""  + " : " + ((JSONObject)valueMap.get(key)).toString();
        }
        else if (valueMap.get(key) instanceof JSONString)
        {
            duplicates += "\"" + key + "\"" + " : " + ((JSONString)valueMap.get(key)).toString();
        }
        else if (valueMap.get(key) instanceof JSONNumber)
        {
            duplicates += "\"" + key + "\""  + " : " + ((JSONNumber)valueMap.get(key)).toString();
        }
        else if (valueMap.get(key) instanceof JSONBoolean)
        {
            duplicates += "\"" + key + "\""  + " : " + ((JSONBoolean)valueMap.get(key)).toString();
        }
        else if (valueMap.get(key) instanceof JSONArray)
        {
            duplicates += "\"" + key + "\""  + " : " + ((JSONArray)valueMap.get(key)).toString();
        }
        else if (valueMap.get(key) instanceof JSONNull)
        {
            duplicates += "\"" + key + "\""  + " : " + ((JSONNull)valueMap.get(key)).toString();
        }

        duplicates += ", ";

        valueMap.remove(key);
    }

    public String toString() {
        updateValueString();
        return value;
    }

    public Map<String, JSONValue> getValueMap()
    {
        return valueMap;
    }

    public String getDuplicates()
    {
        return duplicates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONObject)) return false;
        JSONObject that = (JSONObject) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(duplicates, that.duplicates) &&
                Objects.equals(valueMap, that.valueMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, duplicates, valueMap);
    }
}
