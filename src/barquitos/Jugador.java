package barquitos;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private int intentos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public Jugador(){}

    public Jugador(String nombre, int puntuacion, int intentos) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.intentos = intentos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", intentos=" + intentos +
                '}';
    }
}
