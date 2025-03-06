package ajedrez;

import javax.swing.ImageIcon;

public class Torre extends Pieza {

    public Torre(int x, int y, boolean Blancas) {
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas) {
            this.rutaImagen = "/IMG/Piezas/Blancas/torre.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/torre.png";
        }
        this.piezaIco = new ImageIcon(getClass().getResource(this.rutaImagen));
    }

    @Override
    public boolean movimiento(int xDestino, int yDestino) {
        int DistanciaH = this.CoordenadaX - xDestino;
        int DistanciaV = this.CoordenadaY - yDestino;

        int Xrelativo = 0;
        int Yrelativo = 0;
        int Distancia = 0;
        int NewX = this.CoordenadaX, NewY = this.CoordenadaY;
        boolean Moverse = true;

        if (DistanciaH != 0 && DistanciaV == 0 || DistanciaV != 0 && DistanciaH == 0) {
            if (DistanciaH < 0) {
                Xrelativo = 1;
                Distancia = Math.abs(DistanciaH);
            } else if (DistanciaH > 0) {
                Xrelativo = -1;
                Distancia = Math.abs(DistanciaH);
            } else if (DistanciaV < 0) {
                Yrelativo = 1;
                Distancia = Math.abs(DistanciaV);
            } else if (DistanciaV > 0) {
                Yrelativo = -1;
                Distancia = Math.abs(DistanciaV);
            }

            for (int casillaCount = 0; casillaCount < Math.abs(Distancia); casillaCount++) {
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
        // Verifica si la torre y el objetivo están en la misma fila o columna
        if (this.CoordenadaX == objetivo.CoordenadaX || this.CoordenadaY == objetivo.CoordenadaY) {
            // Itera a lo largo de la fila o columna en la que se encuentra la torre
            if (this.CoordenadaX == objetivo.CoordenadaX) { // Si están en la misma columna
                int minY = Math.min(this.CoordenadaY, objetivo.CoordenadaY);
                int maxY = Math.max(this.CoordenadaY, objetivo.CoordenadaY);
                // Verifica si hay alguna pieza entre la torre y el objetivo
                for (int y = minY + 1; y < maxY; y++) {
                    if (Partida.casilla[this.CoordenadaX][y].PiezaActual != null) {
                        return false; // Hay una pieza bloqueando el ataque
                    }
                }
                return true; // No hay piezas bloqueando el ataque
            } else { // Si están en la misma fila
                int minX = Math.min(this.CoordenadaX, objetivo.CoordenadaX);
                int maxX = Math.max(this.CoordenadaX, objetivo.CoordenadaX);
                // Verifica si hay alguna pieza entre la torre y el objetivo
                for (int x = minX + 1; x < maxX; x++) {
                    if (Partida.casilla[x][this.CoordenadaY].PiezaActual != null) {
                        return false; // Hay una pieza bloqueando el ataque
                    }
                }
                return true; // No hay piezas bloqueando el ataque
            }
        }
        return false; // La torre y el objetivo no están en la misma fila o columna
    }

}
