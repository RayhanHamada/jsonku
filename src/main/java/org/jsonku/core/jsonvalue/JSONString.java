package org.jsonku.core.jsonvalue;

import java.util.Objects;

public class JSONString extends JSONValue {

    private String value;

    public JSONString(String value)
    {
        if (value == null)
            this.value = null;
        else
            this.value = value;
    }

    public String toString()
    {
        if (this.value == null) return null;
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
