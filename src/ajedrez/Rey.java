package ajedrez;
import javax.swing.ImageIcon;
public class Rey extends Pieza {

    public Rey(int x, int y, boolean Blancas, javax.swing.JButton CasillaFisica){
        this.CoordenadaX = x;
        this.CoordenadaY = y;
        this.casillaFisica = CasillaFisica;
        setBlanca(Blancas);
        Partida.casilla[x][y].PiezaActual = this;
        Partida.casilla[x][y].setOcupada(true);
        if (Blancas){
            this.rutaImagen = "/IMG/Piezas/Blancas/rey.png";
        } else {
            this.rutaImagen = "/IMG/Piezas/Negras/rey.png";
        }
        this.piezaIco = new ImageIcon(getClass().getResource(this.rutaImagen));
    }

    @Override
    public boolean movimiento(int xDestino, int yDestino) {
        int DistanciaH = this.CoordenadaX - xDestino;
        int DistanciaV = this.CoordenadaY - yDestino;
        
        if (Math.abs(DistanciaH) <= 1 && Math.abs(DistanciaV) <= 1){
            return comerPiezas(isBlanca(), xDestino, yDestino, true);
        }
        return false;
    }

    @Override
    public boolean piezaEnTrayectoria(Pieza pieza) {
        return false;
    }
    
}
