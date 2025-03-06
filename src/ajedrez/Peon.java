package ajedrez;

import javax.swing.ImageIcon;

public class Peon extends Pieza {

    private boolean movidoDesdeInicio = false;
    private int DistLimit = 2;

    public Peon(int x, int y, boolean Blancas) {
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas) {
            this.rutaImagen = "/IMG/Piezas/Blancas/peon.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/peon.png";
        }
        this.piezaIco = new ImageIcon(getClass().getResource(this.rutaImagen));
    }

    @Override
    public boolean movimiento(int xDestino, int yDestino) {
        int DistanciaH = Math.abs(this.CoordenadaX - xDestino);
        int DistanciaV = Math.abs(this.CoordenadaY - yDestino);

        if (DistanciaV <= DistLimit) {
            if ((yDestino > this.CoordenadaY) && this.isBlanca() && DistanciaH == 0 && (Partida.casilla[xDestino][yDestino].PiezaActual == null)) {
                this.DistLimit = 1;
                return true;
            } else if ((yDestino < this.CoordenadaY) && !this.isBlanca() && DistanciaH == 0 && (Partida.casilla[xDestino][yDestino].PiezaActual == null)) {
                this.DistLimit = 1;
                return true;
            } else if (DistanciaH == 1 && DistanciaV == 1 && this.isBlanca() && (this.CoordenadaY < yDestino)) {
                if (comerPiezas(isBlanca(), xDestino, yDestino, false)) {
                    this.DistLimit = 1;
                    return true;
                } else {
                    return false;
                }
            } else if (DistanciaH == 1 && DistanciaV == 1 && !this.isBlanca() && (this.CoordenadaY > yDestino)) {
                if (comerPiezas(isBlanca(), xDestino, yDestino, false)) {
                    this.DistLimit = 1;
                    return true;
                } else {
                    return false;
                }
            }
        }
        System.out.println(DistLimit);

        return false;
    }

    @Override
    public boolean piezaEnTrayectoria(Pieza pieza) {
        if (this.isBlanca()) {
            if (this.CoordenadaY + 1 <= 7 && this.CoordenadaY + 1 >= 0) {
                if (this.CoordenadaX + 1 <= 7 && this.CoordenadaX + 1 >= 0) {
                    Pieza piezaActual = Partida.casilla[this.CoordenadaX + 1][this.CoordenadaY + 1].PiezaActual;
                    if (piezaActual != null && piezaActual.equals(pieza)) {
                        return true;
                    }
                }
                if (this.CoordenadaX - 1 <= 7 && this.CoordenadaX - 1 >= 0) {
                    Pieza piezaActual = Partida.casilla[this.CoordenadaX - 1][this.CoordenadaY + 1].PiezaActual;
                    if (piezaActual != null && piezaActual.equals(pieza)) {
                        return true;
                    }
                }
            }
        } else {
            if (this.CoordenadaY - 1 <= 7 && this.CoordenadaY - 1 >= 0) {
                if (this.CoordenadaX + 1 <= 7 && this.CoordenadaX + 1 >= 0) {
                    Pieza piezaActual = Partida.casilla[this.CoordenadaX + 1][this.CoordenadaY - 1].PiezaActual;
                    if (piezaActual != null && piezaActual.equals(pieza)) {
                        return true;
                    }
                }
                if (this.CoordenadaX - 1 <= 7 && this.CoordenadaX - 1 >= 0) {
                    Pieza piezaActual = Partida.casilla[this.CoordenadaX - 1][this.CoordenadaY - 1].PiezaActual;
                    if (piezaActual != null && piezaActual.equals(pieza)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
