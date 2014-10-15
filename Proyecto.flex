import java_cup.runtime.*;
%%

%unicode
%class Proyecto
%int
%line
%state Comentario
%column
%cup

letra = [A-Za-z]
digito = [0-9]
coma = ","
declaracion = ":"
punto ="."
alpha = {letra}|{digito}
id = {letra}({alpha})*
num={digito}+
vchar ={comilla}{alpha}{comilla}
cualquiera= [^\n]
parrafo=[^]
comentario={corcheteizq}{parrafo}+{corcheteder}
vstring={comilla}{cualquiera}+{comilla}
esp = " "
parizq= "("
parder = ")"
llaveizq="["
llaveder="]"
corcheteizq= "{"
corcheteder= "}"
assig = ":="
comilla = '
opsuma = [-]|[+]
opmult = "*"|"/"
diferente= <>
menorigual= <=
mayorigual= >=
oplog = {diferente}|[<]|[>]|{menorigual}|{mayorigual}|[=]
array = Array
integer = Integer
boolean = boolean
bool = true|false
char = char
string = string
of = of
if = if
else = else
then = then
while = while
do = do
repeat = repeat
until = until
for = for
to = to
downto = downto
program = program
begin = begin
end = end
procedure = procedure
function = function
var = var
write = write
read = read
div = div
mod = mod
or= or
not = not
and = and
cierre= ";"
Saltolinea = \n|\t|\r


%%

<YYINITIAL> {

	{Saltolinea}	{System.out.println();}

	{esp}	{}

	{assig}	{
	return new Symbol(sym.ASSIG, yyline, yycolumn);
	}

	{punto}	{
	return new Symbol(sym.PUNTO, yyline, yycolumn);
	}

	{coma}	{
	return new Symbol(sym.COMA, yyline, yycolumn);
	}

	{parizq}	{
	return new Symbol(sym.PARIZQ, yyline, yycolumn);
	}

	{parder}	{
	return new Symbol(sym.PARDER, yyline, yycolumn);
	}

	{llaveizq}	{
	return new Symbol(sym.LLAVEIZQ, yyline, yycolumn);
	}

	{llaveder}	{
	return new Symbol(sym.LLAVEDER, yyline, yycolumn);
	}
	
	{declaracion}	{
	return new Symbol(sym.DECLARACION, yyline, yycolumn);
	}

	{comentario}	{return new Symbol(sym.COMENTARIO, yyline, yycolumn, yytext());}

	{integer}	{
		return new Symbol(sym.INTEGER, yyline, yycolumn, yytext());
	}

	{boolean}	{
		return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext());
	}
	{bool}	{
		return new Symbol(sym.BOOL,yyline, yycolumn, yytext());
	}
	{char}	{ 
		return new Symbol(sym.CHAR,yyline, yycolumn, yytext());
	}

	{string}	{
		return new Symbol(sym.STRING,yyline, yycolumn, yytext());
	}

	{of}	{
		return new Symbol(sym.OF,yyline, yycolumn, yytext());
	}

	{if}	{
		return new Symbol(sym.IF,yyline, yycolumn, yytext());
	}

	{else}	{
		return new Symbol(sym.ELSE,yyline, yycolumn, yytext());
	}

	{then}	{
		return new Symbol(sym.THEN,yyline, yycolumn, yytext());
	}

	{while}	{
		return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
	}

	{do}	{
		return new Symbol(sym.DO, yyline, yycolumn, yytext());
	}

	{repeat}	{return new Symbol(sym.REPEAT,yyline, yycolumn, yytext());}

	{until}	{return new Symbol(sym.UNTIL,yyline, yycolumn, yytext());}

	{for}	{return new Symbol(sym.FOR,yyline, yycolumn, yytext());}

	{to}	{return new Symbol(sym.TO,yyline, yycolumn, yytext());}

	{downto}	{return new Symbol(sym.DOWNTO,yyline, yycolumn, yytext());}

	{program}	{return new Symbol(sym.PROGRAM,yyline, yycolumn, yytext());}

	{begin}	{
		return new Symbol(sym.BEGIN,yyline, yycolumn, yytext());
	}

	{end}	{
		return new Symbol(sym.END,yyline, yycolumn, yytext());
	}

	{procedure}	{
		return new Symbol(sym.PROCEDURE,yyline, yycolumn, yytext());
	}

	{function}	{
		return new Symbol(sym.FUNCTION,yyline, yycolumn, yytext());
	}

	{var}	{
		return new Symbol(sym.VAR,yyline, yycolumn, yytext());
	}

	{write}	{ 
		return new Symbol(sym.WRITE,yyline, yycolumn, yytext());
	}

	{read}	{ 
		return new Symbol(sym.READ,yyline, yycolumn, yytext());
	}

	{div}	{ 
		return new Symbol(sym.DIV,yyline, yycolumn, yytext());
	}

	{mod}	{ 
		return new Symbol(sym.MOD,yyline, yycolumn, yytext());
	}

	{or}	{ 
		return new Symbol(sym.OR,yyline, yycolumn, yytext());
	}

	{not}	{ 
		return new Symbol(sym.NOT,yyline, yycolumn, yytext());
	}

	{and}	{ 
		return new Symbol(sym.AND,yyline, yycolumn, yytext());
	}

	{array}	{
		return new Symbol(sym.ARRAY,yyline, yycolumn, yytext());
	}

	{id}	{return new Symbol(sym.ID,yyline, yycolumn,yytext());}

	{cierre}	{return new Symbol(sym.CIERRE,yyline, yycolumn);}	

	{vchar}	{ 
		return new Symbol(sym.VCHAR,yyline, yycolumn,yytext());
	}

	{vstring}	{
	return new Symbol(sym.VSTRING, yyline, yycolumn, yytext());
	}

	{opsuma}	{
		return new Symbol(sym.OPSUMA,yyline, yycolumn, yytext());
	}

	{opmult}	{
		return new Symbol(sym.OPMULT,yyline, yycolumn, yytext());
	}

	{oplog}	{ 
		return new Symbol(sym.OPLOG, yyline, yycolumn, yytext());
	}
	

	{num}	{
		return new Symbol(sym.NUM, yyline, yycolumn, Integer.parseInt(yytext()));
	}
	

	.	{System.out.println("Se encontro un error: " + "linea: " + yyline + " " + "columna: " + yycolumn + " " + yytext());}

}



