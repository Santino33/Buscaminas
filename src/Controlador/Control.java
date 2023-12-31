package Controlador;

import Modelo.Buscaminas;
import Modelo.Casilla;
import Modelo.Tablero;
import Vista.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Control implements ActionListener, MouseListener, IControl {

    private SwingVista vista;
    private VentanaFin ventanaFin;
    private BarraDeMenu barraDeMenu;
    private Ayuda instrucciones;
    private Buscaminas modelo;

    public Control() {

    }

    public void inicio(int dificultad) {
        this.modelo = new Buscaminas(dificultad);
        this.vista = new SwingVista(dificultad);
        this.barraDeMenu = (BarraDeMenu) vista.getBarraDeMenu();
        this.ventanaFin = new VentanaFin();
        this.instrucciones = new Ayuda();
        modelo.getTablero().llenarTablero();
        asignarCasillasBomba();
        agregarListenersBotones();
        agregarListenerBarra();
        agregarListenerVentanaFin();
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
                if (casillaPresionada.getRadar() == 0){
                    vista.revelarBoton(posX, posY, casillaPresionada.getRadar());
                }
                else {
                    vista.revelarBoton(posX, posY, casillaPresionada.getRadar());
                }
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
            case "jugar", "nuevoJuego" -> reiniciarPrograma(1);
            case "salir" -> System.exit(0);
            case "intermedio" -> reiniciarPrograma(1);
            case "dificil" -> reiniciarPrograma(2);
            case "experto" -> reiniciarPrograma(3);
            case "instrucciones" ->instrucciones.setVisible();
            case "cerrar-instrucciones" -> instrucciones.dispose();
        }
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

    @Override
    public void agregarListenerBarra() {
        barraDeMenu.getDificultadIntermedio().addActionListener(this);
        barraDeMenu.getDificultadDificil().addActionListener(this);
        barraDeMenu.getDificultadExperto().addActionListener(this);
        barraDeMenu.getInstrucciones().addActionListener(this);
        barraDeMenu.getCampoAbierto().addActionListener(this);
        instrucciones.getCerrar().addActionListener(this);
    }

    @Override
    public void agregarListenerVentanaFin() {
        ventanaFin.getAceptarButton().addActionListener(this);
        ventanaFin.getSalirButton().addActionListener(this);
    }

    @Override
    public void agregarListenersBotones() {
        for (int i = 0; i < vista.getTablero().length; i++) {
            for (int j = 0; j < vista.getTablero()[i].length; j++) {
                vista.getTablero()[i][j].addMouseListener(this);
            }
        }
    }

    @Override
    public void asignarCasillasBomba() {
        for (Casilla casillaBomba : modelo.getTablero().getCasillasBomba()) {
            int posX = casillaBomba.getPosicionX();
            int posY = casillaBomba.getPosicionY();
            vista.agregarBotonBomba(posX, posY);
        }
    }

    @Override
    public void revelarCampoAbierto(boolean isCampo) {

    }

    @Override
    public boolean evaluarVictoria() {
        return modelo.getTablero().getCasillasPorDescubrir() == modelo.getTablero().getNumeroMinas();
    }

    @Override
    public boolean evaluarDerrota() {
        return modelo.isDerrota();
    }

    @Override
    public void reiniciarPrograma(int dificultad) {
        Control nuevoControl = new Control();
        nuevoControl.inicio(dificultad);
        vista.dispose();
        ventanaFin.dispose();
    }
}
