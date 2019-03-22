// Generated from D:/RayhanHamada/CodingStuff/Exercise/Java/jsonq/src/main/resources\JSON.g4 by ANTLR 4.7.2
package org.jsonq.core.antlrgenerated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSONLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, TO_SKIP=9, 
		BOOLEAN_LITERAL=10, NULL_LITERAL=11, IDENTIFIER=12, DECIMAL_LITERAL=13, 
		FLOAT_LITERAL=14, STRING_LITERAL=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "TO_SKIP", 
			"BOOLEAN_LITERAL", "NULL_LITERAL", "IDENTIFIER", "DECIMAL_LITERAL", "FLOAT_LITERAL", 
			"STRING_LITERAL", "DecDigit", "EscapeSequence", "HexDigit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/*'", "'*/'", "'{'", "','", "'}'", "':'", "'['", "']'", null, 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "TO_SKIP", "BOOLEAN_LITERAL", 
			"NULL_LITERAL", "IDENTIFIER", "DECIMAL_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JSONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\5\n;\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13H\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\rQ\n\r\f\r\16"+
		"\rT\13\r\3\16\3\16\7\16X\n\16\f\16\16\16[\13\16\3\16\5\16^\n\16\3\17\6"+
		"\17a\n\17\r\17\16\17b\3\17\3\17\7\17g\n\17\f\17\16\17j\13\17\3\17\3\17"+
		"\6\17n\n\17\r\17\16\17o\5\17r\n\17\3\17\3\17\5\17v\n\17\3\17\6\17y\n\17"+
		"\r\17\16\17z\5\17}\n\17\3\17\5\17\u0080\n\17\3\17\6\17\u0083\n\17\r\17"+
		"\16\17\u0084\3\17\3\17\5\17\u0089\n\17\3\17\5\17\u008c\n\17\3\17\3\17"+
		"\5\17\u0090\n\17\3\20\3\20\3\20\7\20\u0095\n\20\f\20\16\20\u0098\13\20"+
		"\3\20\3\20\3\20\3\20\7\20\u009e\n\20\f\20\16\20\u00a1\13\20\3\20\5\20"+
		"\u00a4\n\20\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00ac\n\22\3\22\5\22\u00af"+
		"\n\22\3\22\3\22\3\22\6\22\u00b4\n\22\r\22\16\22\u00b5\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u00bd\n\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2%\2\3\2\16\5\2\13"+
		"\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\4\2\62;aa\4\2GGgg\6\2FFHHffhh\6\2"+
		"\f\f\17\17$$^^\3\2\62;\n\2$$))^^ddhhppttvv\3\2\62\65\3\2\629\5\2\62;C"+
		"Hch\2\u00d6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3\'\3\2\2"+
		"\2\5*\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3"+
		"\2\2\2\21\67\3\2\2\2\23:\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31N\3\2\2\2\33"+
		"U\3\2\2\2\35\u008f\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00bc\3\2"+
		"\2\2%\u00be\3\2\2\2\'(\7\61\2\2()\7,\2\2)\4\3\2\2\2*+\7,\2\2+,\7\61\2"+
		"\2,\6\3\2\2\2-.\7}\2\2.\b\3\2\2\2/\60\7.\2\2\60\n\3\2\2\2\61\62\7\177"+
		"\2\2\62\f\3\2\2\2\63\64\7<\2\2\64\16\3\2\2\2\65\66\7]\2\2\66\20\3\2\2"+
		"\2\678\7_\2\28\22\3\2\2\29;\t\2\2\2:9\3\2\2\2;<\3\2\2\2<=\b\n\2\2=\24"+
		"\3\2\2\2>?\7v\2\2?@\7t\2\2@A\7w\2\2AH\7g\2\2BC\7h\2\2CD\7c\2\2DE\7n\2"+
		"\2EF\7u\2\2FH\7g\2\2G>\3\2\2\2GB\3\2\2\2H\26\3\2\2\2IJ\7p\2\2JK\7w\2\2"+
		"KL\7n\2\2LM\7n\2\2M\30\3\2\2\2NR\t\3\2\2OQ\t\4\2\2PO\3\2\2\2QT\3\2\2\2"+
		"RP\3\2\2\2RS\3\2\2\2S\32\3\2\2\2TR\3\2\2\2U]\5!\21\2VX\t\5\2\2WV\3\2\2"+
		"\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\^\5!\21\2]Y\3\2"+
		"\2\2]^\3\2\2\2^\34\3\2\2\2_a\5!\21\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2cd\3\2\2\2dh\7\60\2\2eg\5!\21\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi"+
		"\3\2\2\2ir\3\2\2\2jh\3\2\2\2km\7\60\2\2ln\5!\21\2ml\3\2\2\2no\3\2\2\2"+
		"om\3\2\2\2op\3\2\2\2pr\3\2\2\2q`\3\2\2\2qk\3\2\2\2r|\3\2\2\2su\t\6\2\2"+
		"tv\7-\2\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2wy\5!\21\2xw\3\2\2\2yz\3\2\2\2"+
		"zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|s\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080"+
		"\t\7\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0090\3\2\2\2\u0081\u0083"+
		"\5!\21\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u008b\3\2\2\2\u0086\u0088\t\6\2\2\u0087\u0089\7-"+
		"\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\5!\21\2\u008b\u0086\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\t\7\2\2\u008e\u0090\3\2\2\2\u008fq\3\2\2\2\u008f\u0082"+
		"\3\2\2\2\u0090\36\3\2\2\2\u0091\u0096\7$\2\2\u0092\u0095\n\b\2\2\u0093"+
		"\u0095\5#\22\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u00a4\7$\2\2\u009a\u009f\7)\2\2\u009b\u009e\n\b\2"+
		"\2\u009c\u009e\5#\22\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a1"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a4\7)\2\2\u00a3\u0091\3\2\2\2\u00a3\u009a\3\2"+
		"\2\2\u00a4 \3\2\2\2\u00a5\u00a6\t\t\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7"+
		"^\2\2\u00a8\u00bd\t\n\2\2\u00a9\u00ae\7^\2\2\u00aa\u00ac\t\13\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\t\f"+
		"\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00bd\t\f\2\2\u00b1\u00b3\7^\2\2\u00b2\u00b4\7w\2\2\u00b3\u00b2\3\2\2"+
		"\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b8\5%\23\2\u00b8\u00b9\5%\23\2\u00b9\u00ba\5%\23\2\u00ba"+
		"\u00bb\5%\23\2\u00bb\u00bd\3\2\2\2\u00bc\u00a7\3\2\2\2\u00bc\u00a9\3\2"+
		"\2\2\u00bc\u00b1\3\2\2\2\u00bd$\3\2\2\2\u00be\u00bf\t\r\2\2\u00bf&\3\2"+
		"\2\2\35\2:GRY]bhoquz|\177\u0084\u0088\u008b\u008f\u0094\u0096\u009d\u009f"+
		"\u00a3\u00ab\u00ae\u00b5\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}