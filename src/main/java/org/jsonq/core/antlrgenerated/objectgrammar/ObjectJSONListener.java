// Generated from D:/RayhanHamada/CodingStuff/Exercise/Java/jsonq/src/main/resources\ObjectJSON.g4 by ANTLR 4.7.2
package org.jsonq.core.antlrgenerated.objectgrammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ObjectJSONParser}.
 */
public interface ObjectJSONListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(ObjectJSONParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(ObjectJSONParser.CommentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#objectRoot}.
	 * @param ctx the parse tree
	 */
	void enterObjectRoot(ObjectJSONParser.ObjectRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#objectRoot}.
	 * @param ctx the parse tree
	 */
	void exitObjectRoot(ObjectJSONParser.ObjectRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(ObjectJSONParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(ObjectJSONParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(ObjectJSONParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(ObjectJSONParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ObjectJSONParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ObjectJSONParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ObjectJSONParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ObjectJSONParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(ObjectJSONParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(ObjectJSONParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(ObjectJSONParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(ObjectJSONParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(ObjectJSONParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(ObjectJSONParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(ObjectJSONParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(ObjectJSONParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObjectJSONParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(ObjectJSONParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObjectJSONParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(ObjectJSONParser.ArrayContext ctx);
}