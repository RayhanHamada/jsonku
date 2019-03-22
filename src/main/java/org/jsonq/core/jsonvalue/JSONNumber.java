package org.jsonq.core.jsonvalue;

public class JSONNumber extends JSONValue {

    private String value;

    public JSONNumber(String value)
    {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer asInteger()
    {
        return Integer.parseInt(value);
    }

    public Float asFloat()
    {
        return Float.parseFloat((value.endsWith("f") || value.endsWith("F"))? value : value + "f");
    }

    public Long asLong()
    {
        return Long.parseLong(value);
    }

}
