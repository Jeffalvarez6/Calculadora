package ejercicios.grandesnumeros;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculadoraNumerosGrandes {

    public String sumar(String numero1, String numero2) {
        Deque<Integer> pila1 = cargarPila(numero1);
        Deque<Integer> pila2 = cargarPila(numero2);
        Deque<Integer> pilaResultado = new ArrayDeque<>();

        int acarreo = 0;
        while (!pila1.isEmpty() || !pila2.isEmpty() || acarreo > 0) {
            int d1 = !pila1.isEmpty() ? pila1.pop() : 0;
            int d2 = !pila2.isEmpty() ? pila2.pop() : 0;

            int suma = d1 + d2 + acarreo;
            acarreo = suma / 10;
            pilaResultado.push(suma % 10);
        }

        StringBuilder resultado = new StringBuilder();
        while (!pilaResultado.isEmpty()) {
            resultado.append(pilaResultado.pop());
        }

        return resultado.toString();
    }

    private Deque<Integer> cargarPila(String numero) {
        Deque<Integer> pila = new ArrayDeque<>();
        for (char digit : numero.toCharArray()) {
            if (Character.isDigit(digit)) {
                pila.push(Character.getNumericValue(digit));
            }
        }
        return pila;
    }
}