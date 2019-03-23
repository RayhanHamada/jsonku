package org.jsonq.core.jsonvalue;

import java.util.Objects;

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
