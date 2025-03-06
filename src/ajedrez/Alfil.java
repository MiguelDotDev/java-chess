package ajedrez;

import javax.swing.ImageIcon;

public class Alfil extends Pieza {

    public Alfil(int x, int y, boolean Blancas) {
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas) {
            this.rutaImagen = "/IMG/Piezas/Blancas/alfil.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/alfil.png";
        }
        this.piezaIco = new ImageIcon(getClass().getResource(this.rutaImagen));
    }

    @Override
    public boolean movimiento(int xDestino, int yDestino) {
        int DistanciaH = this.CoordenadaX - xDestino;
        int DistanciaV = this.CoordenadaY - yDestino;

        int Xrelativo;
        int Yrelativo;
        int NewX = this.CoordenadaX, NewY = this.CoordenadaY;
        boolean Moverse = true;

        if (Math.abs(DistanciaH) == Math.abs(DistanciaV)) {
            if (DistanciaH < 0) {
                if (DistanciaV < 0) {
                    Xrelativo = 1;
                    Yrelativo = 1;
                } else {
                    Xrelativo = 1;
                    Yrelativo = -1;
                }
            } else {
                if (DistanciaV < 0) {
                    Xrelativo = -1;
                    Yrelativo = 1;
                } else {
                    Xrelativo = -1;
                    Yrelativo = -1;
                }
            }
            for (int casillaCount = 0; casillaCount < Math.abs(DistanciaH); casillaCount++) {
                System.out.println(NewX);
                System.out.println(NewY);
                NewX = NewX + Xrelativo;
                NewY = NewY + Yrelativo;
                if (Partida.casilla[NewX][NewY].PiezaActual != this) {
                    if (Partida.casilla[NewX][NewY].PiezaActual != null) {
                        if (Partida.casilla[NewX][NewY].PiezaActual != Partida.casilla[xDestino][yDestino].PiezaActual) {
                            Moverse = false;
                        }
                    }
                }
            }
            if (Moverse) {
                return comerPiezas(isBlanca(), xDestino, yDestino, true);
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean piezaEnTrayectoria(Pieza objetivo) {
        // Verifica si el alfil y el objetivo están en la misma diagonal
        if (Math.abs(this.CoordenadaX - objetivo.CoordenadaX) == Math.abs(this.CoordenadaY - objetivo.CoordenadaY)) {
            int deltaX = Integer.signum(objetivo.CoordenadaX - this.CoordenadaX);
            int deltaY = Integer.signum(objetivo.CoordenadaY - this.CoordenadaY);
            int x = this.CoordenadaX + deltaX;
            int y = this.CoordenadaY + deltaY;
            // Itera a lo largo de la diagonal en la que se encuentra el alfil
            while (x != objetivo.CoordenadaX && y != objetivo.CoordenadaY) {
                // Verifica si hay alguna pieza entre el alfil y el objetivo
                if (Partida.casilla[x][y].PiezaActual != null) {
                    return false; // Hay una pieza bloqueando el ataque
                }
                x += deltaX;
                y += deltaY;
            }
            return true; // No hay piezas bloqueando el ataque
        }
        return false; // El alfil y el objetivo no están en la misma diagonal
    }

}
