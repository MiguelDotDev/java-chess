package ajedrez;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {

    public Tablero() {
        initComponents();
    }

    public static Color casillaBlanca = new Color(130, 130, 130);
    public static Color casillaNegra = new Color(249, 239, 210);
    public static Color casillaBlancaMoving = new Color(142, 89, 34);
    public static Color casillaNegraMoving = new Color(127, 118, 109);
    public static Color jaqueColor = new Color(255, 100, 100);

    /*  METODO AL PRESIONAR UNA CASILLA
            Se manda a llamar cada que una casilla (JButton) es presionada, los argumentos son
            las coordenadas de la casilla presionada y el objeto boton que es la casilla.*/
    public void PresionarCasilla(int X, int Y, javax.swing.JButton casilla) {
        // Se inicializa CasillaJugada la primera vez que se ejecuta la partida.

        if (Partida.CasillaJugada == null) {
            Partida.CasillaJugada = casilla;
        }

        /*      Se ejecuta cuando una casilla es presionada mientras SI se esta
                en MODO JUGADA y la casilla presionada NO es la misma que la
                que esta la pieza a mover.
         */
        if (Partida.isEnJugada() && !Partida.CasillaJugada.equals(casilla)) {

            /*  Se intenta hacer el movimiento de la pieza a las coordenadas
                de la casilla presionada
             */
            if (Partida.piezaEnMovimiento.movimiento(X, Y) /*ESTE ES EL METODO "movimiento" DE LA PIEZA EN MOVIMIENTO*/) {
                // Se ejecuta cuando un MOVIMIENTO si es VALIDO
                Partida.casilla[X][Y].PiezaActual = Partida.piezaEnMovimiento;
                Partida.piezaEnMovimiento.CoordenadaX = X;
                Partida.piezaEnMovimiento.CoordenadaY = Y;
                casilla.setIcon(Partida.piezaEnMovimiento.piezaIco);
                Partida.CasillaJugada.setIcon(null);
                Partida.setEnJugada(false);
                Partida.casilla[Partida.CasillaJugadaX][Partida.CasillaJugadaY].PiezaActual = null;
                Partida.casilla[Partida.CasillaJugadaX][Partida.CasillaJugadaY].setOcupada(false);
                Partida.casilla[X][Y].setOcupada(true);

                Partida.piezaEnMovimiento.casillaFisica = casilla;
                Partida.piezaEnMovimiento = null;

                if (Partida.CasillaJugada.getBackground() == casillaBlancaMoving) {
                    Partida.CasillaJugada.setBackground(casillaBlanca);
                } else if (Partida.CasillaJugada.getBackground() == casillaNegraMoving) {
                    Partida.CasillaJugada.setBackground(casillaNegra);
                }

                Partida.JugadorB.setEnJaque(Jaque(Partida.JugadorB.getRey()));
                Partida.JugadorW.setEnJaque(Jaque(Partida.JugadorW.getRey()));
                
                Partida.setTurnoBlancas(!Partida.isTurnoBlancas());

                if (Partida.JugadorB.isEnJaque()) {
                    JOptionPane.showMessageDialog(null, "Estás en jaque", "Jaque", JOptionPane.INFORMATION_MESSAGE);
                    Partida.JugadorB.getRey().casillaFisica.setBackground(jaqueColor);
                    Pieza Rey = Partida.JugadorB.getRey();

                } else if (Partida.JugadorW.isEnJaque()) {
                    JOptionPane.showMessageDialog(null, "Estás en jaque", "Jaque", JOptionPane.INFORMATION_MESSAGE);
                    Partida.JugadorW.getRey().casillaFisica.setBackground(jaqueColor);
                }
                
                

            } else {
                // Se ejecuta cuando un MOVIMIENTO es INVALIDO
                if (Partida.CasillaJugada.getBackground() == casillaBlancaMoving) {
                    Partida.CasillaJugada.setBackground(casillaBlanca);
                } else if (Partida.CasillaJugada.getBackground() == casillaNegraMoving) {
                    Partida.CasillaJugada.setBackground(casillaNegra);
                }
                Partida.setEnJugada(false);
            }
        } else if (Partida.casilla[X][Y].PiezaActual != null) {
            // SE ACTIVA EL MODO JUGADA
            if (Partida.casilla[X][Y].PiezaActual.isBlanca() == Partida.isTurnoBlancas()) {
                Partida.setEnJugada(true);
                Partida.CasillaJugada = casilla;
                Partida.CasillaJugadaX = X;
                Partida.CasillaJugadaY = Y;
                Partida.piezaEnMovimiento = Partida.casilla[X][Y].PiezaActual;

                if (casilla.getBackground() == casillaBlanca) {
                    casilla.setBackground(casillaBlancaMoving);
                } else if (Partida.CasillaJugada.getBackground() == casillaNegra) {
                    casilla.setBackground(casillaNegraMoving);
                }
            }
        } else {
            // SE PRESIONA UNA CASILLA DONDE NO HAY PIEZA Y NO SE ESTA EN MODO JUGADA
            Partida.setEnJugada(false);
        }
    }

    //FUNCION DE JAQUE INCOMPLETA
    public boolean Jaque(Pieza rey) {
        /*Jugador a;
        boolean siHayJaque = false;

        if (rey.isBlanca()) {
            a = Partida.JugadorB;
        } else {
            a = Partida.JugadorW;
        }

        for (int i = 0; i <= 14; i++) {
            siHayJaque = siHayJaque || a.getPieza(i).piezaEnTrayectoria(rey);
        }
        System.out.println(rey.isBlanca()?"Blancas":"Negras"+" en Jaque");
        System.out.println("JAQUE " + siHayJaque);
        return siHayJaque;*/
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        a = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(casillaNegra);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/alfil.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 100, 100));

        jButton2.setBackground(casillaNegra);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/torre.png"))); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        jButton3.setBackground(casillaBlanca);
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/caballo.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 100));

        jButton4.setBackground(casillaBlanca);
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/alfil.png"))); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 100, 100));

        jButton5.setBackground(casillaNegra);
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/rey.png"))); // NOI18N
        jButton5.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 100, 100));

        jButton6.setBackground(casillaBlanca);
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/reina.png"))); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 100, 100));

        jButton13.setBackground(casillaBlanca);
        jButton13.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton13.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton13.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 100, 100));

        jButton14.setBackground(casillaNegra);
        jButton14.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton14.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton14.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 100, 100));

        jButton15.setBackground(casillaNegra);
        jButton15.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton15.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton15.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 100, 100));

        jButton16.setBackground(casillaBlanca);
        jButton16.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton16.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton16.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 100, 100));

        jButton17.setBackground(casillaNegra);
        jButton17.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton17.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton17.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 100, 100));

        jButton18.setBackground(casillaBlanca);
        jButton18.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton18.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton18.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 100, 100));

        jButton19.setBackground(casillaNegra);
        jButton19.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton19.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton19.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 100, 100));

        jButton20.setBackground(casillaBlanca);
        jButton20.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton20.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton20.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 100, 100));

        a.setBackground(casillaNegra);
        a.setMaximumSize(new java.awt.Dimension(100, 100));
        a.setMinimumSize(new java.awt.Dimension(100, 100));
        a.setPreferredSize(new java.awt.Dimension(100, 100));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 100));

        jButton22.setBackground(casillaBlanca);
        jButton22.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton22.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton22.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 100, 100));

        jButton23.setBackground(casillaNegra);
        jButton23.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton23.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton23.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 100, 100));

        jButton24.setBackground(casillaBlanca);
        jButton24.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton24.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton24.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 100, 100));

        jButton25.setBackground(casillaNegra);
        jButton25.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton25.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton25.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 100, 100));

        jButton26.setBackground(casillaBlanca);
        jButton26.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton26.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton26.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 100, 100));

        jButton27.setBackground(casillaBlanca);
        jButton27.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton27.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton27.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 100, 100));

        jButton29.setBackground(casillaBlanca);
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton29.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton29.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton29.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 100, 100));

        jButton31.setBackground(casillaNegra);
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/caballo.png"))); // NOI18N
        jButton31.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton31.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton31.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 100));

        jButton32.setBackground(casillaBlanca);
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/torre.png"))); // NOI18N
        jButton32.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton32.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton32.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 100, 100));

        jButton33.setBackground(casillaNegra);
        jButton33.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton33.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton33.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 100, 100));

        jButton34.setBackground(casillaNegra);
        jButton34.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton34.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton34.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 100, 100));

        jButton35.setBackground(casillaBlanca);
        jButton35.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton35.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton35.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 100, 100));

        jButton36.setBackground(casillaBlanca);
        jButton36.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton36.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton36.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 100, 100));

        jButton37.setBackground(casillaNegra);
        jButton37.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton37.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton37.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 100, 100));

        jButton38.setBackground(casillaBlanca);
        jButton38.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton38.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton38.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 100, 100));

        jButton39.setBackground(casillaBlanca);
        jButton39.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton39.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton39.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 100));

        jButton40.setBackground(casillaNegra);
        jButton40.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton40.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton40.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 100, 100));

        jButton41.setBackground(casillaNegra);
        jButton41.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton41.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton41.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 100, 100));

        jButton42.setBackground(casillaBlanca);
        jButton42.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton42.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton42.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 100, 100));

        jButton43.setBackground(casillaNegra);
        jButton43.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton43.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton43.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 100, 100));

        jButton44.setBackground(casillaBlanca);
        jButton44.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton44.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton44.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 100, 100));

        jButton45.setBackground(casillaBlanca);
        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/rey.png"))); // NOI18N
        jButton45.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton45.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton45.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 700, 100, 100));

        jButton46.setBackground(casillaNegra);
        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/alfil.png"))); // NOI18N
        jButton46.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton46.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton46.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, 100, 100));

        jButton47.setBackground(casillaNegra);
        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/caballo.png"))); // NOI18N
        jButton47.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton47.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton47.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 700, 100, 100));

        jButton48.setBackground(casillaBlanca);
        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/alfil.png"))); // NOI18N
        jButton48.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton48.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton48.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 700, 100, 100));

        jButton49.setBackground(casillaNegra);
        jButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/reina.png"))); // NOI18N
        jButton49.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton49.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton49.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 700, 100, 100));

        jButton50.setBackground(casillaBlanca);
        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/torre.png"))); // NOI18N
        jButton50.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton50.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton50.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 100, 100));

        jButton51.setBackground(casillaNegra);
        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton51.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton51.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton51.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 100, 100));

        jButton52.setBackground(casillaBlanca);
        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton52.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton52.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton52.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 100, 100));

        jButton53.setBackground(casillaNegra);
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton53.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton53.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton53.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 100, 100));

        jButton54.setBackground(casillaBlanca);
        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton54.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton54.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton54.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 100, 100));

        jButton55.setBackground(casillaNegra);
        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton55.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton55.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton55.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, 100, 100));

        jButton56.setBackground(casillaBlanca);
        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton56.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton56.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton56.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 100, 100));

        jButton57.setBackground(casillaNegra);
        jButton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/torre.png"))); // NOI18N
        jButton57.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton57.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton57.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 700, 100, 100));

        jButton58.setBackground(casillaBlanca);
        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/caballo.png"))); // NOI18N
        jButton58.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton58.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton58.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 700, 100, 100));

        jButton59.setBackground(casillaNegra);
        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton59.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton59.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton59.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, 100, 100));

        jButton60.setBackground(casillaBlanca);
        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Blancas/peon.png"))); // NOI18N
        jButton60.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton60.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton60.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, 100, 100));

        jButton61.setBackground(casillaNegra);
        jButton61.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton61.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton61.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 100, 100));

        jButton62.setBackground(casillaBlanca);
        jButton62.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton62.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton62.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 100, 100));

        jButton63.setBackground(casillaNegra);
        jButton63.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton63.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton63.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 100, 100));

        jButton64.setBackground(casillaBlanca);
        jButton64.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton64.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton64.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 100, 100));

        jButton65.setBackground(casillaNegra);
        jButton65.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton65.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton65.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 100, 100));

        jButton66.setBackground(casillaNegra);
        jButton66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton66.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton66.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton66.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 100, 100));

        jButton67.setBackground(casillaBlanca);
        jButton67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton67.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton67.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton67.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 100, 100));

        jButton68.setBackground(casillaNegra);
        jButton68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton68.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton68.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton68.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 100, 100));

        jButton69.setBackground(casillaBlanca);
        jButton69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton69.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton69.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton69.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 100));

        jButton70.setBackground(casillaNegra);
        jButton70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton70.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton70.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton70.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, 100));

        jButton71.setBackground(casillaNegra);
        jButton71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton71.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton71.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton71.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, 100));

        jButton72.setBackground(casillaBlanca);
        jButton72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Piezas/Negras/peon.png"))); // NOI18N
        jButton72.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton72.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton72.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 100, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PresionarCasilla(2, 7, jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PresionarCasilla(0, 7, jButton2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PresionarCasilla(1, 7, jButton3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PresionarCasilla(5, 7, jButton4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        PresionarCasilla(4, 7, jButton5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        PresionarCasilla(3, 7, jButton6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PresionarCasilla(4, 4, jButton13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        PresionarCasilla(5, 4, jButton14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        PresionarCasilla(1, 4, jButton15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        PresionarCasilla(2, 4, jButton16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        PresionarCasilla(3, 4, jButton17);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        PresionarCasilla(0, 4, jButton18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        PresionarCasilla(0, 5, jButton19);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        PresionarCasilla(1, 5, jButton20);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        PresionarCasilla(2, 5, a);
    }//GEN-LAST:event_aActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        PresionarCasilla(3, 5, jButton22);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        PresionarCasilla(4, 5, jButton23);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        PresionarCasilla(5, 5, jButton24);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        PresionarCasilla(7, 4, jButton25);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        PresionarCasilla(6, 4, jButton26);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        PresionarCasilla(7, 5, jButton27);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        PresionarCasilla(6, 6, jButton29);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        PresionarCasilla(6, 7, jButton31);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        PresionarCasilla(7, 7, jButton32);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        PresionarCasilla(2, 3, jButton33);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        PresionarCasilla(0, 3, jButton34);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        PresionarCasilla(1, 3, jButton35);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        PresionarCasilla(5, 3, jButton36);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        PresionarCasilla(4, 3, jButton37);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        PresionarCasilla(3, 3, jButton38);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        PresionarCasilla(4, 2, jButton39);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        PresionarCasilla(3, 2, jButton40);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        PresionarCasilla(5, 2, jButton41);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        PresionarCasilla(0, 2, jButton42);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        PresionarCasilla(1, 2, jButton43);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        PresionarCasilla(2, 2, jButton44);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        PresionarCasilla(4, 0, jButton45);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        PresionarCasilla(5, 0, jButton46);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        PresionarCasilla(1, 0, jButton47);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        PresionarCasilla(2, 0, jButton48);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        PresionarCasilla(3, 0, jButton49);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        PresionarCasilla(0, 0, jButton50);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        PresionarCasilla(0, 1, jButton51);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        PresionarCasilla(1, 1, jButton52);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        PresionarCasilla(2, 1, jButton53);
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        PresionarCasilla(3, 1, jButton54);
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        PresionarCasilla(4, 1, jButton55);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        PresionarCasilla(5, 1, jButton56);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        PresionarCasilla(7, 0, jButton57);
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        PresionarCasilla(6, 0, jButton58);
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        PresionarCasilla(6, 1, jButton59);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        PresionarCasilla(7, 1, jButton60);
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        PresionarCasilla(7, 2, jButton61);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        PresionarCasilla(6, 2, jButton62);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        PresionarCasilla(6, 3, jButton63);
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        PresionarCasilla(7, 3, jButton64);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        PresionarCasilla(6, 5, jButton65);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        PresionarCasilla(7, 6, jButton66);
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        PresionarCasilla(4, 6, jButton67);
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        PresionarCasilla(5, 6, jButton68);
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        PresionarCasilla(0, 6, jButton69);
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        PresionarCasilla(1, 6, jButton70);
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        PresionarCasilla(3, 6, jButton71);
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        PresionarCasilla(2, 6, jButton72);
    }//GEN-LAST:event_jButton72ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    public static javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    public static javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    // End of variables declaration//GEN-END:variables
}
