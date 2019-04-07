package org.jsonq.core.listener;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jsonq.core.antlrgenerated.JSONListener;
import org.jsonq.core.antlrgenerated.JSONParser;
import org.jsonq.core.jsonvalue.*;
import org.jsonq.core.jsonvalue.JSONObject;

public class BaseListener implements JSONListener {

    private JSONObject currentObject = null;
    private JSONArray currentArray = null;
    private boolean listenTo; // true for listen to object, false for listen to array

    public static boolean canExecuteSomething = true;

    private String tempKey = "";

    private boolean inNestedObject = false;
    private boolean inNestedArray = false;
    private int objectScopeDeepCount = 0;
    private int arrayScopeDeepCount = 0;

    public BaseListener(JSONObject currentObject)
    {
        this.currentObject = currentObject;
        listenTo = true;
    }

    public BaseListener(JSONArray currentArray)
    {
        this.currentArray = currentArray;
        listenTo = false;
    }

    public void enterComments(JSONParser.CommentsContext ctx) {

    }

    public void exitComments(JSONParser.CommentsContext ctx) {

    }

    public void enterObjectRoot(JSONParser.ObjectRootContext ctx) {

    }

    public void exitObjectRoot(JSONParser.ObjectRootContext ctx) {

    }

    public void enterPair(JSONParser.PairContext ctx) {

    }

    public void exitPair(JSONParser.PairContext ctx) {

    }

    public void enterKey(JSONParser.KeyContext ctx) {

    }

    public void exitKey(JSONParser.KeyContext ctx) {

        if (listenTo)
        {
            if (!inNestedObject)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();
                tempKey = input.getText(interval).replaceAll("\"", "");
            }
        }
        else
        {
            if (!inNestedArray)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();
                tempKey = input.getText(interval).replaceAll("\"", "");
            }
        }
    }

    public void enterValue(JSONParser.ValueContext ctx) {

    }

    public void exitValue(JSONParser.ValueContext ctx) {

    }

    public void enterStringLiteral(JSONParser.StringLiteralContext ctx) {

    }

    public void exitStringLiteral(JSONParser.StringLiteralContext ctx) {

        if (listenTo)
        {
            if (!inNestedObject && !inNestedArray)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                /*
                 * if the valueMap of currentObject has previous pair with same key, then the old pair would be swapped
                 * to duplicatesMap, and removed from the valueMap.
                 **/
                if (currentObject.getValueMap().containsKey(tempKey))
                {
                    currentObject.swapToDuplicates(tempKey);
                }

                //add current pair to valueMap
                currentObject.getValueMap().put(tempKey, new JSONString(input.getText(interval)));
            }
        }
        else
        {
            if (!inNestedArray && !inNestedObject)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                currentArray.getElements().add(new JSONString(input.getText(interval)));
            }
        }
    }

    public void enterNullLiteral(JSONParser.NullLiteralContext ctx) {

    }

    public void exitNullLiteral(JSONParser.NullLiteralContext ctx) {

        if (listenTo)
        {
            currentObject.getValueMap().put(tempKey, new JSONNull());
        }
        else
        {
            currentArray.getElements().add(new JSONNull());
        }
    }

    public void enterBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

    }

    public void exitBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

        if (listenTo)
        {
            if (!inNestedObject && !inNestedArray)
            {
                if (currentObject.getValueMap().containsKey(tempKey))
                {
                    currentObject.swapToDuplicates(tempKey);
                }

                if (ctx.getText().equals("true")) currentObject.getValueMap().put(tempKey, new JSONBoolean(true));
                else currentObject.getValueMap().put(tempKey, new JSONBoolean(false));
            }
        }
        else
        {
            if (!inNestedArray && !inNestedObject)
            {
                currentArray.getElements().add(new JSONBoolean(ctx.getText().equals("true")));
            }
        }
    }

    public void enterNumberLiteral(JSONParser.NumberLiteralContext ctx) {

    }

    public void exitNumberLiteral(JSONParser.NumberLiteralContext ctx) {

        if (listenTo)
        {
            if (!inNestedObject && !inNestedArray)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                /*
                 * if the valueMap of currentObject has previous pair with same key, then the old pair would be swapped
                 * to duplicatesMap, and removed from the valueMap.
                 **/
                if (currentObject.getValueMap().containsKey(tempKey))
                {
                    currentObject.swapToDuplicates(tempKey);
                }

                currentObject.getValueMap().put(tempKey, new JSONNumber(input.getText(interval)));
            }
        }
        else
        {
            if (!inNestedArray && !inNestedObject)
            {
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                currentArray.getElements().add(new JSONNumber(input.getText(interval)));
            }
        }
    }

    public void enterObject(JSONParser.ObjectContext ctx) {

        if (listenTo)
        {
            if (!inNestedArray && !inNestedObject)
            {
                inNestedObject = true;
                objectScopeDeepCount++;
            }
        }
        else
        {

        }
    }

    public void exitObject(JSONParser.ObjectContext ctx) {

        if (listenTo)
        {
            objectScopeDeepCount--;

            if (objectScopeDeepCount == 0)
            {
                inNestedObject = false;
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                /*
                 * if the valueMap of currentObject has previous pair with same key, then the old pair would be swapped
                 * to duplicatesMap, and removed from the valueMap.
                 **/
                if (currentObject.getValueMap().containsKey(tempKey))
                {
                    currentObject.swapToDuplicates(tempKey);
                }

                currentObject.getValueMap().put(tempKey, new JSONObject(input.getText(interval)));
            }
        }
        else
        {

        }

    }

    public void enterArray(JSONParser.ArrayContext ctx) {

        if (listenTo)
        {

            if (!inNestedObject && !inNestedArray)
            {
                arrayScopeDeepCount++;
                inNestedArray = true;
            }

//            arrayScopeDeepCount++;
//            inNestedArray = true;
        }
        else
        {

        }
    }

    public void exitArray(JSONParser.ArrayContext ctx) {

        if (listenTo)
        {
            arrayScopeDeepCount--;

            if (arrayScopeDeepCount == 0)
            {
                inNestedArray = false;
                int a = ctx.start.getStartIndex();
                int b = ctx.stop.getStopIndex();
                Interval interval = new Interval(a, b);
                CharStream input = ctx.start.getInputStream();

                /*
                 * if the valueMap of currentObject has previous pair with same key, then the old pair would be swapped
                 * to duplicatesMap, and removed from the valueMap.
                 **/
                if (currentObject.getValueMap().containsKey(tempKey))
                {
                    currentObject.swapToDuplicates(tempKey);
                }

                currentObject.getValueMap().put(tempKey, new JSONArray(input.getText(interval)));
            }
        }
        else
        {

        }
    }

    public void visitTerminal(TerminalNode node) {

    }

    public void visitErrorNode(ErrorNode node) {
        canExecuteSomething = false;
    }

    public void enterEveryRule(ParserRuleContext ctx) {

    }

    public void exitEveryRule(ParserRuleContext ctx) {

    }

}
