package org.jsonq.core.jsonvalue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jsonq.core.exception.InvalidJSONValueTypeException;

import java.util.ArrayList;
import java.util.Objects;

public class JSONArray extends JSONValue{

    private String value;
    private ArrayList<JSONValue> elements;

    public JSONArray()
    {
        this.value = "[]";
        this.elements = new ArrayList<>();
    }

    public JSONArray(String value)
    {
        this.value = value;
        this.elements = new ArrayList<>();
    }

    /*
     * general getters, need to cast because it return abstract value
     * */
    public JSONValue getValueAt(int i)
    {
        return elements.get(i);
    }

    /*
    * getter
    * */

    public JSONObject getObjectAt(int i)
    {
        if (elements.get(i) instanceof JSONObject) return (JSONObject) elements.get(i);
        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONArray getArrayAt(int i)
    {
        if (elements.get(i) instanceof JSONArray) return (JSONArray) elements.get(i);
        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONNumber getNumberAt(int i)
    {
        if (elements.get(i) instanceof JSONNumber) return (JSONNumber) elements.get(i);
        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONString getStringAt(int i)
    {
        if (elements.get(i) instanceof JSONString) return (JSONString) elements.get(i);
        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONBoolean getBooleanAt(int i)
    {
        if (elements.get(i) instanceof JSONBoolean) return (JSONBoolean) elements.get(i);
        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    /*
     * general setters, in order to use the return value, cast the return value to the wanted value type if you want to use it as an argument
     * */
    public JSONValue setValueAt(int i, JSONValue v)
    {
        elements.set(i, v);
        updateValueString();
        return elements.get(i);
    }

    /*
    * setters
    * */
    public JSONObject setObjectAt(int i, JSONObject object)
    {
        elements.set(i, object);
        updateValueString();
        return (JSONObject) elements.get(i);
    }

    public JSONArray setArrayAt(int i, JSONArray array)
    {
        elements.set(i, array);
        updateValueString();
        return (JSONArray) elements.get(i);
    }

    public JSONNumber setNumberAt(int i, String number)
    {
        if (isNumeric(number))
        {
            elements.set(i, new JSONNumber(number));
            updateValueString();
            return (JSONNumber) elements.get(i);
        }
        throw new NumberFormatException();
    }

    public JSONString setStringAt(int i, String st)
    {
        elements.set(i, new JSONString("\"" + st + "\""));
        updateValueString();
        return (JSONString) elements.get(i);
    }

    public JSONBoolean setBoolAt(int i, boolean bool)
    {
        elements.set(i, new JSONBoolean(bool));
        updateValueString();
        return (JSONBoolean) elements.get(i);
    }


    /*
    * general adder, cast the return value to the wanted value type if you want to use it as an argument
    * */
    public JSONValue addValue(JSONValue value)
    {
        elements.add(value);
        updateValueString();
        return elements.get(elements.size()-1);
    }

    /*
    * element adder for instant appending
    * */

    public JSONObject addObject(JSONObject object)
    {
        elements.add(object);
        updateValueString();
        return (JSONObject) elements.get(elements.size()-1);
    }

    public JSONArray addArray(JSONArray array)
    {
        elements.add(array);
        updateValueString();
        return (JSONArray) elements.get(elements.size()-1);
    }

    public JSONNumber addNumber(JSONNumber number)
    {
        elements.add(number);
        updateValueString();
        return (JSONNumber) elements.get(elements.size()-1);
    }

    public JSONString addString(JSONString string)
    {
        elements.add(string);
        updateValueString();
        return (JSONString) elements.get(elements.size()-1);
    }

    public JSONBoolean addBoolean(JSONBoolean bool)
    {
        elements.add(bool);
        updateValueString();
        return (JSONBoolean) elements.get(elements.size()-1);
    }

    /*
    * element remover
    * */
    public void removeElement(int i)
    {
        elements.remove(i);
        updateValueString();
    }

    public void removeElement(JSONValue value)
    {
        elements.remove(value);
        updateValueString();
    }

    public void updateValueString()
    {
        value = "[";

        for (JSONValue v : elements)
        {
            value += v.getValue() + ",";
        }

        value = value.replaceAll(",$", "") + "]";
    }

    public String getValue() {
        return value;
    }

    public ArrayList<JSONValue> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONArray)) return false;
        JSONArray jsonArray = (JSONArray) o;
        return Objects.equals(value, jsonArray.value) &&
                Objects.equals(elements, jsonArray.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, elements);
    }
}
