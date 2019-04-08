package org.jsonq.core.jsonvalue;

import java.util.Objects;

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
        if (this.value == null)
            return null;
        return value;
    }

    public Boolean getLiteralValue() {
        if (this.value == null)
            return null;
        return literalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONBoolean)) return false;
        JSONBoolean that = (JSONBoolean) o;
        return literalValue == that.literalValue &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, literalValue);
    }
}
