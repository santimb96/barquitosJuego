package barquitos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaTablero {
    public void lecturaTablero(String numero, String letra) {
        var juego = new Juego();
        String alfabeto = "abcdefghij";
        ArrayList<String[]> lista = juego.getListaMatriz();


        int indiceLetra = alfabeto.indexOf(letra);
        int numFila = Integer.parseInt(numero);
        int lineas = 0;
        int columnas = 0;

        String matriz[][] = new String[100][100];

        File archivo = new File("e:\\projects\\src\\java\\barquitosJuego\\src\\mapas\\mapa0.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {
                lista.add(lectura.split(","));
                lineas++;
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        juego.setMatriz(matriz);
        juego.resultadoJugada(numFila, indiceLetra, lineas, columnas, letra);
    }
}
