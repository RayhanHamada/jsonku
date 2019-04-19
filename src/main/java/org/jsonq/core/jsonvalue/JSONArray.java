package org.jsonq.core.jsonvalue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.jsonq.core.antlrgenerated.JSONLexer;
import org.jsonq.core.antlrgenerated.JSONParser;
import org.jsonq.core.exception.InvalidJSONValueTypeException;
import org.jsonq.core.listener.BaseListener;

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

        /*
         * if the value is null or an empty array then don't parse it, if not, then parse
         * */

        if (value != null)
        {
            if (!value.equals("[]"))
            {
                CharStream input = CharStreams.fromString(value);
                JSONLexer lexer = new JSONLexer(input);
                JSONParser parser = new JSONParser(new CommonTokenStream(lexer));
                parser.addParseListener(new BaseListener(this));
                parser.arrayRoot();
            }
        }

        if (!BaseListener.canExecuteSomething)
            System.exit(1);
    }

    /*
     * general getters, need to cast because it return abstract value
     * */
    public JSONValue getValueAt(int i)
    {
        if (this.value == null)
            return null;
        return elements.get(i);
    }

    /*
    * getter
    * */

    public JSONObject getObjectAt(int i)
    {
        if (this.value == null || this.elements.get(i) instanceof JSONNull)
            return new JSONObject(null);

        if (elements.get(i) instanceof JSONObject)
            return (JSONObject) elements.get(i);

        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONArray getArrayAt(int i)
    {
        if (this.value == null || this.elements.get(i) instanceof JSONNull)
            return new JSONArray(null);

        if (elements.get(i) instanceof JSONArray)
            return (JSONArray) elements.get(i);

        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONNumber getNumberAt(int i)
    {
        if (this.value == null || this.elements.get(i) instanceof JSONNull)
            return null;

        if (elements.get(i) instanceof JSONNumber)
            return (JSONNumber) elements.get(i);

        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONString getStringAt(int i)
    {
        if (elements.get(i) instanceof JSONString)
            return (JSONString) elements.get(i);

        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    public JSONBoolean getBooleanAt(int i)
    {
        if (this.value == null || this.elements.get(i) instanceof JSONNull)
            return new JSONBoolean(null);

        if (elements.get(i) instanceof JSONBoolean)
            return (JSONBoolean) elements.get(i);

        throw new InvalidJSONValueTypeException("The type of the value to be returned is not same as the method return type.");
    }

    /*
     * general setters, in order to use the return value, cast the return value to the wanted value type if you want to use the value
     * */
    public JSONValue setValueAt(int i, JSONValue v)
    {
        elements.set(i, v);
        return elements.get(i);
    }

    /*
    * setters
    * */
    public JSONObject setObjectAt(int i, JSONObject object)
    {
        elements.set(i, object);
        return (JSONObject) elements.get(i);
    }

    public JSONArray setArrayAt(int i, JSONArray array)
    {
        elements.set(i, array);
        return (JSONArray) elements.get(i);
    }

    public void setNumberAt(int i, String number)
    {
        if (isNumeric(number))
        {
            elements.set(i, new JSONNumber(number));
            return;
        }
        throw new NumberFormatException();
    }

    public void setNumber(int i, int number)
    {
        elements.set(i, new JSONNumber(number));
    }

    public void setNumber(int i, float number)
    {
        elements.set(i, new JSONNumber(number));
    }

    public void setNumber(int i, long n)
    {
        elements.set(i, new JSONNumber(n));
    }

    public void setStringAt(int i, String st)
    {
        elements.set(i, new JSONString(st));
    }

    public void setBoolAt(int i, boolean bool)
    {
        elements.set(i, new JSONBoolean(bool));
    }

    /*
    * general adder, cast the return value to the wanted value type if you want to use it as an argument
    * */
    public JSONValue addValue(JSONValue value)
    {
        elements.add(value);
        return elements.get(elements.size()-1);
    }

    /*
    * element adder for appending elements in JSONArray
    * */

    public JSONObject addObject(JSONObject object)
    {
        elements.add(object);
        return (JSONObject) elements.get(elements.size()-1);
    }

    public void addEmptyObjects(int many) throws Exception
    {
        if (many <= 0) throw new Exception("the argument can't be less than or equal to 0");
        for (int i = 0; i < many; i++) elements.add(new JSONObject());
    }

    public JSONArray addArray(JSONArray array)
    {
        elements.add(array);
        return (JSONArray) elements.get(elements.size()-1);
    }

    public void addEmptyArrays(int many) throws Exception
    {
        if (many <= 0) throw new Exception("the argument can't be less than or equal to 0");
        for (int i = 0; i < many; i++) elements.add(new JSONArray());
    }


    public void addNumber(JSONNumber number)
    {
        elements.add(number);
    }

    public void addNumber(int n)
    {
        elements.add(new JSONNumber(Integer.toString(n)));
    }

    public void addNumber(float n)
    {
        elements.add(new JSONNumber(Float.toString(n)));
    }

    public void addNumber(long n)
    {
        elements.add(new JSONNumber(Long.toString(n)));
    }

    public void addNumbers(int...ints)
    {
        for (int i : ints) elements.add(new JSONNumber(i));
    }

    public void addNumbers(float...floats)
    {
        for (float f : floats) elements.add(new JSONNumber(f));
    }

    public void addNumbers(long...longs)
    {
        for (long l : longs) elements.add(new JSONNumber(l));
    }

    public void addString(JSONString string)
    {
        elements.add(string);
    }

    public void addString(String s)
    {
        elements.add(new JSONString(s));
    }

    public void addStrings(String...strings)
    {
        for (String st : strings) elements.add(new JSONString(st));
    }

    public void addBoolean(JSONBoolean bool)
    {
        elements.add(bool);
    }

    public void addBoolean(boolean bool)
    {
        elements.add(new JSONBoolean(Boolean.toString(bool)));
    }

    public void addBooleans(boolean...booleans)
    {
        for (boolean b : booleans) elements.add(new JSONBoolean(b));
    }

    public void addNull()
    {
        elements.add(new JSONNull());
    }

    public void addNulls(int many) throws Exception
    {
        if (many <= 0 ) throw new Exception("the parameter can't be less than or equal to 0");
        for (int i = 0; i < many; i++) elements.add(new JSONNull());
    }

    /*
    * element remover
    * */
    public void removeElement(int i)
    {
        elements.remove(i);
    }

    public void removeElement(JSONValue value)
    {
        elements.remove(value);
    }

    public String getValue() {
        updateValueString();
        return value;
    }

    public void updateValueString()
    {
        if (this.value == null) return;

        value = "[";

        for (JSONValue v : elements)
        {
            if (v instanceof JSONString) value += "\"" + v.getValue() + "\",";
            else value += v.getValue() + ", ";
        }

        value = value.replaceAll(",$", "") + "]";
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
