import java.util.ArrayList;

public class Jugador {
    protected String color;
    protected ArrayList<Ficha> fichas;

    public Jugador(String color) {
        this.color = color;
        fichas = new ArrayList(12);
    }

    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    public Ficha buscarFicha(int fila, char columna) {
        Ficha fichaBuscar = null;
        for (Ficha ficha : fichas) {
            if (ficha.getFila() == fila && ficha.getColumna() == columna) {
                fichaBuscar = ficha;
            }
        }
        return fichaBuscar;
    }

    public void borrarFicha(int fila, char columna) {
        for (Ficha ficha : fichas) {
            if (ficha.getFila() == fila && ficha.getColumna() == columna) {
                ficha.makeInvisible();
            }
        }
    }

    public int contarFichasRestantes() {
        int fichasVisibles = 0;
        for (Ficha ficha : fichas) {
            if (ficha.isVisible())
                fichasVisibles++;
        }
        return fichasVisibles;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
