package ajedrez;

import javax.swing.ImageIcon;

public class Reina extends Pieza {

    public Reina(int x, int y, boolean Blancas) {
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas) {
            this.rutaImagen = "/IMG/Piezas/Blancas/reina.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/reina.png";
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
        boolean Moverse = true, MovimientoValido = false;

        if ((DistanciaH != 0 && DistanciaV == 0) || (DistanciaV != 0 && DistanciaH == 0)) {
            MovimientoValido = true;
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
        } else if (Math.abs(DistanciaH) == Math.abs(DistanciaV)) {
            MovimientoValido = true;
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
            Distancia = Math.abs(DistanciaH);
        }

        if (MovimientoValido) {
            for (int casillaCount = 0; casillaCount < Distancia; casillaCount++) {
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
        } else {
            return false;
        }
    }

    @Override
    public boolean piezaEnTrayectoria(Pieza objetivo) {
        // Verifica si la reina y el objetivo están en la misma fila, columna o diagonal
        if (this.CoordenadaX == objetivo.CoordenadaX || this.CoordenadaY == objetivo.CoordenadaY
                || Math.abs(this.CoordenadaX - objetivo.CoordenadaX) == Math.abs(this.CoordenadaY - objetivo.CoordenadaY)) {
            // Si están en la misma fila o columna, realiza la misma verificación que la torre
            if (this.CoordenadaX == objetivo.CoordenadaX || this.CoordenadaY == objetivo.CoordenadaY) {
                // Verifica si hay alguna pieza entre la reina y el objetivo en la misma fila o columna
                if (this.CoordenadaX == objetivo.CoordenadaX) { // Si están en la misma columna
                    int minY = Math.min(this.CoordenadaY, objetivo.CoordenadaY);
                    int maxY = Math.max(this.CoordenadaY, objetivo.CoordenadaY);
                    // Verifica si hay alguna pieza entre la reina y el objetivo en la misma columna
                    for (int y = minY + 1; y < maxY; y++) {
                        if (Partida.casilla[this.CoordenadaX][y].PiezaActual != null) {
                            return false; // Hay una pieza bloqueando el ataque
                        }
                    }
                } else { // Si están en la misma fila
                    int minX = Math.min(this.CoordenadaX, objetivo.CoordenadaX);
                    int maxX = Math.max(this.CoordenadaX, objetivo.CoordenadaX);
                    // Verifica si hay alguna pieza entre la reina y el objetivo en la misma fila
                    for (int x = minX + 1; x < maxX; x++) {
                        if (Partida.casilla[x][this.CoordenadaY].PiezaActual != null) {
                            return false; // Hay una pieza bloqueando el ataque
                        }
                    }
                }
                return true; // No hay piezas bloqueando el ataque
            } else { // Si están en la misma diagonal, realiza la misma verificación que el alfil
                int deltaX = Integer.signum(objetivo.CoordenadaX - this.CoordenadaX);
                int deltaY = Integer.signum(objetivo.CoordenadaY - this.CoordenadaY);
                int x = this.CoordenadaX + deltaX;
                int y = this.CoordenadaY + deltaY;
                // Itera a lo largo de la diagonal en la que se encuentra la reina
                while (x != objetivo.CoordenadaX && y != objetivo.CoordenadaY) {
                    // Verifica si hay alguna pieza entre la reina y el objetivo en la misma diagonal
                    if (Partida.casilla[x][y].PiezaActual != null) {
                        return false; // Hay una pieza bloqueando el ataque
                    }
                    x += deltaX;
                    y += deltaY;
                }
                return true; // No hay piezas bloqueando el ataque
            }
        }
        return false; // La reina y el objetivo no están en la misma fila, columna o diagonal
    }

}
