package Controlador;

import Modelo.Buscaminas;
import Modelo.Casilla;
import Modelo.Tablero;
import Vista.BarraDeMenu;
import Vista.Boton;
import Vista.SwingVista;
import Vista.VentanaFin;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Control implements ActionListener, MouseListener {

    private SwingVista vista;
    private VentanaFin ventanaFin;
    private BarraDeMenu barraDeMenu;
    private Buscaminas modelo;

    public Control() {

    }

    public void inicio(int dificultad) {
        this.modelo = new Buscaminas(dificultad);
        this.vista = new SwingVista(dificultad);
        this.barraDeMenu = (BarraDeMenu) vista.getBarraDeMenu();
        this.ventanaFin = new VentanaFin();
        modelo.getTablero().llenarTablero();
        asignarCasillasBomba();
        agregarListenersBotones();
        agregarListenerBarra();
        agregarListenerVentanaFin();
    }


    private void agregarListenerBarra() {
        barraDeMenu.getDificultadIntermedio().addActionListener(this);
        barraDeMenu.getDificultadDificil().addActionListener(this);
        barraDeMenu.getDificultadExperto().addActionListener(this);
    }

    private void agregarListenerVentanaFin() {
        ventanaFin.getAceptarButton().addActionListener(this);
        ventanaFin.getSalirButton().addActionListener(this);
    }

    private void agregarListenersBotones() {
        for (int i = 0; i < vista.getTablero().length; i++) {
            for (int j = 0; j < vista.getTablero()[i].length; j++) {
                vista.getTablero()[i][j].addMouseListener(this);
            }
        }
    }

    private void asignarCasillasBomba() {
        for (Casilla casillaBomba : modelo.getTablero().getCasillasBomba()) {
            int posX = casillaBomba.getPosicionX();
            int posY = casillaBomba.getPosicionY();
            vista.agregarBotonBomba(posX, posY);
        }
    }

    private boolean evaluarVictoria() {
        System.out.println("CP " + modelo.getTablero().getCasillasPorDescubrir() + " -- MN: " + modelo.getTablero().getNumeroMinas());
        return modelo.getTablero().getCasillasPorDescubrir() == modelo.getTablero().getNumeroMinas();
    }

    private boolean evaluarDerrota() {
        return modelo.isDerrota();
    }

    private void reiniciarPrograma(int dificultad) {
        Control nuevoControl = new Control();
        nuevoControl.inicio(dificultad);
        vista.dispose();
        ventanaFin.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Boton botonPresionado = (Boton) e.getSource();

        int posX = Integer.parseInt(botonPresionado.getActionCommand().split(",")[0]);
        int posY = Integer.parseInt(botonPresionado.getActionCommand().split(",")[1]);

        //Click izquierdo
        if (e.getButton() == MouseEvent.BUTTON1) {
            Casilla casillaPresionada = modelo.getTablero().getCasilla(posX, posY);
            casillaPresionada.setDescubierto(true);
            modelo.getTablero().reducirCasillasPorDescubrir();
            if (vista.getBotonesBomba().contains(botonPresionado)) {
                vista.revelarBomba(posX, posY);
                modelo.setDerrota(true);
            } else {
                vista.revelarBoton(posX, posY, casillaPresionada.getRadar());
            }
        }

        //Click derecho
        if (e.getButton() == MouseEvent.BUTTON3) {
            Casilla casillaPresionada = modelo.getTablero().getCasilla(posX, posY);
            if (casillaPresionada.getBandera()) {
                vista.quitarBandera(posX, posY);
                casillaPresionada.setBandera(false);
            } else {
                vista.ponerBandera(posX, posY);
                casillaPresionada.setBandera(true);
            }
        }
        //Evaluar fin del juego
        if (evaluarDerrota()) {
            ventanaFin.setTitle("Has perdido");
            vista.setEnabled(false);
        }
        if (evaluarVictoria()) {
            ventanaFin.setTitle("Felicidades, has ganado");
            vista.setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        //Acciones de la ventana del fin del juego
        switch (action) {
            case "jugar" -> reiniciarPrograma(1);
            case "salir" -> System.exit(0);
            case "intermedio" -> reiniciarPrograma(1);
            case "dificil" -> reiniciarPrograma(2);
            case "experto" -> reiniciarPrograma(3);
        }
        /*
        if (e.getActionCommand().equals("jugar")) {
            reiniciarPrograma();
        }
        if (e.getActionCommand().equals("salir")) System.exit(0);
        //Acciones de la barra de menu

        if (e.getActionCommand().equals("intermedio")){
            reiniciarPrograma();
            modelo.setDificultad(1);
        }
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
