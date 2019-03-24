package org.jsonq.core.listener;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jsonq.core.antlrgenerated.JSONListener;
import org.jsonq.core.antlrgenerated.JSONParser;
import org.jsonq.core.jsonvalue.*;
import org.jsonq.core.jsonvalue.JSONArray;
import org.jsonq.core.jsonvalue.JSONObject;

public class BaseListener implements JSONListener {

    private JSONObject currentObject;
    private JSONArray  currentArray;
    private String tempKey = "";

    private boolean inOtherObject = false;

    private int deepCount = 0;

    public BaseListener(JSONObject currentObject)
    {
        this.currentObject = currentObject;
        this.currentArray = null;
    }

    public BaseListener(JSONArray currentArray)
    {
        this.currentArray = currentArray;
        this.currentObject = null;
    }


    public void enterComments(JSONParser.CommentsContext ctx) {

    }

    public void exitComments(JSONParser.CommentsContext ctx) {

    }

    public void enterRoot(JSONParser.RootContext ctx) {

    }

    public void exitRoot(JSONParser.RootContext ctx) {

    }

    public void enterPair(JSONParser.PairContext ctx) {

    }

    public void exitPair(JSONParser.PairContext ctx) {

    }

    public void enterKey(JSONParser.KeyContext ctx) {

    }

    public void exitKey(JSONParser.KeyContext ctx) {

        if (!inOtherObject)
        {
            int a = ctx.start.getStartIndex();
            int b = ctx.stop.getStopIndex();
            Interval interval = new Interval(a, b);
            CharStream input = ctx.start.getInputStream();
            tempKey = input.getText(interval).replaceAll("\"", "");

        }
    }

    public void enterValue(JSONParser.ValueContext ctx) {

    }

    public void exitValue(JSONParser.ValueContext ctx) {

    }

    public void enterStringLiteral(JSONParser.StringLiteralContext ctx) {

    }

    public void exitStringLiteral(JSONParser.StringLiteralContext ctx) {

        if (!inOtherObject)
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

    public void enterNullLiteral(JSONParser.NullLiteralContext ctx) {

    }

    public void exitNullLiteral(JSONParser.NullLiteralContext ctx) {

        if (!inOtherObject)
        {
            /*
             * if the valueMap of currentObject has previous pair with same key, then the old pair would be swapped
             * to duplicatesMap, and removed from the valueMap.
             **/
            if (currentObject.getValueMap().containsKey(tempKey))
            {
                currentObject.swapToDuplicates(tempKey);
            }

            currentObject.getValueMap().put(tempKey, null);
        }
    }

    public void enterBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

    }

    public void exitBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

        if (!inOtherObject)
        {
            if (currentObject.getValueMap().containsKey(tempKey))
            {
                currentObject.swapToDuplicates(tempKey);
            }

            if (ctx.getText().equals("true")) currentObject.getValueMap().put(tempKey, new JSONBoolean(true));
            else currentObject.getValueMap().put(tempKey, new JSONBoolean(false));
        }
    }

    public void enterNumberLiteral(JSONParser.NumberLiteralContext ctx) {

    }

    public void exitNumberLiteral(JSONParser.NumberLiteralContext ctx) {

        if (!inOtherObject)
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

    public void enterObject(JSONParser.ObjectContext ctx) {

        inOtherObject = true;
        deepCount++;
    }

    public void exitObject(JSONParser.ObjectContext ctx) {

        deepCount--;
        if (deepCount == 0)
        {
            inOtherObject = false;
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
                currentObject.getValueMap().remove(tempKey);

            }

            currentObject.getValueMap().put(tempKey, new JSONObject(input.getText(interval)));
        }

    }

    public void enterArray(JSONParser.ArrayContext ctx) {

    }

    public void exitArray(JSONParser.ArrayContext ctx) {

    }

    public void visitTerminal(TerminalNode node) {

    }

    public void visitErrorNode(ErrorNode node) {

    }

    public void enterEveryRule(ParserRuleContext ctx) {

    }

    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
