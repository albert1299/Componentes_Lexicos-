package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Tokens;

public class Lexico1 {

    private Integer posicion = 0;
    private Integer estado = 0;
    private List<String> tokens = new ArrayList<String>();
    private List<String> lexemas = new ArrayList<String>();
    private String lexema = "";
    private String entrada;
    private Character caracter;
    private Utilidades u = new Utilidades();

    public Lexico1(String entrada) {
        this.entrada = entrada;
    }

    public void imprimir() {
        System.out.println("Listo ..............");
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println("TOKEN: " + tokens.get(i) + " LEXEMA: " + lexemas.get(i));
        }
    }

    public void lexico() {
        caracter = entrada.charAt(posicion);
        switch (estado) {
            case 0:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter) && caracter != '0') {
                    estado = 4;
                    lexema += Character.toString(caracter);
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 'p') {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 'p') {
                    estado = 8;
                    lexema += Character.toString(caracter);
                } else {
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 1:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    if (caracter == '+') {
                        lexema += Character.toString(caracter);
                        estado = 0;
                        //cargarLexema(lexema, Tokens.INCREMENTO.toString());
                        lexema = "";
                    } else {
                        cargarLexema(lexema, Tokens.SUMA.toString());
                        lexema = "";
                        lexema += Character.toString(caracter);
                        estado = 0;
                        //cargarLexema(lexema, Tokens.PRODUCTO.toString());
                        lexema = "";
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.SUMA.toString());
                    lexema = "";
                    estado = 5;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.SUMA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 2:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    if (caracter == '+') {
                        lexema += Character.toString(caracter);
                        estado = 0;
                        //cargarLexema(lexema, Tokens.INCREMENTO.toString());
                        lexema = "";
                    } else {
                        cargarLexema(lexema, Tokens.SUMA.toString());
                        lexema = "";
                        lexema += Character.toString(caracter);
                        estado = 0;
                        //cargarLexema(lexema, Tokens.PRODUCTO.toString());
                        lexema = "";
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.SUMA.toString());
                    lexema = "";
                    estado = 5;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.SUMA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 4:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.ENTERO.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 'p') {
                    cargarLexema(lexema, Tokens.ENTERO.toString());
                    lexema = "";
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 'p') {
                    cargarLexema(lexema, Tokens.ENTERO.toString());
                    lexema = "";
                    estado = 8;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.ENTERO.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 6:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter)) {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 8:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 'r') {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 'r') {
                    estado = 9;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 9:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 'i') {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 'i') {
                    estado = 10;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 10:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 'n') {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 'n') {
                    estado = 11;
                    lexema += Character.toString(caracter);
                } else {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            case 11:
                if (u.verificarChar(u.operadoresAritmeticos(), String.valueOf(caracter))) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    switch (caracter) {
                        case '+':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.SUMA.toString());
                            lexema = "";
                            break;
                        case '-':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.RESTA.toString());
                            lexema = "";
                            break;
                        case '=':
                            lexema += Character.toString(caracter);
                            estado = 0;
                            cargarLexema(lexema, Tokens.ASIGNACION.toString());
                            lexema = "";
                            break;
                        default:
                            break;
                    }
                } else if (Character.isDigit(caracter)) {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    lexema += Character.toString(caracter);
                    estado = 4;
                } else if (Character.isLetter(caracter) && Character.toLowerCase(caracter) != 't') {
                    estado = 6;
                    lexema += Character.toString(caracter);
                } else if (Character.toLowerCase(caracter) == 't') {
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.IMPRIMIR.toString());
                    estado = 0;
                    lexema = "";
                } else {
                    cargarLexema(lexema, Tokens.LETRA.toString());
                    lexema = "";
                    estado = 0;
                    lexema += Character.toString(caracter);
                    cargarLexema(lexema, Tokens.ERROR.toString());
                    lexema = "";
                }
                break;
            default:
                break;
        }
        posicion++; //67216a
        if (posicion >= entrada.length()) {
            if (estado == 4) {
                cargarLexema(lexema, Tokens.ENTERO.toString());
            } else if (estado==6){
                cargarLexema(lexema, Tokens.LETRA.toString());
            }
        } else {
            lexico();
        }

    }

    private void cargarLexema(String lexema, String token) {
        lexemas.add(lexema);
        tokens.add(token);
    }

    public static void main(String[] args) {
        String cadena = "ab";
        Lexico1 lexico1 = new Lexico1(cadena);
        lexico1.lexico();
        lexico1.imprimir();
    }

}
