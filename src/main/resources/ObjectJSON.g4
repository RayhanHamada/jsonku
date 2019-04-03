grammar ObjectJSON;

TO_SKIP     : ([\r\t\n] | ' ') -> skip
            ;

BOOLEAN_LITERAL     : 'true' | 'false'
                    ;

NULL_LITERAL        : 'null'
                    ;

IDENTIFIER
    : [A-Za-z] [A-Za-z0-9_]*
    ;

// literal
DECIMAL_LITERAL     : DecDigit ([0-9_]* DecDigit)?
                    ;

FLOAT_LITERAL       : (DecDigit+ '.' DecDigit* | '.' DecDigit+) ([Ee] '+'? DecDigit+)? [FfDd]?
                    | DecDigit+ (([Ee] '+'?) DecDigit)? [FfDd]
                    ;

STRING_LITERAL      : '"' (~["\\\r\n] | EscapeSequence)* '"'
                    | '\'' (~["\\\r\n] | EscapeSequence)* '\''
                    ;


fragment DecDigit
    : [0-9]
    ;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigit
    : [0-9A-Fa-f]
    ;

comments
    : '/*' .*? '*/'
    ;

objectRoot
    : '{' (pair (',' pair)*)* '}'
    | NULL_LITERAL
    ;

pair
    : key ':' value
    ;

key
    :STRING_LITERAL
    ;

value
    : booleanLiteral
    | stringLiteral
    | nullLiteral
    | numberLiteral
    | array
    | object
    ;

stringLiteral
    : STRING_LITERAL
    ;

nullLiteral
    : NULL_LITERAL
    ;

booleanLiteral
    : BOOLEAN_LITERAL
    ;

numberLiteral
    : DECIMAL_LITERAL
    | FLOAT_LITERAL
    ;

object
    : '{' (pair (',' pair)*)* '}'
    ;

array
    : '[' (value (',' value)*)* ']'
    ;