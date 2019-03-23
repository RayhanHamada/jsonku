package org.jsonq.core.jsonvalue;

import java.util.Objects;

public class JSONString extends JSONValue {

    private String value;

    public JSONString(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONString)) return false;
        JSONString that = (JSONString) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
