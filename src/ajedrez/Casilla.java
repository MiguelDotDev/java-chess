package ajedrez;
public class Casilla {
    private boolean Ocupada;
    public Pieza PiezaActual;
    public javax.swing.JButton CasillaFisica;
    
    public boolean isOcupada() {
        return Ocupada;
    }

    public void setOcupada(boolean Ocupada) {
        this.Ocupada = Ocupada;
    }
}
