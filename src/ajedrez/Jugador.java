package ajedrez;
public class Jugador {
    
    private boolean blancas;
    private boolean enJaque = false;
    private Pieza rey;
    private Pieza piezas[] = new Pieza[15];
    
    public Jugador(boolean Blancas){
        this.blancas = Blancas;
    }

    public boolean isEnJaque() {
        return enJaque;
    }

    public void setEnJaque(boolean enJaque) {
        this.enJaque = enJaque;
    }

    public boolean isBlancas() {
        return blancas;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public Pieza getRey() {
        return this.rey;
    }

    public void setRey(Pieza rey) {
        this.rey = rey;
    }

    public Pieza getPieza(int index) {
        return piezas[index];
    }

    public void setPieza(int index, Pieza pieza) {
        this.piezas[index] = pieza;
    }
    
    
}
