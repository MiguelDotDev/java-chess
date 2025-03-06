package ajedrez;

import javax.swing.ImageIcon;

public class Caballo extends Pieza {

    public Caballo(int x, int y, boolean Blancas) {
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas) {
            this.rutaImagen = "/IMG/Piezas/Blancas/caballo.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/caballo.png";
        }
        this.piezaIco = new ImageIcon(getClass().getResource(this.rutaImagen));
    }

    @Override
    public boolean movimiento(int xDestino, int yDestino) {
        int DistanciaH = this.CoordenadaX - xDestino;
        int DistanciaV = this.CoordenadaY - yDestino;

        if ((Math.abs(DistanciaH) == 2 && Math.abs(DistanciaV) == 1)) {
            return comerPiezas(isBlanca(), xDestino, yDestino, true);
        } else if ((Math.abs(DistanciaH) == 1 && Math.abs(DistanciaV) == 2)) {
            return comerPiezas(isBlanca(), xDestino, yDestino, true);
        }
        return false;
    }

    boolean limite(int Xd, int Yd) {
        return (this.CoordenadaX + Xd <= 7 && this.CoordenadaX + Xd >= 0 && this.CoordenadaY + Yd <= 7 && this.CoordenadaY + Yd >= 0);
    }

    private boolean isPiezaActualEqual(Pieza pieza, int x, int y) {
        Casilla casilla = Partida.casilla[x][y];
        return casilla != null && casilla.PiezaActual != null && casilla.PiezaActual.equals(pieza);
    }

    @Override
    public boolean piezaEnTrayectoria(Pieza pieza) {
        return (limite(1, 2) && isPiezaActualEqual(pieza, this.CoordenadaX + 1, this.CoordenadaY + 2))
                || (limite(2, 1) && isPiezaActualEqual(pieza, this.CoordenadaX + 2, this.CoordenadaY + 1))
                || (limite(2, -1) && isPiezaActualEqual(pieza, this.CoordenadaX + 2, this.CoordenadaY - 1))
                || (limite(1, -2) && isPiezaActualEqual(pieza, this.CoordenadaX + 1, this.CoordenadaY - 2))
                || (limite(-1, -2) && isPiezaActualEqual(pieza, this.CoordenadaX - 1, this.CoordenadaY - 2))
                || (limite(-2, -1) && isPiezaActualEqual(pieza, this.CoordenadaX - 2, this.CoordenadaY - 1))
                || (limite(-2, 1) && isPiezaActualEqual(pieza, this.CoordenadaX - 2, this.CoordenadaY + 1))
                || (limite(-1, 2) && isPiezaActualEqual(pieza, this.CoordenadaX - 1, this.CoordenadaY + 2));
    }
}
