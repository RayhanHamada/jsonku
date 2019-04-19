package org.jsonku.core.jsonvalue;

import java.util.Objects;

public class JSONNumber extends JSONValue {

    private String value;

    public JSONNumber(String value)
    {
        this.value = value;
    }

    public JSONNumber(int value)
    {
        this.value = Integer.toString(value);
    }

    public JSONNumber(float value)
    {
        this.value = Float.toString(value);
    }

    public JSONNumber(long value)
    {
        this.value = Long.toString(value);
    }



    public String getValue() {
        if (this.value == null)
            return null;
        return value;
    }

    public Integer asInteger()
    {
        if (this.value == null || this.value.equals("null"))
            return null;
        return Integer.parseInt(value);
    }

    public Float asFloat()
    {
        if (this.value == null)
            return null;
        return Float.parseFloat((value.endsWith("f") || value.endsWith("F"))? value : value + "f");
    }

    public Long asLong()
    {
        if (this.value == null)
            return null;
        return Long.parseLong(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONNumber)) return false;
        JSONNumber that = (JSONNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
