package org.jsonq.core.listener;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jsonq.core.antlrgenerated.JSONListener;
import org.jsonq.core.antlrgenerated.JSONParser;
import org.jsonq.core.jsonvalue.JSONArray;

public class ArrayBaseListener implements JSONListener {

    private JSONArray currentArray;

    public ArrayBaseListener(JSONArray currentArray)
    {
        this.currentArray = currentArray;
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

    }

    public void enterValue(JSONParser.ValueContext ctx) {

    }

    public void exitValue(JSONParser.ValueContext ctx) {

    }

    public void enterStringLiteral(JSONParser.StringLiteralContext ctx) {

    }

    public void exitStringLiteral(JSONParser.StringLiteralContext ctx) {

    }

    public void enterNullLiteral(JSONParser.NullLiteralContext ctx) {

    }

    public void exitNullLiteral(JSONParser.NullLiteralContext ctx) {

    }

    public void enterBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

    }

    public void exitBooleanLiteral(JSONParser.BooleanLiteralContext ctx) {

    }

    public void enterNumberLiteral(JSONParser.NumberLiteralContext ctx) {

    }

    public void exitNumberLiteral(JSONParser.NumberLiteralContext ctx) {

    }

    public void enterObject(JSONParser.ObjectContext ctx) {

    }

    public void exitObject(JSONParser.ObjectContext ctx) {

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
