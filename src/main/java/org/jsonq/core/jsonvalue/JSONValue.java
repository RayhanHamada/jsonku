package org.jsonq.core.jsonvalue;

public abstract class JSONValue {

//    protected abstract void  updateValueString();

    protected boolean isNumeric(String s)
    {
        try {
            Float.parseFloat(s);
            Integer.parseInt(s);
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
}
