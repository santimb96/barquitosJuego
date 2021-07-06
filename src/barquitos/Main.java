package barquitos;

public class Main {
    public static void main(String[] args) {
        var utilidades = new Utilidades();
        var juego = new Juego();
        var jugador = new Jugador();
        var lecturaTablero = new LecturaTablero();

        String nombre = utilidades.pregunta("Nombre del jugador");
        juego.setJugador(new Jugador(nombre, 0, 4));

        System.out.println("Jugar mapa0");

        while(true){
            String numero = utilidades.pregunta("Introduce número");
            String letra= utilidades.pregunta("Introduce letra");

            for (int i = 0; i < juego.getOpcionesSeleccionadas().size(); i++) {
                if(!juego.getOpcionesSeleccionadas().get(i).contains(numero+letra)) {
                    lecturaTablero.lecturaTablero(numero, letra);
                }
            }
            System.out.println("Ya has seleccionado estas opciones. Íntentalo de nuevo");

          /*  if(!juego.getOpcionesSeleccionadas().contains(numero+letra)) {
                lecturaTablero.lecturaTablero(numero, letra);
            } else {
                System.out.println("Ya has seleccionado estas opciones. Íntentalo de nuevo");
            }*/
        }
    }
}
