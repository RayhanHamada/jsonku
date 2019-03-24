package org.jsonq.core.customtools;

import org.jsonq.core.jsonvalue.JSONValue;

import java.util.Objects;

public class JSONPair {

    private String key;
    private JSONValue value;


    public JSONPair(String key, JSONValue value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public JSONValue getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JSONPair)) return false;
        JSONPair jsonPair = (JSONPair) o;
        return Objects.equals(key, jsonPair.key) &&
                Objects.equals(value, jsonPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
