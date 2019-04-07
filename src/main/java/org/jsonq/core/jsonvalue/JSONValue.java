package org.jsonq.core.jsonvalue;

public abstract class JSONValue {

    protected boolean isNumeric(String s)
    {

        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e)
        {
            // do nothing
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e)
        {
            // do nothing
        }

        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e)
        {

        }
        return false;
    }

    public abstract String getValue();
}
