package barquitos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var utilidades = new Utilidades();
        var juego = new Juego();
        var jugador = new Jugador();
        var lecturaTablero = new LecturaTablero();
        ArrayList<String> opciones = juego.getOpcionesSeleccionadas();

        String nombre = utilidades.pregunta("Nombre del jugador");
        juego.setJugador(new Jugador(nombre, 0, 4));

        System.out.println("Jugar mapa0");


        while (true) {
            String numero = utilidades.pregunta("Introduce número");
            String letra = utilidades.pregunta("Introduce letra");

            if (opciones.size() > 0) {
                for (int i = 0; i < opciones.size(); i++) {
                    if (!opciones.get(i).equals(numero + letra)) {
                        lecturaTablero.lecturaTablero(numero, letra);
                    }
                }
                System.out.println("Ya has seleccionado estas opciones. Íntentalo de nuevo");
            } else {
                lecturaTablero.lecturaTablero(numero, letra);
            }
        }
    }
}
