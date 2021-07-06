package barquitos;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Juego {

    private String[][] matriz = new String[50][50];
    private static ArrayList<String[]> listaMatriz = new ArrayList<>();
    private static ArrayList<String> opcionesSeleccionadas = new ArrayList<>();
    private static ArrayList<String> historicoResultados = new ArrayList<>();
    private static Jugador jugador;
    private static int turnos = 1;

    public static ArrayList<String> getHistoricoResultados() {
        return historicoResultados;
    }

    public static void setHistoricoResultados(ArrayList<String> historicoResultados) {
        Juego.historicoResultados = historicoResultados;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        Juego.jugador = jugador;
    }

    public ArrayList<String> getOpcionesSeleccionadas() {
        return opcionesSeleccionadas;
    }

    public void setOpcionesSeleccionadas(ArrayList<String> opcionesSeleccionadas) {
        Juego.opcionesSeleccionadas = opcionesSeleccionadas;
    }

    public ArrayList<String[]> getListaMatriz() {
        return listaMatriz;
    }

    public void setListaMatriz(ArrayList<String[]> listaMatriz) {
        this.listaMatriz = listaMatriz;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }




    public void resultadoJugada(int numFila, int indiceLetra, int lineas, int columnasNumero, String letra) {
        var jugador = new Jugador();
        ArrayList<String[]> lista = getListaMatriz();
        int columnas = columnasNumero;

        if (lista.size() > 0) {
            columnas = lista.get(0).length;

            for (int i = 0; i < lineas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = lista.get(i)[j];
                }
            }
        } else {
            System.out.println("No hay datos");
        }

        if (matriz[numFila][0] != null) {
            char[] texto = matriz[numFila][0].toCharArray();
            for (int i = 0; i < texto.length; i++) {
                if (texto[i] == texto[indiceLetra]) {
                    if (texto[i] == '1') {
                        System.out.println("Hundido!\n");
                        getJugador().setPuntuacion(getJugador().getPuntuacion() + 5);
                        getOpcionesSeleccionadas().add(numFila+letra);
                        getHistoricoResultados().add(String.format("Turno %01d: Hundido", turnos));
                        turnos++;
                        break;
                    } else {
                        System.out.println("Agua!\n");
                        getJugador().setIntentos(getJugador().getIntentos() - 1);
                        getOpcionesSeleccionadas().add(numFila+letra);
                        getHistoricoResultados().add(String.format("Turno %01d: Agua", turnos));
                        turnos++;
                        break;
                    }
                }
            }
        }

        if(getJugador().getPuntuacion()==15){
            valorar("VICTORIA");
        }
        if(getJugador().getIntentos()==0){
            valorar("DERROTA");
        }
    }

    public void valorar(String resultado){
        if(resultado.equals("VICTORIA")){
            System.out.println("Has ganado!\n");
            devolverJugador();
        } else if (resultado.equals("DERROTA")){
            System.out.println("Has perdido!\n");
            devolverJugador();
        }

    }

    private void devolverJugador() {
        System.out.println(getJugador().toString());
        System.out.println(getHistoricoResultados());
        for (int i = 0; i < getListaMatriz().size(); i++) {
            System.out.println(Arrays.deepToString(getListaMatriz().get(i)));
        }
        System.exit(0);
    }
}
