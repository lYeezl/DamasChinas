public class Ficha extends Circle {
    private int fila;
    private char columna;

    public Ficha(Casilla casilla, String color, Canvas canvas) {
        super(60, casilla.getxPosition(), casilla.getyPosition(), color, canvas);
        this.fila = casilla.getFila();
        this.columna = casilla.getColumna();
    }

    public void colocar(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void mover(int x, int y) {
        int movX, movY;
        if (x > 0)
            movX = 1;
        else
            movX = -1;
        if (y > 0)
            movY = 1;
        else
            movY = -1;

        for (int i = 0; i < diameter; i++) {
            moveHorizontal(movX);
            moveVertical(movY);
        }
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

}
