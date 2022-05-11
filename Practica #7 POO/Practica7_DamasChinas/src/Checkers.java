import java.util.Scanner;

public class Checkers {

    public static void main(String[] args) {

        TableroView tg = new TableroView();
        TableroControl tc = new TableroControl();

        tc.crearTablero();
        tc.iniciarFichas();
        tg.dibujarTablero();
        tg.dibujarFichas(tc.getRojas());
        tg.dibujarFichas(tc.getNegras());

        Scanner scan = new Scanner(System.in);

        boolean turno = true;

        for (int i = 0; i < 10; i++) {
            if (turno)
                System.out.println("\n\f\tEs el turno de las ROJAS.");
            else
                System.out.println("\n\f\tEs el turno de las NEGRAS.");
            System.out.println("Ingrese fila de ficha a mover(1-8): ");
            int filaOrigen = scan.nextInt() - 1;
            scan.nextLine();

            System.out.println("Ingrese columna de ficha a mover(a-h): ");
            String col = scan.nextLine().toLowerCase();
            char columnaOrigen = col.toCharArray()[0];

            System.out.println("Ingrese la fila destino(1-8): ");
            int filaDestino = scan.nextInt() - 1;
            scan.nextLine();

            System.out.println("Ingrese columna de ficha a mover(a-h): ");
            col = scan.nextLine().toLowerCase();
            char columnaDestino = col.toCharArray()[0];

            if (turno) {
                if (tc.avanzarRojas(filaOrigen, columnaOrigen, filaDestino, columnaDestino))
                    turno = !turno;
                else {
                    System.out.println("Movimiento ilegal. Intente de nuevo.");
                    i--;
                }
            } else {
                if (tc.avanzarNegras(filaOrigen, columnaOrigen, filaDestino, columnaDestino))
                    turno = !turno;
                else {
                    System.out.println("Movimiento ilegal. Intente de nuevo.");
                    i--;
                }
            }
        }

        int fichasRojas = tc.getRojas().contarFichasRestantes();
        int fichasNegras = tc.getNegras().contarFichasRestantes();

        if (fichasRojas > fichasNegras)
            System.out.println("\n\nEl jugador con fichas ROJAS es el GANADOR!");
        else if (fichasNegras > fichasRojas)
            System.out.println("\n\nEl jugador con fichas NEGRAS es el GANADOR!");
        else
            System.out.println("\n\nHAN EMPATADO!");
    }
}
