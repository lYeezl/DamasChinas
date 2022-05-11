public class Casilla extends Square {
    private boolean ocupado;
    private String colorFicha;
    private int fila;
    private char columna;

    public Casilla(int fila, char columna, int xPosition, int yPosition, String color, Canvas canvas) {
        super(60, xPosition, yPosition, color, canvas);
        ocupado = false;
        this.fila = fila;
        this.columna = columna;
        this.colorFicha = "na";
    }

    public void ocupar(String colorFicha) {
        ocupado = true;
        this.colorFicha = colorFicha;
    }

    public void desocupar() {
        ocupado = false;
        colorFicha = "na";
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getColorFicha() {
        return colorFicha;
    }

    public void setColorFicha(String colorFicha) {
        this.colorFicha = colorFicha;
    }

}
