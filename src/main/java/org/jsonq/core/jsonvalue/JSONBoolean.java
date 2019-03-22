package org.jsonq.core.jsonvalue;

public class JSONBoolean extends JSONValue{

    private String value;
    private boolean literalValue;

    public JSONBoolean(String value)
    {
        this.value = value;
        this.literalValue = (value.equals("true"))? true : false;
    }

    public JSONBoolean(boolean literalValue)
    {
        this.literalValue = literalValue;
        this.value = (literalValue)? "true" : "false";
    }

    public String getValue()
    {
        return value;
    }

    public boolean getLiteralValue() {
        return literalValue;
    }
}
