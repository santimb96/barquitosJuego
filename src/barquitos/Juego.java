package barquitos;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Juego {

    private String[][] matriz = new String[100][100];
    private static ArrayList<String[]> listaMatriz = new ArrayList<>();
    private static ArrayList<String> opcionesSeleccionadas = new ArrayList<>();
    private static Jugador jugador;

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
                    } else {
                        System.out.println("Agua!\n");
                        getJugador().setIntentos(getJugador().getIntentos() - 1);
                        getOpcionesSeleccionadas().add(numFila+letra);
                    }
                }
            }
        }

        if(getJugador().getPuntuacion()==15){
            devolverJugador("VICTORIA");
        }
        if(getJugador().getIntentos()==0){
            devolverJugador("DERROTA");
        }
    }

    public void devolverJugador(String resultado){
        var jugador = new Jugador();
        if(resultado.equals("VICTORIA")){
            System.out.println("Has ganado!\n");
            System.out.println(getJugador().toString());
            System.exit(0);
        } else if (resultado.equals("DERROTA")){
            System.out.println("Has perdido!\n");
            System.out.println(getJugador().toString());
            System.exit(0);
        }

    }
}
