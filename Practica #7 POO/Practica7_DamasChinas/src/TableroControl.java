public class TableroControl {

    private static Casilla[][] casillas;
    private Rojas rojas;
    private Negras negras;
    public static final char[] COLUMNAS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

    public TableroControl() {
        casillas = new Casilla[8][8];
        rojas = new Rojas();
        negras = new Negras();
    }

    public void iniciarFichas() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {

                if (casillas[i][j].getColor().equals("ch2")) {
                    Ficha ficha = new Ficha(casillas[i][j], "black", TableroView.CANVAS);
                    negras.agregarFicha(ficha);
                    casillas[i][j].ocupar("black");
                }
            }
        }

        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (casillas[i][j].getColor().equals("ch2")) {
                    Ficha ficha = new Ficha(casillas[i][j], "red", TableroView.CANVAS);
                    rojas.agregarFicha(ficha);
                    casillas[i][j].ocupar("red");
                }
            }
        }
    }

    public void crearTablero() {
        boolean b = false;

        String color;

        int posY = 160;
        for (int i = 0; i < 8; i++) {
            int posX = 160;
            for (int j = 0; j < 8; j++) {

                if (b) {
                    color = "ch2";
                } else {
                    color = "ch1";
                }
                b = !b;

                Casilla casilla = new Casilla(i, COLUMNAS[j], posX, posY, color, TableroView.CANVAS);

                casillas[i][j] = casilla;

                posX += 60;
            }

            b = !b;

            posY += 60;
        }
    }

    public boolean avanzarRojas(int filaOrigen, char columnaOrigen, int filaDestino, char columnaDestino) {
        boolean exito = false;

        int posColumnaOrigen = new String(TableroControl.COLUMNAS).indexOf(columnaOrigen);
        int posColumnaDestino = new String(TableroControl.COLUMNAS).indexOf(columnaDestino);

        if (!casillas[filaDestino][posColumnaDestino].estaOcupado()) {

            if (filaOrigen - 1 == filaDestino) {
                if (posColumnaOrigen - 1 == posColumnaDestino) {
                    if (rojas.avanzarIzq(filaOrigen, columnaOrigen))
                        exito = true;

                } else if (posColumnaOrigen + 1 == posColumnaDestino) {
                    if (rojas.avanzarDer(filaOrigen, columnaOrigen))
                        exito = true;
                } else {
                    System.out.println("No es posible avanzar a esa casilla.");
                }
            }

            else if (filaOrigen - 2 == filaDestino) {

                if (posColumnaOrigen - 2 == posColumnaDestino
                        &&
                        casillas[filaOrigen - 1][posColumnaOrigen - 1].estaOcupado()
                        &&
                        casillas[filaOrigen - 1][posColumnaOrigen - 1].getColorFicha().equals("black")) {

                    if (rojas.avanzarIzq(filaOrigen, columnaOrigen) &&
                            rojas.avanzarIzq(filaOrigen - 1, COLUMNAS[posColumnaOrigen - 1])) {

                        casillas[filaOrigen - 1][posColumnaOrigen - 1].desocupar();

                        negras.borrarFicha(filaOrigen - 1, COLUMNAS[posColumnaOrigen - 1]);

                        exito = true;
                    }

                } else if (posColumnaOrigen + 2 == posColumnaDestino
                        &&
                        casillas[filaOrigen - 1][posColumnaOrigen + 1].estaOcupado()
                        &&
                        casillas[filaOrigen - 1][posColumnaOrigen + 1].getColorFicha().equals("black")) {

                    if (rojas.avanzarDer(filaOrigen, columnaOrigen) &&
                            rojas.avanzarDer(filaOrigen - 1, COLUMNAS[posColumnaOrigen + 1])) {

                        casillas[filaOrigen - 1][posColumnaOrigen + 1].desocupar();

                        negras.borrarFicha(filaOrigen - 1, COLUMNAS[posColumnaOrigen + 1]);

                        exito = true;
                    }
                } else {
                    System.out.println("No puedes comer por alguno de los siguientes motivos:\n"
                            + "No se encuentra ninguna ficha en esa casilla\n"
                            + "o La ficha que intentas comer es tuya.");
                }
            }
        } else {

            System.out.println("LA CASILLA SE ENCUENTRA OCUPADA");
        }

        if (exito) {

            casillas[filaOrigen][posColumnaOrigen].desocupar();

            casillas[filaDestino][posColumnaDestino].ocupar("red");
        }

        return exito;
    }

    public boolean avanzarNegras(int filaOrigen, char columnaOrigen, int filaDestino, char columnaDestino) {
        boolean exito = false;

        int posColumnaOrigen = new String(TableroControl.COLUMNAS).indexOf(columnaOrigen);

        int posColumnaDestino = new String(TableroControl.COLUMNAS).indexOf(columnaDestino);

        if (!casillas[filaDestino][posColumnaDestino].estaOcupado()) {

            if (filaOrigen + 1 == filaDestino) {

                if (posColumnaOrigen + 1 == posColumnaDestino) {

                    if (negras.avanzarIzq(filaOrigen, columnaOrigen))

                        exito = true;

                } else if (posColumnaOrigen - 1 == posColumnaDestino) {

                    if (negras.avanzarDer(filaOrigen, columnaOrigen))

                        exito = true;
                } else {

                    System.out.println("No es posible avanzar a esa casilla.");
                }
            }

            else if (filaOrigen + 2 == filaDestino) {

                if (posColumnaOrigen + 2 == posColumnaDestino
                        &&
                        casillas[filaOrigen + 1][posColumnaOrigen + 1].estaOcupado()
                        &&
                        casillas[filaOrigen + 1][posColumnaOrigen + 1].getColorFicha().equals("red")) {

                    if (negras.avanzarIzq(filaOrigen, columnaOrigen) &&
                            negras.avanzarIzq(filaOrigen + 1, COLUMNAS[posColumnaOrigen + 1])) {

                        casillas[filaOrigen + 1][posColumnaOrigen + 1].desocupar();

                        rojas.borrarFicha(filaOrigen + 1, COLUMNAS[posColumnaOrigen + 1]);

                        exito = true;
                    }

                } else if (posColumnaOrigen - 2 == posColumnaDestino
                        &&

                        casillas[filaOrigen + 1][posColumnaOrigen - 1].estaOcupado()
                        &&
                        casillas[filaOrigen + 1][posColumnaOrigen - 1].getColorFicha().equals("red")) {

                    if (negras.avanzarDer(filaOrigen, columnaOrigen) &&
                            negras.avanzarDer(filaOrigen + 1, COLUMNAS[posColumnaOrigen - 1])) {

                        casillas[filaOrigen + 1][posColumnaOrigen - 1].desocupar();

                        rojas.borrarFicha(filaOrigen + 1, COLUMNAS[posColumnaOrigen - 1]);

                        exito = true;
                    }

                } else {
                    System.out.println("No puedes comer por alguno de los siguientes motivos:\n"
                            + "No se encuentra ninguna ficha en esa casilla\n"
                            + "o La ficha que intentas comer es tuya.");
                }
            }
        } else {

            System.out.println("LA CASILLA SE ENCUENTRA OCUPADA");
        }

        if (exito) {
            casillas[filaOrigen][posColumnaOrigen].desocupar();
            casillas[filaDestino][posColumnaDestino].ocupar("black");
        }
        return exito;
    }

    public void ocuparCasilla(int fila, char columna, String colorFicha) {
        casillas[fila][columna].ocupar(colorFicha);
    }

    public void desocuparCasilla(int fila, char columna) {
        casillas[fila][columna].desocupar();
    }

    public static Casilla[][] getCasillas() {
        return casillas;
    }

    public static void setCasillas(Casilla[][] casillas) {
        TableroControl.casillas = casillas;
    }

    public Rojas getRojas() {
        return rojas;
    }

    public void setRojas(Rojas rojas) {
        this.rojas = rojas;
    }

    public Negras getNegras() {
        return negras;
    }

    public void setNegras(Negras negras) {
        this.negras = negras;
    }
}
