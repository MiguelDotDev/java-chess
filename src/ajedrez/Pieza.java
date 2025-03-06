package ajedrez;

import javax.swing.ImageIcon;

public abstract class Pieza {

    private boolean blanca;
    private boolean viva = true;
    public javax.swing.JButton casillaFisica;
    private int valor;
    int CoordenadaX;
    int CoordenadaY;
    public ImageIcon piezaIco;
    String rutaImagen;

    public boolean comerPiezas(boolean Blancas, int xDestino, int yDestino, boolean AvanzarSiNoCome) {

        Casilla casillaDestino = Partida.casilla[xDestino][yDestino];
        if (casillaDestino.isOcupada()) {
            if (casillaDestino.PiezaActual.blanca == this.blanca){
                Partida.setEnJugada(false);
                if (Partida.CasillaJugada.getBackground() == Tablero.casillaBlancaMoving) {
                    Partida.CasillaJugada.setBackground(Tablero.casillaBlanca);
                } else {
                    Partida.CasillaJugada.setBackground(Tablero.casillaNegra);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return AvanzarSiNoCome;
        }
    }

    public boolean isBlanca() {
        return blanca;
    }

    public void setBlanca(boolean blanca) {
        this.blanca = blanca;
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCoordenadaX() {
        return CoordenadaX;
    }

    public void setCoordenadaX(int CoordenadaX) {
        this.CoordenadaX = CoordenadaX;
    }

    public int getCoordenadaY() {
        return CoordenadaY;
    }

    public void setCoordenadaY(int CoordenadaY) {
        this.CoordenadaY = CoordenadaY;
    }

    public abstract boolean movimiento(int xDestino, int yDestino);
    public abstract boolean piezaEnTrayectoria(Pieza pieza);
}
