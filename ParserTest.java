import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    Parser parser = new Parser();
    String resultado;
    @Test
    void parse() {

        //Operaciones aritmeticas y lógicas sin variables
        resultado= parser.parse("(+ 5 4)");
        assertEquals("9", resultado );

        resultado= parser.parse("(- 5 4)");
        assertEquals("1", resultado );

        resultado= parser.parse("(* 5 4)");
        assertEquals("20", resultado );

        resultado= parser.parse("(/ 5 5)");
        assertEquals("1", resultado );

        resultado= parser.parse("(++ 5)");
        assertEquals("6", resultado );

        resultado= parser.parse("(-- 5)");
        assertEquals("4", resultado );

        resultado= parser.parse("(-- 5)");
        assertEquals("4", resultado );

        resultado= parser.parse("(< 5.1 10.6)");
        assertEquals("true", resultado );

        resultado= parser.parse("(> 5 1)");
        assertEquals("true", resultado );

        resultado= parser.parse("(<= 5 5)");
        assertEquals("true", resultado );

        resultado= parser.parse("(>= 1 2)");
        assertEquals("false", resultado );

        resultado= parser.parse("(== 5 5)");
        assertEquals("true", resultado );

        resultado= parser.parse("(== 1.1 1.2)");
        assertEquals("false", resultado );

        resultado= parser.parse("(< 5.1 10.6)");
        assertEquals("true", resultado );

        //Una Variable
        parser.parse("(Let x 5)");
        resultado=parser.parse("(+ x 5)");
        assertEquals("10",resultado );

        //operaciones dentro de operaciones con paréntesis a la derecha
        resultado=parser.parse("(* (+ 5 x) 2)");
        assertEquals("20",resultado );

        //operaciones dentro de operaciones con dos paréntesis y con variables
        resultado=parser.parse("(+ (+ 5 x) (+ 5 x))");
        assertEquals("20",resultado );

        //operaciones dentro de operaciones con dos paréntesis floats y con variables
        resultado=parser.parse("(+ (+ 5.5 x) (+ 5.5 x))");
        assertEquals("21.0",resultado );

        // Operaciones aritméticas simples. Variable a la izquierda
        resultado=parser.parse("(+ x 10)");
        assertEquals("15",resultado );

        //operaciones dentro de operaciones con dos paréntesis y con variables
        resultado=parser.parse("(+ (+ 5.4 x) (+ 5.6 x))");
        assertEquals("21.0",resultado );

        // Operaciones aritméticas simples. Variable a la derecha
        resultado=parser.parse("(+ 5.4 x)");
        assertEquals("10.4",resultado );

        // Operaciones aritméticas simples. Variable a la izquierda
        resultado=parser.parse("(+ x 3)");
        assertEquals("8",resultado );

        // Operaciones aritméticas simples. Variable a ambos lados
        parser.parse("(Let a 10)");
        resultado=parser.parse("(+ x a)");
        assertEquals("15",resultado );

        //operaciones dentro de operaciones con  paréntesis y con variables
        resultado=parser.parse("(+ (+ a x) (+ a x))");
        assertEquals("30",resultado );

        //operaciones dentro de operaciones con  paréntesis y con cuatro variables
        parser.parse("(Let b 10)");
        resultado=parser.parse("(+ (+ a b) (+ a x))");
        assertEquals("35",resultado );

        //operaciones dentro de operaciones con  paréntesis y con cuatro variables
        parser.parse("(Let z 1.2)");
        resultado=parser.parse("(+ (+ b z) (+ a x))");
        assertEquals("26.2",resultado );

        // Operaciones lógicas simples dos variables
        parser.parse("(Let m 1)");
        parser.parse("(Let n 1)");
        resultado=parser.parse("(== m n)");
        assertEquals("true",resultado );

        // Operaciones lógicas simples dos variables y floats
        parser.parse("(Let m 1)");
        parser.parse("(Let n 1)");
        resultado=parser.parse("(== m b)");
        assertEquals("false",resultado );

        // Operaciones lógicas simples dos variables (mayor)
        resultado=parser.parse("(>= b m)");
        assertEquals("true",resultado );

        // Operaciones lógicas simples dos variables (mayor)
        resultado=parser.parse("(<= m n)");
        assertEquals("true",resultado );


    }

}