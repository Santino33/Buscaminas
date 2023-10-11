package Controlador;

import Modelo.Buscaminas;
import Modelo.Casilla;
import Modelo.Tablero;
import Vista.Boton;
import Vista.SwingVista;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Control implements ActionListener, MouseListener{

    private SwingVista vista;
    private Buscaminas modelo;

    public Control() {
        this.vista = new SwingVista();
        this.modelo = new Buscaminas(2);
    }

    public void inicio(){
        modelo.getTablero().llenarTablero();
        asignarCasillasBomba();
        agregarListenersBotones();

    }

    private void agregarListenersBotones() {
        for (int i = 0; i < vista.getTablero().length; i++){
            for (int j = 0; j < vista.getTablero()[i].length; j++){
                vista.getTablero()[i][j].addMouseListener(this);
            }
        }
    }

    private void asignarCasillasBomba(){
        for (Casilla casillaBomba : modelo.getTablero().getCasillasBomba()){
            int posX = casillaBomba.getPosicionX();
            int posY = casillaBomba.getPosicionY();
            vista.agregarBotonBomba(posX, posY);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Boton botonPresionado = (Boton) e.getSource();

        int posX = Integer.parseInt(botonPresionado.getActionCommand().split(",")[0]);
        int posY = Integer.parseInt(botonPresionado.getActionCommand().split(",")[1]);

        if (e.getButton() == MouseEvent.BUTTON1){
            Casilla casillaPresionada = modelo.getTablero().getCasilla(posX, posY);
            if (vista.getBotonesBomba().contains(botonPresionado)){
                casillaPresionada.setDescubierto(true);
                vista.revelarBomba(posX, posY);
            }
            else{
                vista.revelarBoton(posX, posY, casillaPresionada.getRadar());
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
