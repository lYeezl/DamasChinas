public class Negras extends Jugador {

    public Negras() {
        super("black");
    }

    public boolean avanzarIzq(int fila, char columna) {
        Ficha ficha = super.buscarFicha(fila, columna);

        int posFicha = fichas.indexOf(super.buscarFicha(fila, columna));

        int posColumna = new String(TableroControl.COLUMNAS).indexOf(columna);

        boolean exito = false;

        if (ficha != null) {

            if (posColumna >= 0 && fila < 7) {
                fichas.get(posFicha).colocar(fila + 1, TableroControl.COLUMNAS[posColumna + 1]);
                fichas.get(posFicha).mover(60, 60);
                exito = true;
            } else
                System.out.println("No es posible avanzar a la izquierda");
        } else
            System.out.println("No existe esa ficha");
        return exito;
    }

    public boolean avanzarDer(int fila, char columna) {
        Ficha ficha = super.buscarFicha(fila, columna);

        int posFicha = fichas.indexOf(ficha);

        int posColumna = new String(TableroControl.COLUMNAS).indexOf(columna);
        boolean exito = false;

        if (ficha != null) {

            if (posColumna < 7 && fila >= 0) {

                fichas.get(posFicha).colocar(fila + 1, TableroControl.COLUMNAS[posColumna - 1]);
                fichas.get(posFicha).mover(-60, 60);
                exito = true;
            } else
                System.out.println("No es posible avanzar a la derecha");
        } else
            System.out.println("No existe esa ficha");
        return exito;
    }
}
