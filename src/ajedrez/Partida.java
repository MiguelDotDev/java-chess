package ajedrez;

public class Partida {

    public static javax.swing.JButton CasillaJugada;
    public static Casilla casilla[][] = new Casilla[8][8];
    public static int CasillaJugadaX, CasillaJugadaY;
    public static Pieza piezaEnMovimiento;
    private static boolean EnJugada = false;
    private static boolean TurnoBlancas = true;

    // Inicio Declaracion De Jugadores ===========================
    public static Jugador JugadorW = new Jugador(true);
    public static Jugador JugadorB = new Jugador(false);
    // Fin Declaracion De Jugadores ==============================

    public static boolean isEnJugada() {
        return EnJugada;
    }

    public static void setEnJugada(boolean EnJugada) {
        Partida.EnJugada = EnJugada;
    }

    public static void crearTablero() {
        Tablero hud = new Tablero();
        hud.setVisible(true);

        // Inicializar cada posición del array casilla[][] con un objeto Casilla
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                casilla[i][j] = new Casilla();
            }
        }

        // Piezas Blancas
        Peon peonW0 = new Peon(0, 1, true);
        Peon peonW1 = new Peon(1, 1, true);
        Peon peonW2 = new Peon(2, 1, true);
        Peon peonW3 = new Peon(3, 1, true);
        Peon peonW4 = new Peon(4, 1, true);
        Peon peonW5 = new Peon(5, 1, true);
        Peon peonW6 = new Peon(6, 1, true);
        Peon peonW7 = new Peon(7, 1, true);
        Torre torreW1 = new Torre(0, 0, true);
        Torre torreW2 = new Torre(7, 0, true);
        Caballo caballoW1 = new Caballo(1, 0, true);
        Caballo caballoW2 = new Caballo(6, 0, true);
        Alfil alfilW1 = new Alfil(2, 0, true);
        Alfil alfilW2 = new Alfil(5, 0, true);
        Rey reyW1 = new Rey(4, 0, true, Tablero.jButton45);
        Reina reinaW1 = new Reina(3, 0, true);

        //Piezas Negras
        Peon peonB0 = new Peon(0, 6, false);
        Peon peonB1 = new Peon(1, 6, false);
        Peon peonB2 = new Peon(2, 6, false);
        Peon peonB3 = new Peon(3, 6, false);
        Peon peonB4 = new Peon(4, 6, false);
        Peon peonB5 = new Peon(5, 6, false);
        Peon peonB6 = new Peon(6, 6, false);
        Peon peonB7 = new Peon(7, 6, false);
        Torre torreB1 = new Torre(0, 7, false);
        Torre torreB2 = new Torre(7, 7, false);
        Caballo caballoB1 = new Caballo(1, 7, false);
        Caballo caballoB2 = new Caballo(6, 7, false);
        Alfil alfilB1 = new Alfil(2, 7, false);
        Alfil alfilB2 = new Alfil(5, 7, false);
        Rey reyB1 = new Rey(4, 7, false, Tablero.jButton5);
        Reina reinaB1 = new Reina(3, 7, false);

        Partida.JugadorB.setRey(reyB1);

        Partida.JugadorW.setRey(reyW1);

        JugadorW.setPieza(0, peonW0);
        JugadorW.setPieza(1, peonW1);
        JugadorW.setPieza(2, peonW2);
        JugadorW.setPieza(3, peonW3);
        JugadorW.setPieza(4, peonW4);
        JugadorW.setPieza(5, peonW5);
        JugadorW.setPieza(6, peonW6);
        JugadorW.setPieza(7, peonW7);
        JugadorW.setPieza(8, torreW1);
        JugadorW.setPieza(9, torreW2);
        JugadorW.setPieza(10, caballoW1);
        JugadorW.setPieza(11, caballoW2);
        JugadorW.setPieza(12, alfilW1);
        JugadorW.setPieza(13, alfilW2);
        JugadorW.setPieza(14, reinaW1);

        JugadorB.setPieza(0, peonB0);
        JugadorB.setPieza(1, peonB1);
        JugadorB.setPieza(2, peonB2);
        JugadorB.setPieza(3, peonB3);
        JugadorB.setPieza(4, peonB4);
        JugadorB.setPieza(5, peonB5);
        JugadorB.setPieza(6, peonB6);
        JugadorB.setPieza(7, peonB7);
        JugadorB.setPieza(8, torreB1);
        JugadorB.setPieza(9, torreB2);
        JugadorB.setPieza(10, caballoB1);
        JugadorB.setPieza(11, caballoB2);
        JugadorB.setPieza(12, alfilB1);
        JugadorB.setPieza(13, alfilB2);
        JugadorB.setPieza(14, reinaB1);

    }

    public static boolean isTurnoBlancas() {
        return TurnoBlancas;
    }

    public static void setTurnoBlancas(boolean TurnoBlancas) {
        Partida.TurnoBlancas = TurnoBlancas;
    }

    public static void main(String[] args) {
        crearTablero();
    }
}
