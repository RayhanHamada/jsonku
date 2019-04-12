// Generated from D:/RayhanHamada/CodingStuff/Exercise/Java/jsonq/src/main/resources\JSON.g4 by ANTLR 4.7.2
package org.jsonq.core.antlrgenerated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSONParser}.
 */
public interface JSONListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSONParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(JSONParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(JSONParser.CommentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#objectRoot}.
	 * @param ctx the parse tree
	 */
	void enterObjectRoot(JSONParser.ObjectRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#objectRoot}.
	 * @param ctx the parse tree
	 */
	void exitObjectRoot(JSONParser.ObjectRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#arrayRoot}.
	 * @param ctx the parse tree
	 */
	void enterArrayRoot(JSONParser.ArrayRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#arrayRoot}.
	 * @param ctx the parse tree
	 */
	void exitArrayRoot(JSONParser.ArrayRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JSONParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JSONParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(JSONParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(JSONParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(JSONParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(JSONParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(JSONParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(JSONParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(JSONParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(JSONParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(JSONParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(JSONParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(JSONParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(JSONParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(JSONParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(JSONParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(JSONParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSONParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(JSONParser.ArrayContext ctx);
}