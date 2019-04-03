package org.jsonq.core.listener;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jsonq.core.antlrgenerated.objectgrammar.ObjectJSONListener;
import org.jsonq.core.antlrgenerated.objectgrammar.ObjectJSONParser;
import org.jsonq.core.jsonvalue.*;
import org.jsonq.core.jsonvalue.JSONObject;

public class BaseListener implements ObjectJSONListener {

    private JSONObject currentObject = null;

    public static boolean canExecuteSomething = true;

    private String tempKey = "";

    private boolean inNestedObject = false;
    private boolean inNestedArray = false;
    private int objectScopeDeepCount = 0;
    private int arrayScopeDeepCount = 0;

    public BaseListener(JSONObject currentObject)
    {
        this.currentObject = currentObject;
    }

    public void enterComments(ObjectJSONParser.CommentsContext ctx) {

    }

    public void exitComments(ObjectJSONParser.CommentsContext ctx) {

    }

    public void enterObjectRoot(ObjectJSONParser.ObjectRootContext ctx) {

    }

    public void exitObjectRoot(ObjectJSONParser.ObjectRootContext ctx) {

    }

    public void enterPair(ObjectJSONParser.PairContext ctx) {

    }

    public void exitPair(ObjectJSONParser.PairContext ctx) {

    }

    public void enterKey(ObjectJSONParser.KeyContext ctx) {

    }

    public void exitKey(ObjectJSONParser.KeyContext ctx) {

        if (!inNestedObject)
        {
            int a = ctx.start.getStartIndex();
            int b = ctx.stop.getStopIndex();
            Interval interval = new Interval(a, b);
            CharStream input = ctx.start.getInputStream();
            tempKey = input.getText(interval).replaceAll("\"", "");

        }
    }

    public void enterValue(ObjectJSONParser.ValueContext ctx) {

    }

    public void exitValue(ObjectJSONParser.ValueContext ctx) {

    }

    public void enterStringLiteral(ObjectJSONParser.StringLiteralContext ctx) {

    }

    public void exitStringLiteral(ObjectJSONParser.StringLiteralContext ctx) {

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

    public void enterNullLiteral(ObjectJSONParser.NullLiteralContext ctx) {

    }

    public void exitNullLiteral(ObjectJSONParser.NullLiteralContext ctx) {

    }

    public void enterBooleanLiteral(ObjectJSONParser.BooleanLiteralContext ctx) {

    }

    public void exitBooleanLiteral(ObjectJSONParser.BooleanLiteralContext ctx) {

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

    public void enterNumberLiteral(ObjectJSONParser.NumberLiteralContext ctx) {

    }

    public void exitNumberLiteral(ObjectJSONParser.NumberLiteralContext ctx) {

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

    public void enterObject(ObjectJSONParser.ObjectContext ctx) {

        inNestedObject = true;
        objectScopeDeepCount++;
    }

    public void exitObject(ObjectJSONParser.ObjectContext ctx) {

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

    public void enterArray(ObjectJSONParser.ArrayContext ctx) {

        if (!inNestedObject)
        {
            arrayScopeDeepCount++;
            inNestedArray = true;
        }
    }

    public void exitArray(ObjectJSONParser.ArrayContext ctx) {
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
