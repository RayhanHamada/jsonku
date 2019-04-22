package org.jsonku.core.jsonvalue;

import java.util.Objects;

public class JSONBoolean extends JSONValue{

    private String stringValue;
    private boolean literalValue;

    public JSONBoolean(String stringValue)
    {
        this.stringValue = stringValue;
        this.literalValue = (stringValue.equals("true"))? true : false;
    }

    public JSONBoolean(boolean literalValue)
    {
        this.literalValue = literalValue;
        this.stringValue = (literalValue)? "true" : "false";
    }

    public String toString()
    {
        if (this.stringValue == null)
            return null;
        return stringValue;
    }

    public Boolean getLiteralValue() {
        if (this.stringValue == null)
            return null;
        return literalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONBoolean)) return false;
        JSONBoolean that = (JSONBoolean) o;
        return literalValue == that.literalValue &&
                Objects.equals(stringValue, that.stringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringValue, literalValue);
    }
}
